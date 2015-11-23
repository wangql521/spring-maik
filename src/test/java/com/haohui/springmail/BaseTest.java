package com.haohui.springmail;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * Spring 集成测试基类
 * 
 * @RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4 
 * @ContextConfiguration({"/spring-ds.xml", "/spring-mail.xml"}) //指定Spring的配置文件 /为classpath下
 * 
 * @author cevencheng
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4  
@ContextConfiguration({"/spring-ds.xml", "/spring-mail.xml"}) //指定Spring的配置文件 /为classpath下
public abstract class BaseTest extends AbstractJUnit4SpringContextTests {

	@Resource
	public MailService mailService = null;

}
