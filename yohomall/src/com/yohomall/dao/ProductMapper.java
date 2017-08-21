package com.yohomall.dao;

import org.apache.ibatis.annotations.Select;

import com.yohomall.pojo.Product;

/*@Repository(value="productMapper")*/
public interface ProductMapper {
	@Select("select * from products where tid=#{id}")
	Product getById(Integer id);
}
