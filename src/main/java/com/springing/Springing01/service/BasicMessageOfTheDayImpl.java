package com.springing.Springing01.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BasicMessageOfTheDayImpl implements MessageOfTheDayService, InitializingBean, DisposableBean {
	
	private String message;
	
	BasicMessageOfTheDayImpl() {
		System.out.println("No-args constructor called" + BasicMessageOfTheDayImpl.class.getName());
	}
	
	public void init() {
		System.out.println("init called for: " + MessagePrinterService.class.getName());
	}
	
	public String getMessage() {
		return message;
	}
		
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy called for: " + BasicMessageOfTheDayImpl.class.getName());	
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet called for: " + BasicMessageOfTheDayImpl.class.getName());
		
	}
}
