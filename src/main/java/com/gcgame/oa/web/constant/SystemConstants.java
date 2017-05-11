package com.gcgame.oa.web.constant;

import com.zmtech.common.util.Resources;

public class SystemConstants {
	
	public static final String PROJECT_NAME_TITLE = "长春站";
	
	public static String TOKEN = "token";
	/**
	 * 用户类型  0 普通用户; 1 手机用户
	 */
	public static int USERTYPE_WEB = 0;
	public static int USERTYPE_PHONE = 1;
	
	
	public static class System {
		/***
		 * 域名
		 */
		public static String DOMAIN = Resources.getString("sys.domain", "yfshop.com");


	}
	public static class Cookie{
		/**
		 * 用户名
		 */
		public static String USER_NAME = "loginName";
		/**
		 * 用户名
		 */
		public static String REMEMBER = "remember";
		/**
		 * sessionId
		 */
		public static String SESSIONID = "sid";
		/**
		 *（md5加密后的）密码
		 */
		public static String PASSWORD = "password";
		
		
	}
	/**
	 * DWR保存用户ID的key
	 */
	public static final String DWR_SESSION_USERID = "userId";
	
	/**
	 * DWR发送消息至所有用户
	 */
	public static final String DWR_SEND_ALL = "all";
	
	/**
	 * DWR推送类型-消息
	 */
	public static final int DWR_MSG_TYPE_MSG = 1;
	
	/**
	 * DWR推送类型-动态分布图-人员
	 */
	public static final int DWR_MSG_TYPE_MAP_USER = 11;
	/**
	 * DWR推送类型-动态分布图-施工
	 */
	public static final int DWR_MSG_TYPE_MAP_CONSTRUCT = 12;
	/**
	 * DWR推送类型-动态分布图-应急
	 */
	public static final int DWR_MSG_TYPE_MAP_EMGERCY = 13;
	
}