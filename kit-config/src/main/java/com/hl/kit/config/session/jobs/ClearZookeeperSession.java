//package com.hl.kit.config.session.jobs;
//
//import com.anpotech.tms.framework.common.EnvironmentUtil;
//import com.anpotech.tms.framework.core.session.zookeeper.ZooKeeperSessionHelper;
//import com.anpotech.tms.framework.core.util.applicationcontext.ApplicationContextUtil;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * 当分布式session使用zookeeper实现时，定时清过期session中的数据
// *
// * @author caozj
// *
// */
//@Component
//public class ClearZookeeperSession {
//
//	private static final Log logger = LogFactory.getLog(ClearZookeeperSession.class);
//
//	@Autowired
//	private EnvironmentUtil environmentUtil;
//
//	@Scheduled(cron = "0 0/8 * * * *")
//	private void initJobs() {
//		if ("zookeeper".equalsIgnoreCase(environmentUtil.get("distribute.type"))) {
//			logger.info("开始清过期zookeeper的session数据");
//			((ZooKeeperSessionHelper) ApplicationContextUtil.getBean("zooKeeperSessionHelper")).clearTimeoutData();
//			logger.info("完成清过期zookeeper的session数据");
//		}
//	}
//
//}
