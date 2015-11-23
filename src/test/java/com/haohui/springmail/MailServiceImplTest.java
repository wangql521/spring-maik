/*
 *    Copyright 2012-2013 The Haohui Network Corporation
 */
package com.haohui.springmail;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * 
 * @project spring-mail
 * @author cevencheng <cevencheng@gmail.com>
 * @create 2013-1-17 下午7:32:40
 */
public class MailServiceImplTest extends BaseTest {

	/**
	 * Test method for {@link com.haohui.springmail.MailServiceImpl#sendHtmlEmails(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSendHtmlEmails() {
		this.mailService.sendHtmlEmails("18210853656@163.com", "SpringMail 异步发送邮件测试", "共同学习共同进步!!! 邮件发送很耗时，还需异步发送啊啊啊啊");
		try {
			Thread.currentThread().sleep(TimeUnit.MINUTES.toMillis(3));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.haohui.springmail.MailServiceImpl#sendMailByAsynchronousMode(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSendMailByAsynchronousMode() {
	}

	/**
	 * Test method for {@link com.haohui.springmail.MailServiceImpl#sendMailBySynchronizationMode(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSendMailBySynchronizationMode() {
		fail("Not yet implemented");
	}

}
