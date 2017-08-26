package com.yohomall.service;

import java.util.List;

import com.yohomall.pojo.Product;

public interface SearchService {
	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	List<Product> add(String name) throws Exception;
}
