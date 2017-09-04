package com.yohomall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yohomall.pojo.Item;
import com.yohomall.pojo.Product;

public interface ItemMapper {
 
	List<Item> findById(@Param(value="pid") int pid);
}
