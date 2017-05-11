package com.gcgame.oa.common.util;

import org.apache.commons.lang3.StringUtils;

public class TextAreaUtils {

	/**
	 * 将textarea中输入时产生的换行,空格转换为html的<br/>和&nbsp;
	 * @author ztb
	 * 2014-8-27 下午5:07:42
	 * @param data
	 * @return
	 */
	public static String parse2html(String data){
		if(data == null){
			return null;
		}
		String newData = StringUtils.replace(data,"\r\n","<br/>");
		newData = StringUtils.replace(newData, " ", "&nbsp;");
		return newData;
	}
}
