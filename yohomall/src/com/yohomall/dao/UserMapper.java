package com.yohomall.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yohomall.pojo.User;

public interface UserMapper {

	/**
	 * 
	 * @param email
	 * @return
	 */
	@Select("select count(*) from user where email=#{email} limit 1")
	int findByEmail(String email);

	/**
	 * 
	 * @param email
	 * @return
	 */
	@Select("select * from user where email=#{email}")
	User find(String email);
	/**
	 * 
	 * @param u
	 * @return
	 */
	@Insert("insert into user(email,password,sex,birthday,uname,nickname)"
			+ "values(#{email},#{password},#{sex},#{birthday},#{uname},#{nickname})")
	int add(User u);

	/**
	 * 
	 * @param u
	 * @return
	 */
	@Update("update user set sex=#{sex},birthday=#{birthday},nickname=#{nickname} where uid = #{uid}")
	int update(User u);
	
	@Select("select * from user where uid=#{uid}")
	User findById(int id);
}
