package com.yohomall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yohomall.pojo.Orders;

public interface OrdersMapper {
	
	
	
	@Insert("insert into Orders(uid,addr,aname,phone,total,time,status) values(#{uid},#{addr},#{aname},#{phone},#{total},#{time},#{status})")
	int add(Orders order);
	
	Orders findById(int oid);
	@Select("select * from orders where uid = #{uid}")
	List<Orders> findByUid(int uid);
}
