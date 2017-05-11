package com.gcgame.oa.common.util;

import org.apache.commons.lang3.StringUtils;

public class SplitUtils {

	public static String removeData(String data, String removeContent){
		if(StringUtils.isEmpty(data) || StringUtils.isEmpty(removeContent)){
			return data;
		}
		String[] array = StringUtils.split(data, ',');
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < array.length; i++) {
			if(removeContent.equals(array[i])){
				
			}else{
				if(sb.length() != 0){
					sb.append(",");
				}
				sb.append(array[i]);
			}
		}
		return sb.toString();
	}
	
	public static String arr2str(String[] ids){
		if(ids == null || ids.length==0){
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ids.length; i++) {
			if(i != 0){
				sb.append(",");
			}
			sb.append(ids[i]);
		}
		return sb.toString();
	}
}
