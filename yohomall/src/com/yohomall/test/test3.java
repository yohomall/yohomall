package com.yohomall.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yohomall.dao.OrdersMapper;
import com.yohomall.pojo.Category;
import com.yohomall.pojo.Orderitem;
import com.yohomall.pojo.Orders;
import com.yohomall.pojo.OrdersVo;
import com.yohomall.service.impl.CategoryServiceImpl;
import com.yohomall.service.impl.OrdersServiceImpl;

public class test3 {
	@Autowired
	private OrdersServiceImpl oservice;
	
	
	
	@Test
	public void getById1() throws Exception {
		List<Orders> list=oservice.getMyOrdersByPage(4, 0, 3);
		for (Orders orders : list) {
			System.out.println(orders.getStatus()+" "+orders.getOid());
		}
	}
	
	
	@Before
	public void init() {
		ApplicationContext context=new ClassPathXmlApplicationContext("root-context.xml");
		oservice=context.getBean("oservice",OrdersServiceImpl.class);
	}
}
