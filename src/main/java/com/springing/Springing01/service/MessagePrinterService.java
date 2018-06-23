package com.springing.Springing01.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessagePrinterService implements InitializingBean, DisposableBean {

	private MessageOfTheDayService service;
	
	public MessagePrinterService() {
		System.out.println("No-args constructor called for " + MessagePrinterService.class.getName());
	}
	
	public MessagePrinterService(final MessageOfTheDayService service) {
		System.out.println("args constructor called for " + MessagePrinterService.class.getName());
		this.service = service;
	}
	
	public void init() {
		System.out.println("init called for: " + MessagePrinterService.class.getName());
	}

    public void printMessage() {
        System.out.println(service.getMessage());
    }
        
    public void setMessageService(final MessageOfTheDayService service){
    	this.service = service;
    }

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy called for: " + MessagePrinterService.class.getName());		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet called for: " + MessagePrinterService.class.getName());		
	}

}
