package com.hl.kit.util.common;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 执行命令行的工具类
 * 
 * @author caozhejun
 *
 */
public class ExecuteUtil {

	private static final Log logger = LogFactory.getLog(ExecuteUtil.class);

	/**
	 * 同步执行命令行等待返回结果
	 * 
	 * @param command
	 * @return
	 * @throws IOException
	 */
	public static String execute(String command) throws IOException {
		Process proc = Runtime.getRuntime().exec(command);
		BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		return IOUtils.toString(br);
	}

	/**
	 * 异步执行命令行
	 * 
	 * @param command
	 */
	public static void asyncExecute(String command) {
		new Thread(() -> {
			try {
				logger.info("异步执行命令行结果:" + ExecuteUtil.execute(command));
			} catch (Exception e) {
				logger.error("异步执行命令行发生异常", e);
			}
		}).start();
	}

}
