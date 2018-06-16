package com.springing.Springing01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springing.Springing01.service.DynamicMessageOfTheDayImpl;
import com.springing.Springing01.service.MessagePrinterService;

/**
 * Hello world!
 *
 */
public class Client {
	public static void main(final String[] args) {

		// configuration part
		try (final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/application.xml")) {
			context.registerShutdownHook();
			final MessagePrinterService printer = (MessagePrinterService) context.getBean("printer");

			// doing something part...
			printer.printMessage();
		}

		catch (final Exception ex) {
			ex.printStackTrace();
		}
	}
}
