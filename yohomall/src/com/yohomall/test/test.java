package com.yohomall.test;

import java.security.DigestException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.yohomall.pojo.User;

import com.yohomall.service.exception.existException;

import com.yohomall.service.impl.UserServiceImpl;
import com.yohomall.util.Util;

public class test {

	@Autowired
	private UserServiceImpl  uservice;
	
	/**
	 * 用户注册
	 * @throws NoSuchAlgorithmException
	 * @throws DigestException
	 * @throws existException 
	 */
	
//	@Test
//	public void add() throws NoSuchAlgorithmException, DigestException{
//		User u = new User();
//		u.setEmail("ad@163.com");
//		u.setPassword(Util.getMD5("123"));
//		int count = uservice.register(u);
//		System.out.println(count);
//	}
	
	//验证邮箱
//	@Test
//	public void check() throws existException{
//		
//			User  u =  new User();
//			u=uservice.checkEmail("470808@qq.com");
//		
//	}
	
	//用户登录
	@Test
	public void login(){
		uservice.login("ad@163.com", "123");
	}
	
	@Before
	public void init() {
		ApplicationContext context=new ClassPathXmlApplicationContext("root-context.xml");
		//ApplicationContext context1=new ClassPathXmlApplicationContext("root-context.xml");
		//service=context.getBean("service",ProductServiceImpl.class);
		uservice = context.getBean("uservice",UserServiceImpl.class);
		
	}
}
