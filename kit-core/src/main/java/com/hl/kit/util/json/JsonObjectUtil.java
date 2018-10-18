package com.hl.kit.util.json;

import net.sf.json.JSONObject;

import java.util.Map;

/**
 * json格式接口
 * 
 * @author 洪雷
 *
 */
public class JsonObjectUtil {

	public static String map2str(Map<String, Object> mapObject) {
		String result = null;
		try {
			JSONObject jsonArray = JSONObject.fromObject(mapObject);
			result = jsonArray.toString();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> str2map(String strJson) {
		Map<String, Object> result = null;
		try {
			result = (Map<String, Object>) JSONObject.fromObject(strJson);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

}
