package com.gcgame.oa.common.message;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

//import com.gcgame.oa.web.controller.PatrolController;
import com.zmtech.common.util.Resources;
import com.zmtech.common.util.http.HttpclientUtils;

public class PhoneMessage {
	private static String Url = "http://106.ihuyi.com/webservice/sms.php?method=Submit";
	private static String userName = Resources.getString("message.userName");
	private static String password = Resources.getString("message.password");

	public static boolean sendMsg(String mobile, String content) {
		if (StringUtils.isNotBlank(content)) {
				Map<String,String>params = new HashMap<>();
				params.put("account", userName);
				params.put("password", password);			    
				params.put("mobile", mobile); 
				params.put("content", content);
				String result = HttpclientUtils.post(Url, params,"UTF-8");
				System.out.println("result=="+result);
				if(result.indexOf("<code>2</code>")>0){
					return true;
				}
		}
		return false;
	}

	public static boolean sendMsgForGetPassword(String mobile,String content) {
	
		//System.out.println("您的验证码是：7528。请不要把验证码泄露给其他人。");
		return sendMsg(mobile, content);
	}

	public static void main(String[] args) {
	 
		
		//String content = "李振民您好! 在"+PatrolController.patrolDate.format(new Date())+"的安全巡检中发现了可能与您有关的问题，请您尽快登录安全巡检系统了解详情。";
				
		//System.out.println(sendMsgForGetPassword("15210307249",content));
		Map<String,String>params = new HashMap<>();
		params.put("account", userName);
		params.put("password", password);			    
		System.out.print( HttpclientUtils.post("http://www.baidu.com", params,"UTF-8"));
	}
	/*public static void main(String[] args) {
		String code="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// 取随机产生的认证码(6位数字)
		Random random = new Random();
		
		for(int j=0 ;j<100;j++){
			String sRand = "";
			for (int i = 0; i < 6; i++) {
				String rand = code.charAt(random.nextInt(16))+"";
				sRand += rand;
			}
			System.out.println(sRand);
		}
		
		 
	}
*/
	public static int getInfo() {
		String result = HttpclientUtils.get("http://inolink.com/WS/SelSum.aspx?CorpID=" + userName + "&Pwd=" + password);
		System.out.println(result);
		return 1;
	}

}
