//package com.hl.kit.config;
//
//import com.anpotech.tms.framework.core.exception.ForbidException;
//import com.anpotech.tms.framework.core.exception.LoginException;
//import com.anpotech.tms.framework.core.util.common.ExceptionUtil;
//import com.anpotech.tms.framework.core.util.json.JsonResult;
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//
//@ControllerAdvice
//class GlobalExceptionHandler {
//
//	private static final Log logger = LogFactory.getLog(GlobalExceptionHandler.class);
//
//	public static final String DEFAULT_ERROR_VIEW = "error";
//
//	@Value("${page.login}")
//	private String loginPage;
//
//	@Value("${page.error}")
//	private String errorPage;
//
//	@Value("${page.forbid}")
//	private String forbidPage;
//
//	@PostConstruct
//	private void init() {
//		loginPage = StringUtils.defaultIfEmpty(loginPage, "login");
//		errorPage = StringUtils.defaultIfEmpty(errorPage, "error/error");
//		forbidPage = StringUtils.defaultIfEmpty(forbidPage, "error/forbid");
//	}
//
//	@ExceptionHandler(value = Throwable.class)
//	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//		logger.error("发生异常", e);
//		ModelAndView model = new ModelAndView();
//		if (isJsonException(req)) {
//			model.setViewName("message");
//			String message = new JsonResult(e.getMessage(), 400).toJson();
//			String callback = req.getParameter("callback");
//			if (StringUtils.isNotEmpty(callback)) {
//				message = callback + "(" + message + ")";
//			}
//			model.addObject("message", message);
//		} else if (e instanceof LoginException) {
//			model.addObject("top", true);
//			model.setViewName(loginPage);
//		} else if (e instanceof ForbidException) {
//			model.setViewName(forbidPage);
//		} else {
//			model.setViewName(errorPage);
//			model.addObject("message", ExceptionUtil.getStackTrace(e));
//		}
//		return model;
//	}
//
//	/**
//	 * 判断是否是json格式请求，如果是json格式请求，返回json格式错误信息
//	 *
//	 * @param request
//	 * @return
//	 */
//	private boolean isJsonException(HttpServletRequest request) {
//		boolean isJson = false;
//		if (request.getParameter("json") != null || request.getParameter("jsonp") != null
//				|| (request.getHeader("Accept") != null && request.getHeader("Accept").indexOf("json") > -1
//						|| request.getRequestURI().endsWith(".json") || request.getRequestURI().endsWith(".jsonp"))) {
//			isJson = true;
//		}
//		return isJson;
//	}
//}