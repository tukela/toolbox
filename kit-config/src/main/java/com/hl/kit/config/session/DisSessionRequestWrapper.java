package com.hl.kit.config.session;


import com.hl.kit.config.webUtils.CookieUtil;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisSessionRequestWrapper extends HttpServletRequestWrapper {
	private final static String SESSIONID_COOKIE_NAME="cookie";
	private final String sid;

	private HttpSession session;

	private static int expiry =8000; //ConstantData.SESSION_TIMEOUT;

	public static void setExpiry(int expiry) {
		if (expiry < 100) {
			throw new IllegalArgumentException("session超时时间不能小于100[" + expiry + "].");
		}
		DisSessionRequestWrapper.expiry = expiry;
	}

	protected HttpServletResponse response;

	public DisSessionRequestWrapper(HttpServletRequest request, HttpServletResponse response, int expiry) {
		super(request);
		this.response = response;
		this.sid = this.createJsessionIdCookie();
		
		setExpiry(expiry);
	}

	private String createJsessionIdCookie() {
		String sid = CookieUtil.getCookie(SESSIONID_COOKIE_NAME, this);
		if (StringUtils.isEmpty(sid)) {
			// 写cookie
			sid = java.util.UUID.randomUUID().toString();
			CookieUtil.setCookie(SESSIONID_COOKIE_NAME, sid, this, response);
			this.setAttribute(SESSIONID_COOKIE_NAME, sid);
		}
		return sid;
	}

	@Override
	public HttpSession getSession(boolean create) {
		if (session != null) {
			return session;
		}
		if (create) {
			this.session = new HttpSessionWrapper(this.sid, expiry);
			return session;
		} else {
			return null;
		}
	}

	@Override
	public HttpSession getSession() {
		return this.getSession(true);
	}
}
