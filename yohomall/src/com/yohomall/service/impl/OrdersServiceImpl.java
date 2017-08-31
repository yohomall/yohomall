package com.yohomall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yohomall.dao.OrdersMapper;
import com.yohomall.pojo.Orderitem;
import com.yohomall.pojo.Orders;
import com.yohomall.pojo.OrdersVo;
import com.yohomall.service.OrdersService;
import com.yohomall.service.exception.existException;



@Service(value="oservice")
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersMapper ordersMapper;
	@Override
	public int newOrder(Orders order) {
		return ordersMapper.add(order);
	}
	
	@Transactional
	@Override
	public void save(Orders order) throws Exception{
		//向orders表中插入一条数据
		ordersMapper.save(order);
		//向orderitem表中插入多条数据
		for (Orderitem orderitem:order.getOrderitems()) {
			ordersMapper.saveOrderItem(orderitem);
		}
	}


	@Override
	public int getTotalRecord(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		return ordersMapper.getTotalRecord(uid);
	}


	@Override
	public List<Orders> getMyOrdersByPage(Integer uid, Integer StartIndex, Integer pageSize) throws Exception {
		
		List<Orders> list=ordersMapper.getMyOrdersByPage(uid, StartIndex, pageSize);
		
		for (Orders orders : list) {
			List<OrdersVo> list2=ordersMapper.getMyOrderItem(orders.getOid());
			for (OrdersVo ordersVo : list2) {
				
				orders.getOrdersVos().add(ordersVo);
			}
		}
		
		return list;
	}

	@Override
	public Orders getByID(String oid) throws Exception {
		
		Orders order=ordersMapper.getByID(oid);
		List<OrdersVo> list=ordersMapper.getMyOrderItem(oid);
		for (OrdersVo ordersVo : list) {
			order.getOrdersVos().add(ordersVo);
		}
		
		
		return order;
	}

	@Override
	public void update(Orders order) throws Exception {
		
		ordersMapper.update(order);
	}

	

}
