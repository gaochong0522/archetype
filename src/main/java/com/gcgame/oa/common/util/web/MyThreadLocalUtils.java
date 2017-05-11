package com.gcgame.oa.common.util.web;

import com.gcgame.oa.web.constant.SystemConstants;
import com.zmtech.common.constant.Constants;
import com.zmtech.common.util.ZmThreadLocalUtils;

/**
 * 线程变量 辅助类
 * 
 * @author andyhome
 * 
 */
public class MyThreadLocalUtils extends ZmThreadLocalUtils {
	/**
	 * userType 用户类型  0 普通用户; 1 手机用户
	 */
	private static ThreadLocal<Integer> userType = new ThreadLocal<Integer>();
	private static ThreadLocal<String> uriExt = new ThreadLocal<String>();
	private static ThreadLocal<String> token = new ThreadLocal<String>();
	
	
	public static void setToken(String value) {
		token.set(value);
	}

	public static String getToken() {
		return token.get();
	}
	public static void removeToken() {
		token.remove();
	}
	
	public static void setUriExt(String value) {
		uriExt.set(value);
	}

	public static String getUriExt() {
		return uriExt.get();
	}
	public static void removeUriExt() {
		uriExt.remove();
	}
	
	public static void setUserType(int value) {
		userType.set(value);
	}
	
	public static int getUserType() {
		if(userType.get()==null){
			return 0;
		}
		return userType.get();
	}
	
	public static void removeUserType() {
		userType.remove();
	}
	/**
	 * 获得当前授权用户
	 * @return
	 */
//	public static AuthorizedUser currentUser(){
//		AuthorizedUser authorizedUser = null;
//		if(getSession()!=null){
//			authorizedUser = (AuthorizedUser) getSession().getAttribute(Constants.Session_AUTHORIZEDUSER);
//		}
//		if(getUserType()==SystemConstants.USERTYPE_PHONE){
//			if(authorizedUser==null){
//				return UserInfoCache.getUserByToken(MyThreadLocalUtils.getToken());
//			}
//		}
//		return authorizedUser;
//	}
//	/**
//	 * 设置授权用户信息到session中
//	 * @param authorizedUser
//	 */
//	public static void setCurrentUser(AuthorizedUser authorizedUser){
//		 getSession().setAttribute(Constants.Session_AUTHORIZEDUSER,authorizedUser);
//	}
}
