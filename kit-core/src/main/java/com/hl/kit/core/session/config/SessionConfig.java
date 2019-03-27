package com.hl.kit.core.session.config;


import com.hl.kit.core.Listener.SessionListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSessionListener;

/**
 * session的配置类
 *
 * @author: honglei
 *
 */
@ConditionalOnBean(SessionListener.class)
@Configuration
public class SessionConfig {

	private static final Log log = LogFactory.getLog(SessionConfig.class);

	@Bean
	public ServletListenerRegistrationBean<HttpSessionListener> disSessionListener() {
		log.info("=====================init session listener Configuration==============================");
		ServletListenerRegistrationBean<HttpSessionListener> servletListenerRegistrationBean =
				new ServletListenerRegistrationBean<HttpSessionListener>();
		servletListenerRegistrationBean.setListener(null);
		return servletListenerRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		log.info("=====================init session filter Configuration==============================");
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setName("sessionFilter");
		filterRegistrationBean.setFilter(null);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
}
