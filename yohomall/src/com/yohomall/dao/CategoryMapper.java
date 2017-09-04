package com.yohomall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yohomall.pojo.Category;

public interface CategoryMapper {
	@Select("select * from product_types")
	List<Category> findClist();
	
	@Insert("insert into product_types(type) values(#{type})")
	void save(Category category);
	
	Category getCategory(@Param("tid") Integer tid);
	
	@Update(" UPDATE product_types SET type=#{type} WHERE tid=#{tid}")
	void updateCategory(Category category);
	
	@Delete("DELETE FROM product_types WHERE tid=#{tid}")
	void removeCategory(Integer tid);
}
