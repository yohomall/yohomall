package com.yohomall.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yohomall.pojo.Orders;

public interface OrdersService {
	int newOrder(Orders order);
	Orders findOrderDetails(@Param(value="oid") int oid);
	List<Orders> findUserOrder(int uid);
}
