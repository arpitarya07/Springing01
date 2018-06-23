package com.springing.Springing01.service;
import com.springing.Springing01.model.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class DynamicMessageOfTheDayImpl implements MessageOfTheDayService, InitializingBean, DisposableBean {

	// Messages held in an Array
	private String[] messagesArray = {};
	private MessageValue[] messagesValueArray = {};
	
	//Messages held in a List
	private List<String> messagesList = new ArrayList<String>();
	private List<MessageValue> messagesValueList = new ArrayList<MessageValue>();
	
	//Messages held in a Map
	private Map<Integer, String> messagesMap = new HashMap<Integer, String>();
	private Map<Integer, MessageValue> messagesValueMap = new HashMap<Integer, MessageValue>();
	
	public String[] getMessagesArray() {
		return messagesArray;
	}

	public void setMessagesArray(String[] messagesArray) {
		this.messagesArray = messagesArray;
	}

	public MessageValue[] getMessagesValueArray() {
		return messagesValueArray;
	}

	public void setMessagesValueArray(MessageValue[] messagesValueArray) {
		this.messagesValueArray = messagesValueArray;
	}

	public List<String> getMessagesList() {
		return messagesList;
	}

	public void setMessagesList(List<String> messagesList) {
		this.messagesList = messagesList;
	}

	public List<MessageValue> getMessagesValueList() {
		return messagesValueList;
	}

	public void setMessagesValueList(List<MessageValue> messagesValueList) {
		this.messagesValueList = messagesValueList;
	}

	public Map<Integer, String> getMessagesMap() {
		return messagesMap;
	}

	public void setMessagesMap(Map<Integer, String> messagesMap) {
		this.messagesMap = messagesMap;
	}

	public Map<Integer, MessageValue> getMessagesValueMap() {
		return messagesValueMap;
	}

	public void setMessagesValueMap(Map<Integer, MessageValue> messagesValueMap) {
		this.messagesValueMap = messagesValueMap;
	}

	public DynamicMessageOfTheDayImpl() {
		System.out.println("No-args constructor called" + DynamicMessageOfTheDayImpl.class.getName());
	}
	
	public DynamicMessageOfTheDayImpl(String[] messages) {
		System.out.println("args constructor called" + DynamicMessageOfTheDayImpl.class.getName());
		this.messagesArray = (String[])messages.clone();
	}
	
	public void init() {
		System.out.println("init called for: " + DynamicMessageOfTheDayImpl.class.getName());
	}
	
	public String getMessage(){
		
		//What day is it today??
		final int day = GregorianCalendar.getInstance().get(Calendar.DAY_OF_WEEK);
		
		// days start at on in Java
		String message = "";
		
		//Array Examples
		if(messagesArray.length > 0) {
			message = "From Array:" + messagesArray[day -1];
		}
		
		if(messagesValueArray.length > 0) {
			message = "From Array:" + messagesValueArray[day -1].getMessage();
		}
		
		//List Examples
		if(!messagesList.isEmpty()) {
			message = "From List:" + messagesList.get(day -1);
		}
		
		if(!messagesValueList.isEmpty()) {
			message = "From List:" + messagesValueList.get(day -1).getMessage();
		}
		
		//Map Examples
		if(!messagesMap.isEmpty()) {
			message = "From Map:" + messagesMap.get(day);
		}
		
		if(!messagesValueMap.isEmpty()) {
			message = "From Map:" + messagesValueMap.get(day).getMessage();
		}		
		
		return message;
				
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy called for: " + DynamicMessageOfTheDayImpl.class.getName());	
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet called for: " + DynamicMessageOfTheDayImpl.class.getName());
		
	}

}
