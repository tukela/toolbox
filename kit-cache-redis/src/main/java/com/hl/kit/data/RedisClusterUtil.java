package com.hl.kit.data;


import com.hl.kit.util.common.SerializeUtil;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 集群版redis工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class RedisClusterUtil {

	private Log logger = LogFactory.getLog(this.getClass());

	private JedisCluster jedisCluster = null;

	private String redisClusterAddress;

	@Autowired
	private Environment env;

	@PostConstruct
	private void init() {
		if (env==null){
			return;
		}
		redisClusterAddress = env.getProperty("redis.cluster.address");
		if (redisClusterAddress==null||redisClusterAddress.length()==0) {
			logger.info("没有配置redis集群(redis.cluster.address)[ip1:port1,ip2:port2]，不启动redis集群客户端");
			return;
		}
		String[] address = redisClusterAddress.split(",");
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		for (String node : address) {
			if (node==null||node.length()==0) {
				continue;
			}
			String[] hostAndPort = node.split(":");
			if (hostAndPort.length != 2) {
				continue;
			}
			HostAndPort hp = new HostAndPort(hostAndPort[0], NumberUtils.toInt(hostAndPort[1], 6379));
			nodes.add(hp);
		}
		jedisCluster = new JedisCluster(nodes);
	}

	public Object get(String key) {
		byte[] data = jedisCluster.get(key.getBytes());
		if (data == null || data.length <= 0) {
			return null;
		}
		return SerializeUtil.unserialize(data);
	}

	public void set(String key, Object value) {
		jedisCluster.set(key.getBytes(), SerializeUtil.serialize(value));
	}

	public void set(String key, Object value, int second) {
		jedisCluster.set(key.getBytes(), SerializeUtil.serialize(value));
		jedisCluster.expire(key.getBytes(), second);
	}

	public void hset(String key, String field, Object value) {
		jedisCluster.hset(key.getBytes(), field.getBytes(), SerializeUtil.serialize(value));
	}

	public Object hget(String key, String field) {
		byte[] data = jedisCluster.hget(key.getBytes(), field.getBytes());
		if (data == null || data.length <= 0) {
			return null;
		}
		return SerializeUtil.unserialize(data);
	}

	public void remove(String key) {
		jedisCluster.del(key.getBytes());
	}

	public long getAutoId(String key) {
		return jedisCluster.incr(key.getBytes());
	}

	public void lpush(String key, Object value) {
		jedisCluster.lpush(key.getBytes(), SerializeUtil.serialize(value));
	}

	public void rpush(String key, Object value) {
		jedisCluster.rpush(key.getBytes(), SerializeUtil.serialize(value));
	}

	public List<Object> lrange(String key) {
		List<Object> result = null;
		List<byte[]> list = jedisCluster.lrange(key.getBytes(), 0, -1);
		result = new ArrayList<Object>(list.size());
		for (byte[] o : list) {
			result.add(SerializeUtil.unserialize(o));
		}
		return result;
	}

	public Object lpop(String key) {
		byte[] bs = jedisCluster.lpop(key.getBytes());
		if (bs == null || bs.length <= 0) {
			return null;
		}
		return SerializeUtil.unserialize(bs);
	}

	public Object rpop(String key) {
		byte[] bs = jedisCluster.rpop(key.getBytes());
		if (bs == null || bs.length <= 0) {
			return null;
		}
		return SerializeUtil.unserialize(bs);
	}

	public Object lindex(String key, int index) {
		byte[] bs = jedisCluster.lindex(key.getBytes(), index);
		if (bs == null || bs.length <= 0) {
			return null;
		}
		return SerializeUtil.unserialize(bs);
	}

	public long llen(String key) {
		return jedisCluster.llen(key.getBytes());
	}

	public boolean tryLock(String key) {
		boolean lock = false;
		Long exist = jedisCluster.setnx(key.getBytes(), key.getBytes());
		if (exist > 0) {
			lock = true;
		}
		return lock;
	}

	public void releaseLock(String key) {
		jedisCluster.del(key.getBytes());
	}

}
