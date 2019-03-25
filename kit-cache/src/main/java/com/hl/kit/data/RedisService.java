package com.hl.kit.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 
 * redis服务
 * 设置object缓存，从缓存获取object，删除缓存中的object
 * 设置String缓存，从缓存获取String，删除缓存中的String
 * 
 * @author dongwenbin
 * @version [1.0, 2018年8月23日]
 * @see
 * @since [redis服务]
 */
@Service
public class RedisService {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Resource(name = "stringRedisTemplate")
	private ValueOperations<String, String> valOpsStr;

	//	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	public RedisTemplate<Object, Object> getRedisTemplate() {
		return redisTemplate;
	}

	@Resource(name = "redisTemplate")
	private ValueOperations<Object, Object> valOpsObj;

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Autowired
	public void setRedisTemplate(RedisTemplate redisTemplate) {
		//避免对象缓存键出现，类似\xac\xed\x00\x05t\x00这种字符串
		RedisSerializer stringSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringSerializer);
//	    redisTemplate.setValueSerializer(stringSerializer);
		redisTemplate.setHashKeySerializer(stringSerializer);
//	    redisTemplate.setHashValueSerializer(stringSerializer);
		this.redisTemplate = redisTemplate;
	}

	/**
	 * 根据指定key获取String
	 *
	 * @param key
	 * @return
	 */
	public String getStr(String key) {
		return valOpsStr.get(key);
	}

	/**
	 * 设置Str缓存
	 *
	 * @param key
	 * @param val
	 */
	public void setStr(String key, String val) {
		if (val!=null)
		valOpsStr.set(key, val);
	}


	/****
	 * 设置Str缓存
	 * @param key
	 * @param val
	 * @param time
	 */
	public void setStr(String key, String val, long time) {
		if (val!=null)
		valOpsStr.set(key, val, time, TimeUnit.SECONDS);
	}

	/**
	 * 删除指定key
	 *
	 * @param key
	 */
	public void del(String key) {
		stringRedisTemplate.delete(key);
	}

	/**
	 * 根据指定o获取Object
	 *
	 * @param o
	 * @return
	 */
	public Object getObj(String o) {
		return valOpsObj.get(o);
	}

	/**
	 * 设置obj缓存
	 *
	 * @param o1
	 * @param o2
	 */
	public void setObj(String o1, Object o2) {
		valOpsObj.set(o1, o2);
	}

	/**
	 * 删除Obj缓存
	 *
	 * @param o
	 */
	public void delObj(String o) {
		redisTemplate.delete(o);
	}


	/**
	 * 向一张hash表中放入数据,如果不存在将创建
	 *
	 * @param key   键
	 * @param item  项
	 * @param value 值
	 * @return true 成功 false失败
	 */
	public boolean hset(String key, String item, Object value) {
		try {
			redisTemplate.opsForHash().put(key, item, value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * HashGet
	 *
	 * @param key  键 不能为null
	 * @param item 项 不能为null
	 * @return 值
	 */
	public Object hget(String key, String item) {
		return redisTemplate.opsForHash().get(key, item);
	}

	/**
	 * 获取hashKey对应的所有键值
	 *
	 * @param key 键
	 * @return 对应的多个键值
	 */
	public Map<Object, Object> hmget(String key) {
		return redisTemplate.opsForHash().entries(key);
	}
}
