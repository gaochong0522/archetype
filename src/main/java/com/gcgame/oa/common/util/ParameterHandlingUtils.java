package com.gcgame.oa.common.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.gcgame.oa.common.util.web.MyThreadLocalUtils;

/**
 * 参数处理工具类
 * 
 * @author 刘旭
 * 
 *         2016年11月9日上午10:27:55
 * 
 */
public class ParameterHandlingUtils {

	// --------------------常量--------------------

	/**
	 * 过滤Map
	 */
	public static final int FILTER_MAP = 0x1;

	/**
	 * 过滤转发
	 */
	public static final int FILTER_FORWARD = 0x2;

	/**
	 * 全部过滤
	 */
	public static final int FILTER_ALL = 0x3;

	// --------------------参数处理--------------------

	/**
	 * 创建Map型参数（可直接用于MyBatis传参）
	 * 
	 * @param request
	 * @return Map<String,Object>
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月8日上午9:50:30
	 */
	public static Map<String, Object> createMapParam(HttpServletRequest request) {

		Map<String, Object> param = new HashMap<String, Object>();

		// 获取所有key值
		Enumeration<String> enumeration = request.getParameterNames();

		while (enumeration.hasMoreElements()) {

			String key = enumeration.nextElement();
			String val = request.getParameter(key);

			// 过滤""和null值
			if (StringUtils.isNotBlank(val)) {
				param.put(key, val);
			}
		}

		return param;
	}

	/**
	 * 创建Map型参数,并过滤掉不需要参数（可直接用于MyBatis传参）
	 * 
	 * @param request
	 * @return Map<String,Object>
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月10日上午9:42:17
	 */
	public static Map<String, Object> createMapParam(HttpServletRequest request, String... filtersKey) {

		// 无过滤条件
		if (filtersKey == null || filtersKey.length == 0) {
			return createMapParam(request);
		}

		Map<String, Object> param = new HashMap<String, Object>();
		// 获取所有key值
		Enumeration<String> enumeration = request.getParameterNames();

		while (enumeration.hasMoreElements()) {

			String key = enumeration.nextElement();
			stop: {
				for (String filter : filtersKey) {
					if (key.equals(filter)) {
						break stop;
					}
				}
				String val = request.getParameter(key);
				// 过滤""和null值
				if (StringUtils.isNotBlank(val)) {
					param.put(key, val);
				}
			}
		}
		return param;
	}

	/**
	 * 获取Map型参数（可直接用于MyBatis传参）
	 * 
	 * @return Map<String,Object>
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月8日上午10:02:16
	 */
	public static Map<String, Object> getMapParam() {
		HttpServletRequest request = MyThreadLocalUtils.getRequest();
		return createMapParam(request);
	}

	/**
	 * 获取Map型参数,并过滤掉不需要参数（可直接用于MyBatis传参）
	 * 
	 * @param filtersKey
	 * @return Map<String,Object>
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月10日上午10:06:23
	 */
	public static Map<String, Object> getMapParam(String... filtersKey) {
		HttpServletRequest request = MyThreadLocalUtils.getRequest();
		return createMapParam(request, filtersKey);
	}

	/**
	 * 转发Map对象中所有参数
	 * 
	 * @param param
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月8日上午10:16:43
	 */
	public static void forwardAll(Map<String, Object> param) {
		HttpServletRequest request = MyThreadLocalUtils.getRequest();
		for (Map.Entry<String, Object> entry : param.entrySet()) {
			request.setAttribute(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * 转发Map对象中所有参数
	 * 
	 *
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月8日上午10:16:43
	 */
	public static void forwardAll() {
		forwardAll(getMapParam());
	}

	/**
	 * 转发Map对象中的参数,并过滤掉不需要参数
	 * 
	 * @param filtersKey
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月10日上午10:13:07
	 */
	public static void forwardByFilter(String... filtersKey) {
		forwardAll(getMapParam(filtersKey));
	}

	/**
	 * 获取Map型参数并全部转发
	 * 
	 * @return Map<String,Object>
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月8日上午10:19:17
	 */
	public static Map<String, Object> getMapParamAndForwardAll() {
		forwardAll();
		return getMapParam();
	}

	/**
	 * 根据请求获取Map对象并转发<br>
	 * 模式：1-过滤Map 2-过滤转发 3-过滤全部
	 * 
	 * 
	 * @param filtersKey
	 * @return Map<String,Object>
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月10日上午10:16:23
	 */
	public static Map<String, Object> getMapAndForwardByFileter(int pattern, String... filtersKey) {
		switch (pattern) {
		case 1:
			forwardAll();
			return getMapParam(filtersKey);
		case 2:
			forwardByFilter(filtersKey);
			return getMapParam();
		default:
			forwardByFilter(filtersKey);
			return getMapParam(filtersKey);
		}
	}

	/**
	 * 获取String类型对象（值不存在默认为""）
	 * 
	 * @param key
	 * @return String
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月8日上午10:21:10
	 */
	public static String getStr(String key) {

		HttpServletRequest request = MyThreadLocalUtils.getRequest();

		String val = request.getParameter(key);

		return val == null ? "" : val;
	}

	/**
	 * 获取Double类型对象（值不存在默认为-1）
	 * 
	 * @param key
	 * @return String
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月8日上午10:21:10
	 */
	public static Double getDouble(String key) {

		HttpServletRequest request = MyThreadLocalUtils.getRequest();

		String val = request.getParameter(key);

		if (NumberUtils.isNumber(val)) {
			return Double.parseDouble(val);
		} else {
			return Double.valueOf(-1);
		}
	}

	/**
	 * 获取Long类型对象（值不存在默认为-1）
	 * 
	 * @param key
	 * @return String
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月8日上午10:21:10
	 */
	public static Long getLong(String key) {

		HttpServletRequest request = MyThreadLocalUtils.getRequest();

		String val = request.getParameter(key);

		if (NumberUtils.isNumber(val)) {
			return Long.parseLong(val);
		} else {
			return Long.valueOf(-1);
		}
	}

	/**
	 * 获取Integer类型对象（值不存在默认为-1）
	 * 
	 * @param key
	 * @return String
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月8日上午10:21:10
	 */
	public static Integer getInteger(String key) {

		HttpServletRequest request = MyThreadLocalUtils.getRequest();

		String val = request.getParameter(key);

		if (NumberUtils.isNumber(val)) {
			return Integer.parseInt(val);
		} else {
			return Integer.valueOf(-1);
		}
	}

	/**
	 * 获取String类型对象并与之比较（""与null相等）
	 * 
	 * @param key
	 * @return boolean
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月9日下午5:10:26
	 */
	public static boolean getStrAndCompare(String key, String str) {
		str = (str == null ? "" : str);
		return getStr(key).equals(str);
	}

	/**
	 * 批量格式化字符串（Long）
	 * 
	 * @param str
	 * @param delimiter
	 * @return Long[]
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月11日下午4:00:55
	 */
	public static Long[] getLongsSplitAndFormatStr(String str, String delimiter) {
		if (StringUtils.isBlank(str)) {
			return new Long[0];
		}
		String[] strArray = str.split(delimiter);
		Long[] longArray = new Long[getStrArrayIsNotBlankElementNumber(strArray)];

		for (int i = 0, j = 0; i < strArray.length; i++) {
			if (StringUtils.isNotBlank(strArray[i])) {
				longArray[j] = Long.parseLong(strArray[i]);
				j++;
			}
		}
		return longArray;
	} 

	/**
	 * 批量格式化字符串（Integer）
	 * 
	 * @param str
	 * @param delimiter
	 * @return Integer[]
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月11日下午4:02:30
	 */
	public static Integer[] getIntegersSplitAndFormatStr(String str, String delimiter) {
		if (StringUtils.isBlank(str)) {
			return new Integer[0];
		}
		String[] strArray = str.split(delimiter);
		Integer[] intArray = new Integer[getStrArrayIsNotBlankElementNumber(strArray)];
		for (int i = 0, j = 0; i < strArray.length; i++) {
			if (StringUtils.isNotBlank(strArray[i])) {
				intArray[j] = Integer.valueOf(strArray[i]);
				j++;
			}
		}
		return intArray;
	}

	/**
	 * 批量格式化字符串（Double）
	 * 
	 * @param str
	 * @param delimiter
	 * @return Double[]
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月11日下午4:11:38
	 */
	public static Double[] getDoublesSplitAndFormatStr(String str, String delimiter) {
		if (StringUtils.isBlank(str)) {
			return new Double[0];
		}
		String[] strArray = str.split(delimiter);
		Double[] intDouble = new Double[getStrArrayIsNotBlankElementNumber(strArray)];
		for (int i = 0, j = 0; i < strArray.length; i++) {
			if (StringUtils.isNotBlank(strArray[i])) {
				intDouble[j] = Double.parseDouble(strArray[i]);
				j++;
			}
		}
		return intDouble;
	}

	/**
	 * 获取字符串数组中非空元素个数
	 * 
	 * @param strArray
	 * @return int
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年11月29日上午10:00:45
	 */
	public static int getStrArrayIsNotBlankElementNumber(String[] strArray) {
		int notBlankElementNumber = 0;
		for (int i = 0; i < strArray.length; i++) {
			if (StringUtils.isNotBlank(strArray[i])) {
				notBlankElementNumber++;
			}
		}
		return notBlankElementNumber;
	}
}
