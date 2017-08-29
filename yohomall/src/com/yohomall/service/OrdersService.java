package com.yohomall.service;

import java.util.List;

import com.yohomall.pojo.Orders;

public interface OrdersService {
	int newOrder(Orders order);
	List<Orders> findOrderDetails();
}
