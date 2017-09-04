package com.yohomall.service.impl;

import java.util.List;

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

	@Override
	public Orders findOrderDetails(int oid) {
		
		return ordersMapper.findById(oid);
	}

	@Override
	public List<Orders> findUserOrder(int uid) {
		
		return ordersMapper.findByUid(uid);
	}

}
