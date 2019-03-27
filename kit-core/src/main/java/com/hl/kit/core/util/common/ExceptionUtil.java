package com.hl.kit.core.util.common;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常工具类
 * 
 * @author caozj
 * 
 */
public class ExceptionUtil {

  /**
   * 获取异常的堆栈信息
   * 
   * @param t
   * @return
   */
  public static String getStackTrace(Throwable t) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    try {
      t.printStackTrace(pw);
      return sw.toString();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      IOUtils.closeQuietly(pw);
    }
    return StringUtils.EMPTY;
  }
}
