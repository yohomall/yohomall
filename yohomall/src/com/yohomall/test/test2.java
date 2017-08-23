package com.yohomall.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.yohomall.pojo.Category;
import com.yohomall.service.impl.CategoryServiceImpl;

public class test2 {
	@Autowired
	private CategoryServiceImpl cservice;
	
	@Test
	public void getById() throws Exception {
		List<Category> cList=cservice.findClist();
		Gson gson=new Gson();
		System.out.println(gson.toJson(cList).toString());
	}
	
	
	@Before
	public void init() {
		ApplicationContext context=new ClassPathXmlApplicationContext("root-context.xml");
		cservice=context.getBean("cservice",CategoryServiceImpl.class);
	}
}
