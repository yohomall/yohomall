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
	private UserServiceImpl  userService;
	
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
//			boolean flag = false;
//			flag=userService.checkEmail("470808@qq.com");
//			if(flag){
//				System.out.println("邮箱已存在");
//			}else{
//				System.out.println("可用");
//			}
//		
//	}
//	
//	//用户登录
	@Test
	public void login() throws NoSuchAlgorithmException{
		User u  = new User();
		u = userService.login("8195@qq.com", "0000");
		if(u!=null){
			if(Util.getMD5("000").equals(u.getPassword())){
				System.out.println("登录成功");
				System.out.println(Util.getMD5("0000"));
				System.out.println(u.getPassword());
			}else {
				System.out.println("密码错误");
			}
		}
		
	}
	
	@Before
	public void init() {
		ApplicationContext context=new ClassPathXmlApplicationContext("root-context.xml");
		//ApplicationContext context1=new ClassPathXmlApplicationContext("root-context.xml");
		//service=context.getBean("service",ProductServiceImpl.class);
		userService = context.getBean("userService",UserServiceImpl.class);
		
	}
}
