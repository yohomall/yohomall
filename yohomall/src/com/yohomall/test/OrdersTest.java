package com.yohomall.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yohomall.pojo.Item;
import com.yohomall.pojo.Orders;
import com.yohomall.pojo.Product;
import com.yohomall.service.impl.OrdersServiceImpl;

public class OrdersTest {
	@Autowired
	private OrdersServiceImpl oService;

	// @Test
	// public void add(){
	// Orders order = new Orders();
	// order.setUid(2);
	// order.setAddr("³¤É³");
	// order.setAname("yl");
	// order.setPhone("19761");
	// order.setTotal(1000.0);
	// order.setStatus(1);
	// order.setTime(new Date());
	// int count = oService.newOrder(order);
	// System.out.println(count);
	// }
//	@Test
//	public void find() {
//		Orders o = oService.findOrderDetails(1);
//	
//		for(Item im :o.getItems()){
//			System.out.println(o.getOid()+" "+o.getUid()+" "+o.getAname()+o.getPhone()+o.getStatus()+o.getTotal()+im.getPid()+im.getProduct().getPname()+im.getQuantity());
//	        
//		}
//	}
		@Test
		public void find2(){
			List<Orders> o = oService.findUserOrder(1);
			for(Orders oder: o){
			System.out.println(oder.getOid()+oder.getAname()+oder.getPhone()+oder.getStatus()+oder.getAddr());
			}
		}
	@Before
	public void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"root-context.xml");
		oService = context.getBean("oService", OrdersServiceImpl.class);

	}
}
