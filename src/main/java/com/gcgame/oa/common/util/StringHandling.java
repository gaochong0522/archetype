package com.gcgame.oa.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHandling {

	/**
	 * 获取字符串中匹配信息
	 * 
	 * @param targetStr
	 *            目标字符串
	 * @param regex
	 *            匹配正则
	 * @return List<String>
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         thinkinOO time: 2017年2月17日下午2:53:11
	 */
	@Deprecated
	public static List<String> getMatchStrings(String targetStr, String regex) {
		Pattern pat = Pattern.compile(regex);
		Matcher mat = pat.matcher(targetStr);
		List<String> dates = new ArrayList<String>(mat.groupCount()+1);
		mat.find();
//		for (int i = 0; i <= mat.groupCount(); i++) {
//			dates.add(mat.group(i));
//		}
		dates.add(mat.group());
		return dates;
	}
}
