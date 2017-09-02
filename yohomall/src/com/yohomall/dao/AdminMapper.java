package com.yohomall.dao;

import org.apache.ibatis.annotations.Select;

import com.yohomall.pojo.Admin;

public interface AdminMapper {
	
	@Select("select * from admin where username=#{username}")
	Admin check(String username);
	
}
