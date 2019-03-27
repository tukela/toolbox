package com.hl.kit.core.session.sessionService.Imp;
import com.hl.kit.core.session.sessionService.SessionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * SessionService的默认实现
 *
 * @author: honglei
 *
 */
public class SessionServiceDefaultImpl implements SessionService {

	protected static final Log logger = LogFactory.getLog(SessionServiceDefaultImpl.class);

	private Map<String, Object> sessionMap;

	private static final class SessionServiceHolder {
		private static final SessionServiceDefaultImpl instance = new SessionServiceDefaultImpl();
	}

	public static SessionServiceDefaultImpl getInstance() {
		return SessionServiceHolder.instance;
	}

	private SessionServiceDefaultImpl() {
//		redisUtil = (RedisUtil) ApplicationContextUtil.getBean(RedisUtil.class);
		sessionMap = new HashMap<String, Object>();
	}

	/**
	 * 根据session id获取session key.
	 * 
	 * @param sid
	 * @return
	 */
	private String getSessionKey(String sid) {
		return "sid:" + sid;
	}

	/**
	 * 根据session id获取session对象.
	 * 
	 * @param sid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSession(String sid) {
		String key = this.getSessionKey(sid);
//		return (Map<String, Object>) (redisUtil.get(key));
		return (Map<String, Object>) sessionMap.get(key);
	}

	/**
	 * 保存Session对象.
	 * 
	 * @param sid
	 *            id
	 * @param session
	 *            map对象
	 * @param seconds
	 *            保存时间
	 */
	public void saveSession(String sid, Map<String, Object> session, int seconds) {
		String key = this.getSessionKey(sid);
//		redisUtil.set(key, session, seconds);
		
		sessionMap.put(key, session);
	}

	/**
	 * 移除session对象.
	 * 
	 * @param sid
	 */
	public void removeSession(String sid) {
		String key = this.getSessionKey(sid);
//		redisUtil.remove(key);
		sessionMap.remove(key);
	}

}
