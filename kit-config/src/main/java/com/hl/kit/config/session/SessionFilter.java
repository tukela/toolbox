//package com.hl.kit.config.session;
//
//import com.anpotech.tms.web.publi.model.constant.ConstantData;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component("sessionFilter")
//public class SessionFilter implements Filter {
//
//
//	private int timeout = ConstantData.SESSION_TIMEOUT;
//
//	@Value("${work_machine_id}")
//	private int workMachineId = ConstantData.WORK_MACHINE_ID;
//
//	@Value("${data_center_id}")
//	private int dataCenterId = ConstantData.DATA_CENTER_ID;
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		ConstantData.WORK_MACHINE_ID = this.workMachineId;
//		ConstantData.DATA_CENTER_ID = this.dataCenterId;
//	}
//
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest request = (HttpServletRequest) req;
//		HttpServletResponse response = (HttpServletResponse) res;
//		SessionRequestWrapper httpRequestWraper = new SessionRequestWrapper(request, response, timeout);
//		chain.doFilter(httpRequestWraper, response);
//	}
//
//	@Override
//	public void destroy() {
//
//	}
//
//
//
//}
