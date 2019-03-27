package com.hl.kit.core.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionRequestWrapper extends HttpServletRequestWrapper {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected boolean hasSessionRequestWrapper;

	public SessionRequestWrapper(HttpServletRequest request, HttpServletResponse response, int expiry) {
		super(request);
		this.response = response;
		this.request = new DisSessionRequestWrapper(request, response, expiry);
		
		//需要使用redis等其他创建session方式，放开true
//		hasSessionRequestWrapper = true;
		
		
		hasSessionRequestWrapper = false;
	}

	@Override
	public HttpSession getSession(boolean create) {
		HttpSession session;
		if (hasSessionRequestWrapper) 
		{
			session = this.request.getSession(create);
			if (null != session)
			{
				session.setMaxInactiveInterval(-1);//设置单位为秒，设置为-1永不过期
			}
			return session;
		} 
		else 
		{
			session = super.getSession(create);
			if (null != session)
			{
				session.setMaxInactiveInterval(-1);//设置单位为秒，设置为-1永不过期
			}
			return session;
		}

	}

	@Override
	public HttpSession getSession() {
		HttpSession session;
		if (hasSessionRequestWrapper) 
		{
			session = this.request.getSession();
			if (null != session)
			{
				session.setMaxInactiveInterval(-1);//设置单位为秒，设置为-1永不过期
			}
			return session;
		} 
		else 
		{
			session = super.getSession();
			if (null != session)
			{
				session.setMaxInactiveInterval(-1);//设置单位为秒，设置为-1永不过期
			}
			return session;
		}
	}

	@Override
	public String getParameter(String name) {
		String[] values = this.getParameterValues(name);
		if (values == null) {
			return null;
		} else {
			return values[0];
		}
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] values=null;
//		if (PageParameterUtil.isSpecialName(name)) {
//			String value = PageParameterUtil.getParameterValues(request, response, name);
//			values = new String[] { value };
//		} else {
//			// 当前不少特殊的参数名称，直接返回
//			values = super.getParameterValues(name);
//		}
		return values;
	}

	@Override
	public Object getAttribute(String name) {
		return super.getAttribute(name);
	}

}
