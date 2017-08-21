package com.yohomall.dao;

import com.yohomall.pojo.User;

public interface UserMapper {

	/**
	 * 
	 * @param name
	 * @return ¥Ê‘⁄∑µªÿ User£¨∑Ò‘Ú null
	 */
	User findByName(String name);

}
