package com.yohomall.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yohomall.pojo.User;

public interface UserMapper {

	/**
	 * 
	 * @param name
	 * @return ¥Ê‘⁄∑µªÿ User£¨∑Ò‘Ú null
	 */
	@Select("select * from user where email=#{email}")
	User findByName(String email);
	
	@Select("select * from user where email=#{email}")
	User checkName(String email);
	@Insert("insert into user(email,password,sex,birthday,uname,nickname)"
			+ "values(#{email},#{password},#{sex},#{birthday},#{uname},#{nickname})")
	int add(User u);
	
	@Update("update user set password=#{password},sex=#{sex},birthday=#{birthday},nickname=#{nickname} where uid = #{uid}")
	int update(User u);
}
