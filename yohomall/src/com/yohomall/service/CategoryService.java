package com.yohomall.service;

import java.util.List;

import com.yohomall.pojo.Category;

public interface CategoryService {
	/*查询所有分类*/
	List<Category> findClist() throws Exception;
	
	/*将分类集合转成json字符串*/
	String findAll() throws Exception;
	
	void save(Category category) throws Exception;
	
	Category getCategory(Integer tid) throws Exception;
	
	void updateCategory(Category category) throws Exception;
	
	void removeCategory(Integer tid)throws Exception;
}
