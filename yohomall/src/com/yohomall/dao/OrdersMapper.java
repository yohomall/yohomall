package com.yohomall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.core.annotation.Order;

import com.yohomall.pojo.Orderitem;
import com.yohomall.pojo.Orders;
import com.yohomall.pojo.OrdersVo;
import com.yohomall.pojo.Product;

public interface OrdersMapper {
	
	
	
	@Insert("insert into Orders(uid,addr,aname,phone,total,time,status) values(#{uid},#{addr},#{aname},#{phone},#{total},#{time},#{status})")
	int add(Orders order);
	

	@Insert("insert into orders(oid,uid,addr,aname,phone,total,time,status) values(#{oid},#{user.uid},#{addr},#{aname},#{phone},#{total},#{time},#{status})")
	void save(Orders order);
	
	@Insert("insert into orderitem(itemid,pid,oid,quantity,subtotal) values(#{itemid},#{product.pid},#{order.oid},#{quantity},#{subtotal})")
	void saveOrderItem(Orderitem orderitem);
	
	int getTotalRecord(@Param(value="uid") Integer uid);
	
	List<Orders> getMyOrdersByPage(@Param("uid") Integer uid,@Param("StartIndex")Integer StartIndex,
			@Param("pageSize")Integer pageSize);
	
	List<OrdersVo> getMyOrderItem(@Param("oid") String oid);
	
	Orders getByID(@Param("oid") String oid);
	
	@Update("update orders set addr=#{addr},aname=#{aname},phone=#{phone},status=#{status} where oid=#{oid}")
	void update(Orders order);

	List<Orders> findOrderDetails();

}
