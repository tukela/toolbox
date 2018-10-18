package com.hl.kit.util.json;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * fastjson工具类 alibaba
 * 
 * @author 洪雷
 *
 */
public class FastJsonUtil {

	private FastJsonUtil() {

	}

	/**
	 * Object to json
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		return JSON.toJSONString(obj, true);
	}

	/**
	 * json to Object
	 * 
	 * @param <T>
	 * @param content
	 * @param valueType
	 * @return
	 */
	public static <T> T toObject(String content, Class<T> valueType) {
		return JSON.parseObject(content, valueType);
	}

	/**
	 * json to List
	 * 
	 * @param <T>
	 * @param content
	 * @param valueType
	 * @return
	 */
	public static <T> List<T> toList(String content, Class<T> valueType) {
		return JSON.parseArray(content, valueType);
	}
}
