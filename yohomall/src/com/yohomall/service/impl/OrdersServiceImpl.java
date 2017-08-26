package com.yohomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yohomall.dao.OrdersMapper;
import com.yohomall.pojo.Orders;
import com.yohomall.service.OrdersService;


@Service(value="oService")
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersMapper ordersMapper;
	@Override
	public int newOrder(Orders order) {
		return ordersMapper.add(order);
	}

}
