package com.yohomall.dao;

import com.yohomall.pojo.User;

public interface UserMapper {

	/**
	 * 
	 * @param name
	 * @return ���ڷ��� User������ null
	 */
	User findByName(String name);

}
