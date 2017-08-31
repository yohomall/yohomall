package com.yohomall.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
//	@Test
//	public void add(){
//		Orders order = new Orders();
//		order.setUid(2);
//		order.setAddr("³¤É³");
//		order.setAname("yl");
//		order.setPhone("19761");
//		order.setTotal(1000.0);
//		order.setStatus(1);
//		order.setTime(new Date());
//		int count = oService.newOrder(order);
//		System.out.println(count);
//	}
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
	public void find(){
		List<Orders> olist = oService.findOrderDetails();
		for(Orders o : olist){
			System.out.println(o.getOid()+o.getAname()+o.getPhone()+o.getTotal()+o.getItems().get(0).getProduct().get(0).getPname());
		}

	}
	
	@Before
	public void init() {
		ApplicationContext context=new ClassPathXmlApplicationContext("root-context.xml");
		oService = context.getBean("oService",OrdersServiceImpl.class);
		
	}
}
