package com.hl.kit.core.webUtils;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;

public class XssUtil {
	static private String WRITE_SPACE = " \t\n\r\f";

	static private final String[] XSS_STRINGS = new String[] {
			"</script>", //
			"<script",//
			"src=",//
			"eval(",//
			"expression(",//
			"javascript:",//
			"vbscript:", //
			"onload=",//
			"&#"// &#0000106 , &#106; ...
			, "onAbort=", "onActivate=", "onAfterPrint=", "onAfterUpdate=", "onBeforeActivate=", "onBeforeCopy=",
			"onBeforeCut=", "onBeforeDeactivate=", "onBeforeEditFocus=", "onBeforePaste=", "onBeforePrint=",
			"onBeforeUnload=", "onBegin=", "onBlur=", "onBounce=", "onCellChange=", "onChange=", "onClick=",
			"ontextMenu=", "ontrolSelect=", "onCopy=", "onCut=", "onDataAvailable=", "onDataSetChanged=",
			"onDataSetComplete=", "onDblClick=", "onDeactivate=", "onDrag=", "onDragEnd=", "onDragLeave=",
			"onDragEnter=", "onDragOver=", "onDragDrop=", "onDrop=", "onEnd=", "onError=", "onErrorUpdate=",
			"onFilterChange=", "onFinish=", "onFocus=", "onFocusIn=", "onFocusOut=", "onHelp=", "onKeyDown=",
			"onKeyPress=", "onKeyUp=", "onLayoutComplete=", "onLoad=", "onLoseCapture=", "onMediaComplete=",
			"onMediaError=", "onMouseDown=", "onMouseEnter=", "onMouseLeave=", "onMouseMove=", "onMouseOut=",
			"onMouseOver=", "onMouseUp=", "onMouseWheel=", "onMove=", "onMoveEnd=", "onMoveStart=", "onOutOfSync=",
			"onPaste=", "onPause=", "onProgress=", "onPropertyChange=", "onReadyStateChange=", "onRepeat=", "onReset=",
			"onResize=", "onResizeEnd=", "onResizeStart=", "onResume=", "onReverse=", "onRowsEnter=", "onRowExit=",
			"onRowDelete=", "onRowInserted=", "onScroll=", "onSeek=", "onSelect=", "onChange=", "onSelectStart=",
			"onStart=", "onStop=", "onSyncRestored=", "onSubmit=", "onTimeError=", "onTrackChange=", "onUnload=",
			"onURLFlip=", "seekSegmentTime=" };

	static {
		for (int i = 0; i < XSS_STRINGS.length; i++) {
			XSS_STRINGS[i] = XSS_STRINGS[i].toLowerCase();
		}
	}

	/**
	 * 判断字符串是否有XSS攻击风险
	 * 
	 * @param value
	 * @return
	 */
	public static boolean hasXSS(String value) {
		if (StringUtils.isEmpty(value)) {
			return false;
		}

		value = removeWriteSpaceAndLower(value);

		// Remove all sections that match a pattern
		for (String chars : XSS_STRINGS) {
			if (value.indexOf(chars) >= 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 检查字符串是否有XSS攻击字符串
	 * 
	 * @param str
	 * @throws Exception
	 *             有Xss攻击时抛出
	 */
	@SuppressWarnings("unused")
	public static void checkXSS(String str) throws Exception {
		if (true) {
			return;
		}
		String exception = checkXSSForExceptionMessage(str);
		if (exception == null) {
			return;
		} else {
			throw new Exception(exception);
		}
	}

	/**
	 * 检查request.getParameterMap() 是否有异常攻击
	 * 
	 * @param parameterMap
	 * @throws Exception
	 */
	public static void checkXSS(Map<String, Object> parameterMap) throws Exception {
		Set<Map.Entry<String, Object>> entrySet = parameterMap.entrySet();
		for (Map.Entry<String, Object> entry : entrySet) {
			String key = (String) entry.getKey();
			Object value = entry.getValue();
			if (value == null) {
				continue;
			}
			if (value.getClass().isArray()) {
				String[] values = (String[]) value;
				for (int i = 0; i < values.length; i++) {
					checkXSS(values[i], key);
				}
			} else {
				checkXSS(String.valueOf(value), key);
			}
		}
	}

	private static void checkXSS(String str, String key) throws Exception {
		String exception = checkXSSForExceptionMessage(str);
		if (exception == null) {
			return;
		} else {
			String attachExceptionMsg = ", map key:" + key;
			throw new Exception(exception + attachExceptionMsg);
		}
	}

	private static String checkXSSForExceptionMessage(String str) throws Exception {
		if (str == null) {
			return null;
		}
		if (isNormalString(str)) {
			// 正常字符串
			return null;
		}

		str = removeWriteSpaceAndLower(str);

		// Remove all sections that match a pattern
		for (String xss : XSS_STRINGS) {
			if (str.indexOf(xss) >= 0) {
				return "xss string:[" + str + "] protected by:" + xss;
			}
		}
		return null;
	}

	protected static boolean isNormalString(String value) {
		char[] arr = value.toCharArray();
		for (char c : arr) {
			if (c >= 'a' && c <= 'z') {
				continue;
			} else if (c >= 'A' && c <= 'Z') {
				continue;
			} else if (c >= '0' && c <= '9') {
				continue;
			}
			return false;
		}
		return true;
	}

	private static String removeWriteSpaceAndLower(String value) {
		value = StringUtils.replaceChars(value, WRITE_SPACE, "");
		return value;
	}

	/**
	 * Part of HTTP content type header.
	 */
	private static final String MULTIPART = "multipart/";

	/**
	 * 判断是否文件上传request
	 *
	 * @param request
	 * @return
	 */
	public static final boolean isMultipartContent(HttpServletRequest request) {
		if (!"post".equals(request.getMethod().toLowerCase())) {
			return false;
		}
		String contentType = request.getContentType();
		if (contentType == null) {
			return false;
		}
		if (contentType.toLowerCase().startsWith(MULTIPART)) {
			return true;
		}
		return false;
	}
}