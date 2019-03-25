package com.hl.kit.config.session.sessionService;

import com.hl.kit.config.session.sessionService.Imp.SessionServiceDefaultImpl;
//import com.hl.kit.config.session.sessionService.Imp.SessionServiceRedisImpl;
//import com.hl.kit.config.session.sessionService.Imp.SessionServiceZookeeperImpl;
import com.hl.kit.config.session.sessionService.SessionService;

/**
 * SessionService工厂类
 *
 * @author caozj
 *
 */
public class SessionServiceFactory {

	public static SessionService getInstance(String type) {
		SessionService service = null;
		if ("redis".equalsIgnoreCase(type))
		{
			//service = SessionServiceRedisImpl.getInstance();
		}
		else if ("zookeeper".equalsIgnoreCase(type))
		{
			//service = SessionServiceZookeeperImpl.getInstance();
		}
		else if ("default".equalsIgnoreCase(type))
		{
			service = SessionServiceDefaultImpl.getInstance();
		}

		return service;
	}
}
