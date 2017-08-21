package com.yohomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yohomall.dao.ProductMapper;
import com.yohomall.pojo.Product;
import com.yohomall.service.ProductService;

@Service(value="service")
public class ProductServiceImpl implements  ProductService{
	
	@Autowired
	private ProductMapper productMapper;
	@Override
	public Product getById(Integer id) throws Exception {
		return productMapper.getById(id);
	}

}
