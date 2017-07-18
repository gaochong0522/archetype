package com.gcgame.oa.common.util;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.push.PushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.SMS;
import cn.jpush.api.push.model.audience.Audience;

public class JPushUtils {

	/**
	 * 推送模块
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         2017年3月12日上午10:51:29
	 * 
	 */
	public static enum PushModule {
		DEVICE_MANAGE(19), DOCUMENT(6), MATERIAL_APPLY(16);

		private int productId;

		PushModule(int productId) {
			this.productId = productId;
		}

		@Override
		public String toString() {
			return String.valueOf(this.productId);
		}
	}

	private final static String appKey = "f7c11afc849faff2bc328d06";
	private final static String masterSecret = "4827dadf66572359a67c92c5";
	private static Logger logger = LoggerFactory.getLogger(JPushUtils.class);

	/**
	 * APP推送
	 * 
	 * @param pushProductId
	 *            设备模块id
	 * @param targs
	 *            用户id数组
	 * @param pushMessage
	 *            推送信息
	 * @return boolean
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         thinkinOO time: 2017年3月12日上午10:04:45
	 */
	public static boolean push(PushModule pushProductId, String[] targs, String pushMessage) {
		try {
			// 将推送模块id和推送信息封装
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("pushProductId", pushProductId.toString());
			jsonObj.put("pushMessage", pushMessage);

			Platform platform = Platform.android_ios();
			Audience audience = Audience.tag(targs);
			// Notification notification =
			// Notification.alert(jsonObj.toString());
			Message message = Message.newBuilder().setMsgContent(pushMessage).addExtra("msg", jsonObj.toString())
					.build();
			// 只ios有用:false是dev环境,否则是生产环境
			Options options = Options.newBuilder().setApnsProduction(true).build();
			SMS sms = null;
			PushPayload pushPayload = PushPayload.newBuilder().setAudience(audience).setMessage(message)
					.setOptions(options).setPlatform(platform).setSMS(sms).build();
			PushResult pushResult = null;
			pushResult = new PushClient(masterSecret, appKey).sendPush(pushPayload);
			logger.info(pushResult.toString());
			if (pushResult.isResultOK()) {
				return true;
			}
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return false;
	}
}
