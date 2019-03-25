package com.hl.kit.config.interptor;

/**
 * 拦截器配置对象
 * 
 * @author caozhejun
 *
 */
public class InterceptorData {

	/**
	 * 拦截器实现类的完整路径
	 */
	private String interceptorClass;

	/**
	 * 要拦截的url地址，支持模糊匹配
	 */
	private String url;

	public String getInterceptorClass() {
		return interceptorClass;
	}

	public void setInterceptorClass(String interceptorClass) {
		this.interceptorClass = interceptorClass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InterceptorData [interceptorClass=");
		builder.append(interceptorClass);
		builder.append(", url=");
		builder.append(url);
		builder.append("]");
		return builder.toString();
	}

}
