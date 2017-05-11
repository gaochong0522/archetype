package com.gcgame.oa.common.dwr;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

	// 接收人
	private String receiverId;
	// 发送人
	private String sender; 
	// 内容
	private String content; 
	// 发送时间
	private Date sendTime;
	// 类型
	private int msgType;

	public Message(String receiverId, String sender, String content, int msgType) {
		super();
		this.receiverId = receiverId;
		this.sender = sender;
		this.content = content;
		this.msgType = msgType;
	}

	public String getSendTime() {
		String sdate = "";
		try {
			if (null == sendTime){
				sendTime = new Date();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdate = sdf.format(sendTime);
		} catch (Exception e) {
		}
		return sdate;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMsgType() {
		return msgType;
	}

	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [receiverId=");
		builder.append(receiverId);
		builder.append(", sender=");
		builder.append(sender);
		builder.append(", content=");
		builder.append(content);
		builder.append(", msgType=");
		builder.append(msgType);
		builder.append(", sendTime=");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdate = sdf.format(sendTime);
		builder.append(sdate);
		builder.append("]");
		return builder.toString();
	}
	
}
