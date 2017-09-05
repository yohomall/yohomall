package com.yohomall.service;

import java.util.List;



import org.apache.ibatis.annotations.Param;
import org.springframework.core.annotation.Order;


import com.yohomall.pojo.Orders;
import com.yohomall.pojo.OrdersVo;

public interface OrdersService {
	

	int newOrder(Orders order);

	void save(Orders order) throws Exception;
	
	int getTotalRecord(Integer uid) throws Exception;
	/**
	 * 我的订单 分页查询
	 * @param uid
	 * @param StartIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<Orders> getMyOrdersByPage(Integer uid, Integer StartIndex, Integer pageSize) throws Exception;
	/**
	 * 获取订单详情
	 * @param oid
	 * @return
	 * @throws Exception
	 */
	Orders getByID(String oid) throws Exception;
	/**
	 * 更新订单
	 * @param order
	 * @throws Exception
	 */
	void update(Orders order)throws Exception;

	List<Orders> findOrderDetails();
	
	List<Orders> findAllOrder(Integer status,Integer StartIndex, Integer pageSize);
	
	Integer getAdminTotalRecord(Integer status);

}
