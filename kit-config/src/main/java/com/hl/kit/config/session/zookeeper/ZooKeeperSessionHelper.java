//package com.hl.kit.config.session.zookeeper;
//
//import com.anpotech.tms.framework.common.EnvironmentUtil;
//import com.anpotech.tms.framework.core.zookeeper.ZookeeperUtil;
//import com.anpotech.tms.web.publi.model.constant.ConstantData;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.zookeeper.KeeperException;
//import org.apache.zookeeper.ZooKeeper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//
///**
// * zookeeper工具类
// *
// * @author caozj
// *
// */
//@Component
//public class ZooKeeperSessionHelper {
//
//	private static final Log logger = LogFactory.getLog(ZooKeeperSessionHelper.class);
//	public static String rootPath = "/SESSIONS";
//	private static String timePath = "/TIME";
//	private String hosts;
//
//	@Autowired
//	private EnvironmentUtil environmentUtil;
//
//	/**
//	 * 初始化
//	 */
//	@PostConstruct
//	private void init() {
//		if ("zookeeper".equalsIgnoreCase(environmentUtil.get("distribute.type"))) {
//			hosts = environmentUtil.get("session.zookeeper.servers");
//			createGroupNode(rootPath);
//		}
//	}
//
//	/**
//	 * 获取zookeeper对应路径中的对象
//	 *
//	 * @param path
//	 *            路径
//	 * @return 路径中存的对象
//	 */
//	public Object get(String path) {
//		ZooKeeper zk = null;
//		Object result = null;
//		try {
//			zk = ZookeeperUtil.connect(hosts);
//			result = ZookeeperUtil.get(path, zk);
//			if (result != null) {
//				setTime(path, zk);
//			}
//		} catch (KeeperException e) {
//			logger.error(e);
//		} catch (InterruptedException e) {
//			logger.error(e);
//		} finally {
//			ZookeeperUtil.close(zk);
//		}
//		return result;
//	}
//
//	/**
//	 * 创建一个组节点
//	 */
//	public void createGroupNode(String path) {
//		ZooKeeper zk = null;
//		try {
//			zk = ZookeeperUtil.connect(hosts);
//			ZookeeperUtil.createGroupNode(path, zk);
//		} catch (KeeperException e) {
//			logger.error(e);
//		} catch (InterruptedException e) {
//			logger.error(e);
//		} finally {
//			ZookeeperUtil.close(zk);
//		}
//	}
//
//	/**
//	 * 删除组节点
//	 *
//	 * @param path
//	 */
//	public void delete(String path) {
//		ZooKeeper zk = null;
//		try {
//			zk = ZookeeperUtil.connect(hosts);
//			ZookeeperUtil.delete(path, zk);
//		} catch (KeeperException e) {
//			logger.error(e);
//		} catch (InterruptedException e) {
//			logger.error(e);
//		} finally {
//			ZookeeperUtil.close(zk);
//		}
//	}
//
//	/**
//	 * 保存
//	 *
//	 * @param path
//	 * @param value
//	 */
//	public void save(String path, Object value) {
//		ZooKeeper zk = null;
//		try {
//			zk = ZookeeperUtil.connect(hosts);
//			ZookeeperUtil.createGroupNode(path, zk);
//			ZookeeperUtil.saveData(path, value, zk);
//			setTime(path, zk);
//		} catch (KeeperException e) {
//			logger.error(e);
//		} catch (InterruptedException e) {
//			logger.error(e);
//		} finally {
//			ZookeeperUtil.close(zk);
//		}
//	}
//
//	/**
//	 * 清空所有过期的数据
//	 */
//	public void clearTimeoutData() {
//		ZooKeeper zk = null;
//		try {
//			zk = ZookeeperUtil.connect(hosts);
//			List<String> sessions = zk.getChildren(rootPath, false);
//			if (CollectionUtils.isEmpty(sessions)) {
//				return;
//			}
//			long now = System.currentTimeMillis();
//			for (String session : sessions) {
//				String time = rootPath + "/" + session + timePath;
//				Long lastAccessTime = (Long) ZookeeperUtil.get(time, zk);
//				if (lastAccessTime != null && now - lastAccessTime > ConstantData.SESSION_TIMEOUT) {
//					ZookeeperUtil.delete(rootPath + "/" + session, zk);
//				}
//			}
//		} catch (KeeperException e) {
//			logger.error(e);
//		} catch (InterruptedException e) {
//			logger.error(e);
//		} finally {
//			ZookeeperUtil.close(zk);
//		}
//	}
//
//	private void setTime(String path, ZooKeeper zk) throws KeeperException, InterruptedException {
//		String subPath = path + timePath;
//		ZookeeperUtil.createGroupNode(subPath, zk);
//		Long time = System.currentTimeMillis();
//		ZookeeperUtil.saveData(subPath, time, zk);
//	}
//}
