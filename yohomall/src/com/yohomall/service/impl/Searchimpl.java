package com.yohomall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yohomall.dao.SearchMapper;
import com.yohomall.pojo.Product;
import com.yohomall.service.SearchService;

public class Searchimpl implements SearchService{
    @Autowired
	private SearchMapper search;

	@Override
	public List<Product> add(String name) {
		List<Product> list = search.add(name);
		return list;
	}
}
