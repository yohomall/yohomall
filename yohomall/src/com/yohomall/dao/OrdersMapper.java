package com.yohomall.dao;

import org.apache.ibatis.annotations.Insert;

import com.yohomall.pojo.Orders;

public interface OrdersMapper {
	
	
	Orders findById(int oid);
	
	@Insert("insert into Orders(uid,addr,aname,phone,total,time,status) values(#{uid},#{addr},#{aname},#{phone},#{total},#{time},#{status})")
	int add(Orders order);
}
