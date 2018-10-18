package com.hl.kit.web.utils.session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class DisSessionListener implements HttpSessionListener {

	private static final Log logger = LogFactory.getLog(DisSessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.info("创建session:" + se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		se.getSession().invalidate();
		logger.info("清空session:" + se.getSession().getId());
	}

}
