package com.hl.kit.config.Listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author: honglei
 * @Date: 2019/3/26 16:17
 * @Version: 1.0
 * @See:
 * @Description:
 */
public class SessionListener implements HttpSessionListener {

    private static final Log logger = LogFactory.getLog(SessionListener.class);

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