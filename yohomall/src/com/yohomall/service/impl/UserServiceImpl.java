package com.yohomall.service.impl;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yohomall.dao.UserMapper;
import com.yohomall.pojo.User;
import com.yohomall.service.UserService;
import com.yohomall.service.exception.InvalidNameException;
import com.yohomall.service.exception.InvalidPasswordException;
import com.yohomall.service.exception.existException;
import com.yohomall.util.Util;

/**
 * 
 * @author YL
 *
 */
@Service(value="uservice")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	/*
	 * (non-Javadoc)
	 * @see com.yohomall.service.UserService#login(java.lang.String, java.lang.String)
	 */
	//用户登录
	@Override
	public User login(String email, String password) {

		User user = userMapper.findByName(email);
		
		try {
			if (user == null){
				System.out.println("请先注册");
			}else if(Util.getMD5(password).equals(user.getPassword())){
				System.out.println("登录成功");
			}else{
				System.out.println("登录失败");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return user;
		
	}
	//验证邮箱是否存在
	@Override
	public User checkEmail(String email) throws existException {
		User u = new User();
		u=userMapper.checkName(email);
		if(u!=null){
			throw new existException("用户已存在");
		}
		
		return u;
	}
	
	
	//注册
	@Override
	public int register(User u) {
		
		return userMapper.add(u);
	}
	
	
	//编辑个人资料
	@Override
	public int update(User u) {
		
		return userMapper.update(u);
	}
	
	
	

}
