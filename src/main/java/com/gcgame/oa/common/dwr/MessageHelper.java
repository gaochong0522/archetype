package com.gcgame.oa.common.dwr;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service("messageHelper")
// 要和 dwr.xml 的 beanName 保持一致
@Scope("singleton")
public class MessageHelper implements ApplicationContextAware {
	//负责出发消息事件
	
	//定义Spring上下文对象
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext ctx) {
		MessageHelper.applicationContext = ctx;
	}

	public static void sendMessage(Message mes) {
		if (applicationContext != null) {
			applicationContext.publishEvent(new MessageEvent(mes));
		}
	}
	
}