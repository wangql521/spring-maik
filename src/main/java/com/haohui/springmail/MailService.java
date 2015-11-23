/*
 *    Copyright 2012-2013 The Haohui Network Corporation
 */
package com.haohui.springmail;

/**
 * @project haohui-b2b
 * @author cevencheng
 * @create 2012-3-24 上午12:26:17
 */
public interface MailService {

	/**
	 * 发送 HTML 邮件
	 * 
	 * @param receivers 多个收件箱地址用 ,分隔
	 * @param subject
	 * @param text
	 */
	public abstract void sendHtmlEmails(String receivers, String subject, String content);
	/**
	 * 发送 HTML 邮件
	 * 
	 * @param receivers 多个收件箱地址用 ,分隔
	 * @param subject
	 * @param text
	 */
	public abstract void sendHtmlEmailsTest(String receivers, String subject, String content);
}
