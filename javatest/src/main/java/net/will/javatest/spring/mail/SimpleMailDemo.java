/**
 * @(#)SimpleMailDemo.java - Will's practices of Project javatest.
 */
package net.will.javatest.spring.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * spring-context-support.jar, mail.jar, activation.jar
 *
 * @author Will
 * @version 2012-4-18
 */
public class SimpleMailDemo {

	public static void main(String[] args) {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost("boco.com.cn");
		javaMailSenderImpl.setUsername("username");
		javaMailSenderImpl.setPassword("password");
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("sunyuxin@boco.com.cn");
		simpleMailMessage.setFrom("yuanzhijun@boco.com.cn");
		simpleMailMessage.setSubject("title from yuanzhijun");
		simpleMailMessage.setText("This is a mail content");
		
		javaMailSenderImpl.send(simpleMailMessage);
	}

}
