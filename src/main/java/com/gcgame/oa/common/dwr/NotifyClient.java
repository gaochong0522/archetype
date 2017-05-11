//package com.gcgame.oa.common.dwr;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.apache.commons.lang3.StringUtils;
//import org.directwebremoting.Browser;
//import org.directwebremoting.ScriptBuffer;
//import org.directwebremoting.ScriptSession;
//import org.directwebremoting.ScriptSessionFilter;
//import org.directwebremoting.ServerContext;
//import org.directwebremoting.ServerContextFactory;
//import org.directwebremoting.extend.DwrConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Service;
//
//import com.fchgame.oa.model.RubishMessage;
//import com.fchgame.oa.service.RubishMessageService;
//import com.fchgame.oa.web.constant.SystemConstants;
//
//@Service
//public class NotifyClient implements ApplicationListener<MessageEvent> {
//
//	private Logger log = LoggerFactory.getLogger(NotifyClient.class);
//
//	@Resource
//	private RubishMessageService rubishMessageService;
//
//
//	//负责处理消息事件的监听器
//	public void onApplicationEvent(MessageEvent event) {
////		if (event instanceof MessageEvent) {
//			if(event.getSource() != null){
//				send((Message) event.getSource());
//			}
////		}
//	}
//
//	//动态分布图地址
//	private static final String PAGE_MAP = "/locationInformation/getMapViewInformation";
//
//	private void send(final Message msg) {
//		ServerContext sc = ServerContextFactory.get();
//		if(sc == null){
//			return;
//		}
//
//		Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
//			public boolean match(ScriptSession session) {
//				String sessionUserId = (String) session.getAttribute(SystemConstants.DWR_SESSION_USERID);
//				if (sessionUserId == null){
//					return false;
//				}else{
//					if(msg.getReceiverId().equals(SystemConstants.DWR_SEND_ALL)){
//						boolean needPush = true;
//						if(msg.getMsgType() == SystemConstants.DWR_MSG_TYPE_MSG){
//							//是消息推送
//						}else{
//							//是动态分布图的推送
//							if(!session.getPage().contains(PAGE_MAP)){
//								//在访问其它页面，无需推送
//								needPush = false;
//							}
//						}
//						return needPush;
//					}else{
//						if(msg.getReceiverId().contains(",")){
//							String[] arr = StringUtils.split(msg.getReceiverId(), ",");
//							for (int i = 0; i < arr.length; i++) {
//								if(sessionUserId.equals(arr[i])){
//									return true;
//								}
//							}
//							return false;
//						}else{
//							return sessionUserId.equals(msg.getReceiverId());
//						}
//					}
////					return session.getAttribute(Constants.DWR_SESSION_USERID).equals(msg.getReceiverId());
//
//				}
//			}
//		}, new Runnable() {
//			public void run() {
//				Collection<ScriptSession> colls = Browser.getTargetSessions();
//				for (ScriptSession scriptSession : colls) {
////					log.debug("user " + scriptSession.getId() + " is visiting " + scriptSession.getPage());
//					String userid = (String)scriptSession.getAttribute(SystemConstants.DWR_SESSION_USERID);
//					List<RubishMessage> list =  rubishMessageService.getRubishMessageByReceiveId(userid);
//					if(list!=null&&list.size()>0){
//						List<Long> pks = new ArrayList<Long>();
//						for(RubishMessage rm : list){
//							pks.add(rm.getId());
//						}
//						rubishMessageService.delete(pks);
//					}
//
//					switch (msg.getMsgType()) {
//						case SystemConstants.DWR_MSG_TYPE_MSG:
//							scriptSession.addScript(initFunctionCall("showMessage", msg
//									.getContent(), msg.getSender(), msg.getSendTime()));
//							break;
//						case SystemConstants.DWR_MSG_TYPE_MAP_USER:
//							scriptSession.addScript(initFunctionCall("refreshMapUser", msg
//									.getContent(), msg.getSender(), msg.getSendTime()));
//							break;
//						case SystemConstants.DWR_MSG_TYPE_MAP_CONSTRUCT:
//							scriptSession.addScript(initFunctionCall("refreshMapConstruct", msg
//									.getContent(), msg.getSender(), msg.getSendTime()));
//							break;
//						case SystemConstants.DWR_MSG_TYPE_MAP_EMGERCY:
//							scriptSession.addScript(initFunctionCall("refreshMapEmgercy", msg
//									.getContent(), msg.getSender(), msg.getSendTime()));
//							break;
//						default:
//							break;
//					}
//				}
//			}
//		});
//	}
//
//	private ScriptBuffer initFunctionCall(String funcName, Object... params) {
//		ScriptBuffer script = new ScriptBuffer();
//		script.appendCall(funcName, params);
//		return script;
//	}
//	public static void main(String[] args) {
//		String packageName = NotifyClient.class.getPackage().getName();
//		System.out.println(packageName);
//		String expectedPackage = DwrConstants.PACKAGE_NAME + ".util";
//		System.out.println(expectedPackage);
//	}
//}
