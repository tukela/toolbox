package com.hl.kit.config.interptor;

import com.anpotech.tms.framework.common.EnvironmentUtil;
import com.anpotech.tms.framework.core.exception.ForbidException;
import com.anpotech.tms.framework.core.util.applicationcontext.ApplicationContextUtil;
import com.anpotech.tms.framework.core.util.common.PathUtil;
import com.anpotech.tms.framework.core.util.common.ServerUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限拦截器
 * 
 * @author caozj
 */
public class IpInterceptor implements HandlerInterceptor {

	private String excludeUrl;

	private String excludeIp;

	private List<String> excludeUrls = new ArrayList<String>();

	private List<String> excludeIps = new ArrayList<String>();

	public IpInterceptor() {
		super();
		init();
	}

	private void init() {
		EnvironmentUtil environmentUtil = ApplicationContextUtil.getBean(EnvironmentUtil.class);
		excludeUrl = environmentUtil.get("ip.interceptor.exclude.url");
		excludeIp = environmentUtil.get("ip.interceptor.exclude.ip");
		String[] urls = excludeUrl.split(",");
		for (String url : urls) {
			if (StringUtils.isNotEmpty(url)) {
				excludeUrls.add(url.trim());
			}
		}
		String[] ips = excludeIp.split(",");
		for (String ip : ips) {
			if (StringUtils.isNotEmpty(ip)) {
				excludeIps.add(ip.trim());
			}
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUri = getRequestUri(request);
		for (String excludeUrl : excludeUrls) {
			if (PathUtil.match(requestUri, excludeUrl)) {
				return true;
			}
		}
		String ip = ServerUtil.getProxyIp(request);
		for (String excludeIp : excludeIps) {
			if (excludeIp.equals(ip)) {
				return true;
			}
		}
		throw new ForbidException("您没有权限访问,所以不能访问" + requestUri + ",ip:" + ip);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	/**
	 * 从request中取出uri.经过处理，已经过滤了上下文路径
	 * 
	 * @param request
	 * @return
	 */
	private String getRequestUri(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		if (StringUtils.isNotEmpty(contextPath) && !"/".equals(contextPath)) {
			uri = uri.substring(contextPath.length());
		}
		return uri;
	}

}
