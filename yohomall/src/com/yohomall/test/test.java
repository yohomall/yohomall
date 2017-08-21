package com.yohomall.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yohomall.pojo.Product;
import com.yohomall.service.ProductService;
import com.yohomall.service.impl.ProductServiceImpl;

public class test {
	@Autowired
	private ProductServiceImpl service;
	
	@Test
	public void getById() throws Exception {
		Product product=service.getById(1);
		System.out.println(product.getPname()+product.getImage());
	}
	
	
	@Before
	public void init() {
		ApplicationContext context=new ClassPathXmlApplicationContext("root-context.xml");
		service=context.getBean("service",ProductServiceImpl.class);
	}
}
