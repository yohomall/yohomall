package com.yohomall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.yohomall.pojo.Product;


@Repository("SearchMapper")
public interface SearchMapper {
     @Select("select * from products where pname like %${name}%")
	List<Product> add(String name);
}