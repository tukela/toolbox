package com.hl.kit.core.session.sessionService.Imp;//package com.hl.kit.config.session.sessionService.Imp;
//
//import com.hl.kit.config.session.sessionService.SessionService;
//import com.hl.kit.config.session.zookeeper.ZooKeeperSessionHelper;
//
//import java.util.Map;
//
///**
// * SessionService的zookeeper实现
// *
// * @author caozj
// *
// */
//public class SessionServiceZookeeperImpl implements SessionService {
//
//	private ZooKeeperSessionHelper zooKeeperSessionHelper;
//
//	private SessionServiceZookeeperImpl() {
//		//zooKeeperSessionHelper = (ZooKeeperSessionHelper) ApplicationContextUtil.getBean("zooKeeperSessionHelper");
//	}
//
//	private static final class SessionServiceZookeeperImplHolder {
//		private static final SessionServiceZookeeperImpl instance = new SessionServiceZookeeperImpl();
//	}
//
//	public static SessionServiceZookeeperImpl getInstance() {
//		return SessionServiceZookeeperImplHolder.instance;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public Map<String, Object> getSession(String sid) {
//		return (Map<String, Object>) zooKeeperSessionHelper.get(getSessionKey(sid));
//	}
//
//	@Override
//	public void saveSession(String sid, Map<String, Object> session, int seconds) {
//		zooKeeperSessionHelper.save(getSessionKey(sid), session);
//	}
//
//	@Override
//	public void removeSession(String sid) {
//		zooKeeperSessionHelper.delete(getSessionKey(sid));
//	}
//
//	private String getSessionKey(String sid) {
//		return ZooKeeperSessionHelper.rootPath + "/" + sid;
//	}
//
//}
