package com.yohomall.service;

import com.yohomall.pojo.Product;

public interface ProductService {
	Product getById(Integer id) throws Exception;
}
