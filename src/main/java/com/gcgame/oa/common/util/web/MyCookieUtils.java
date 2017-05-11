package com.gcgame.oa.common.util.web;

import javax.servlet.http.Cookie;

import com.gcgame.oa.web.constant.SystemConstants;
import com.zmtech.common.util.web.CookieUtils;

/**
 * Cookie 辅助类
 * 
 * @author andyhome
 * 
 */
public class MyCookieUtils extends CookieUtils {
	public static Cookie addCookie(String name, String value, Integer expires) {
		return addCookie(MyThreadLocalUtils.getRequest(), MyThreadLocalUtils.getResponse(), name, value, expires, SystemConstants.System.DOMAIN);
	}
	public static Cookie addCookie(String name, String value, Integer expires,boolean httpOnly) {
		return addCookie(MyThreadLocalUtils.getRequest(), MyThreadLocalUtils.getResponse(), name, value, expires, SystemConstants.System.DOMAIN,httpOnly);
	}
	public static Cookie getCookie(String name) {
		return getCookie(MyThreadLocalUtils.getRequest(), name);
	}

	public static void clearCookie() {
		clearCookie(MyThreadLocalUtils.getRequest(), MyThreadLocalUtils.getResponse(), SystemConstants.System.DOMAIN);
	}
	/**
	 * 根据cookie变量名值
	 * @param cookieName
	 * @return
	 */
	public static String getValue(String cookieName){
		Cookie cookie = getCookie(cookieName);
		if(cookie!=null){
			return cookie.getValue();
		}
		
		return null;
	}
	/**
	 * 根据名字删除cookie信息
	 * @param cookieName
	 */
	public static void removeCookie(String cookieName){
		removeCookie(MyThreadLocalUtils.getRequest(), MyThreadLocalUtils.getResponse(), cookieName,  SystemConstants.System.DOMAIN);
	}
	

}
