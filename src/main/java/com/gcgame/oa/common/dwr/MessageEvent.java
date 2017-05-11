package com.gcgame.oa.common.dwr;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {
	//MessageEvent是消息监听事件
	
	private static final long serialVersionUID = -5145817756141676080L;

	//构造函数
	public MessageEvent(Object source) {
		super(source);
	}
}
