package com.haohui.springmail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4  
@ContextConfiguration({"/spring-ds.xml", "/spring-mail.xml"}) //指定Spring的配置文件 /为classpath下
public class TestMail {
	@Autowired
	ApplicationContext actx;
	@Autowired
	MailService mailService;
	@Test
	public void sendMail(){
		MailSender sender = (MailSender) actx.getBean("mailSender1");
		SimpleMailMessage mailMessage = (SimpleMailMessage) actx.getBean("mailMessage");
		mailMessage.setSubject("你好");
		mailMessage.setText("这个是一个通过Spring框架来发送邮件的小程序");
		mailMessage.setTo("18210853656@163.com");
		sender.send(mailMessage);
		
	}
	@Test
	public void sendMailtp() throws MessagingException{
		JavaMailSenderImpl sender = (JavaMailSenderImpl) actx
				.getBean("mailSender1");
		MimeMessage mailMessage=sender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true);
		SimpleMailMessage mailMessageFsr = (SimpleMailMessage) actx.getBean("mailMessage");
		messageHelper.setFrom(mailMessageFsr.getFrom());
		messageHelper.setTo("18210853656@163.com");

		messageHelper.setSubject("测试邮件中嵌套图片!！");
		// true 表示启动HTML格式的邮件
		messageHelper.setText(
				"<html><head></head><body><h1>hello!!spring image html mail</h1>"
					+"<a href=http://www.baidu.com>baidu</a>"	+ "<img src=cid:image/></body></html>", true);

		FileSystemResource img = new FileSystemResource(new File("F:\\Photo\\001.jpg"));

		messageHelper.addInline("image", img);//跟cid一致

		sender.send(mailMessage);
		System.out.println("邮件发送成功...");		
	}
	@Test
	public void sendMailfj() throws MessagingException{
		JavaMailSenderImpl sender = (JavaMailSenderImpl) actx
				.getBean("mailSender1");
		MimeMessage mailMessage=sender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true);
		SimpleMailMessage mailMessageFsr = (SimpleMailMessage) actx.getBean("mailMessage");
		messageHelper.setFrom(mailMessageFsr.getFrom());
		messageHelper.setTo("18210853656@163.com");
		messageHelper.setSubject("测试邮件中嵌套图片!！");
		// true 表示启动HTML格式的邮件
		messageHelper.setText(
				"<html><head></head><body><h1>hello!!spring image html mail</h1>"
						+"<a href=http://www.baidu.com>baidu</a>"	+ "<img src=cid:image/></body></html>", true);
		FileSystemResource img = new FileSystemResource(new File("F:\\Photo\\001.jpg"));
		messageHelper.addAttachment("单.png", img);//添加到附件
		sender.send(mailMessage);
		System.out.println("邮件发送成功...");		
	}
	@Test 
	public void testSendXC(){
		this.mailService.sendHtmlEmailsTest("18210853656@163.com", "SpringMail 异步发送邮件测试", "共同学习共同进步!!! 邮件发送很耗时，还需异步发送啊啊啊啊");	
	}
}
