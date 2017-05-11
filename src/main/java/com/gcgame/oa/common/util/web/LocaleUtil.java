package com.gcgame.oa.common.util.web;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Cookie 辅助类
 * 
 * @author andyhome
 * 
 */
public class LocaleUtil {
	public static String LANGUAGE = "language";
	public static Map<String,Locale> localeMap = new HashMap<String,Locale>();
	static{
		localeMap.put("zh_CN", new Locale("zh", "CN"));
		localeMap.put("en_US", new Locale("en", "US"));
	}
	public static Locale getLocale(String language) {
		Locale locale = null;
		if(language!=null){
			locale = localeMap.get(language);
		}
		if(locale==null){
			locale = MyThreadLocalUtils.getRequest().getLocale();
			if(localeMap.get(locale.toLanguageTag())==null){
				locale = new Locale("zh", "CN");
			}
		}
		return locale;
	}
}
