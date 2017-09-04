package com.yohomall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yohomall.pojo.Item;
import com.yohomall.pojo.Orders;
import com.yohomall.service.impl.OrdersServiceImpl;

@Controller
public class OrdersController {
	@Autowired
	private OrdersServiceImpl oService;
	@RequestMapping(value="order", method=RequestMethod.GET)
	public String findOrder(int uid,Model m){
		List<Orders> orders = oService.findUserOrder(uid);
		m.addAttribute("order", orders);
		return "/jsp/order_list";
		
	}
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String orderDetails(int oid,Model m){
		Orders os = oService.findOrderDetails(oid);
			List<Item> im =os.getItems();
			m.addAttribute("item", im);
			return "/jsp/order_info";
		
	}
}
