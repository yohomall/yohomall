package com.yohomall.service;

import java.util.List;

import com.yohomall.pojo.Product;

public interface ProductService {
	Product getById(Integer id) throws Exception;
	
	List<Product> findWomen(Integer wsex) throws Exception;
	
	List<Product> findMen(Integer msex) throws Exception;
	
	int getTotalRecord(Integer tid)throws Exception;
	
	List<Product> getByPage(Integer tid, Integer StartIndex, Integer pageSize) throws Exception;
}
