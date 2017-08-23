package com.yohomall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yohomall.pojo.Category;

public interface CategoryMapper {
	@Select("select * from product_types")
	List<Category> findClist();
	
	
}
