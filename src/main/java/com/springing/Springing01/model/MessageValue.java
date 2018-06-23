package com.springing.Springing01.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.springing.Springing01.service.DynamicMessageOfTheDayImpl;

public class MessageValue implements InitializingBean, DisposableBean {
	
	String message;
	
	MessageValue() {
		System.out.println("No-args constructor called" + MessageValue.class.getName());
	}
	
	MessageValue(String message) {
		System.out.println("args constructor called" + MessageValue.class.getName());
		this.message= message;
	}
	
	public void init() {
		System.out.println("init called for: " + MessageValue.class.getName());
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy called for: " + MessageValue.class.getName());
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet called for: " + MessageValue.class.getName());
		
	}

}
