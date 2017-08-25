package com.yohomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yohomall.dao.ProductSalesMapper;
import com.yohomall.pojo.Orderitem;

import com.yohomall.service.ProductSalesService;
import com.yohomall.service.exception.NotMoreProductsException;

/**
 * 
 * @author HerryHx
 *
 */
@Service(value = "psService")
public class ProductSalesServiceImpl implements ProductSalesService {
	@Autowired
	ProductSalesMapper psMapper;

	@Override
	public Orderitem oneSales(Integer pid) throws NotMoreProductsException {

		return psMapper.findOneSales(pid);
	}

	@Override
	public int AllSales() throws NotMoreProductsException {

		return 0;
	}

}
