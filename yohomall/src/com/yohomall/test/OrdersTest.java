package com.yohomall.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yohomall.pojo.Orders;
import com.yohomall.service.impl.OrdersServiceImpl;

public class OrdersTest {
	@Autowired
	private OrdersServiceImpl oService;
	
	@Test
	public void add(){
		Orders order = new Orders();
		//order.setUid(2);
		order.setAddr("³¤É³");
		order.setAname("yl");
		order.setPhone("19761");
		order.setTotal(1000.0);
		order.setStatus(1);
		order.setTime(new Date());
		int count = oService.newOrder(order);
		System.out.println(count);
	}
	
	
	
	@Before
	public void init() {
		ApplicationContext context=new ClassPathXmlApplicationContext("root-context.xml");
		oService = context.getBean("oService",OrdersServiceImpl.class);
		
	}
}
