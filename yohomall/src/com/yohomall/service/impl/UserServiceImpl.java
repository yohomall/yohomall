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
@Service(value = "userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yohomall.service.UserService#login(java.lang.String,
	 * java.lang.String)
	 */
	// �û���¼
	@Override
	public User login(String email, String password) {
		User u = new User();
		boolean flag= userMapper.findByEmail(email);
		if (flag == true) {
			System.out.println("����ע��");
		}  else {
			System.out.println("��¼ʧ��");
		}
		return u;

	}

	// ��֤�����Ƿ����
	@Override
	public boolean checkEmail(String email) throws existException {
		userMapper.findByEmail(email);
		return true;
	}

	// ע��
	@Override
	public int register(User u) {
		return userMapper.add(u);
	}

	// �༭��������
	@Override
	public int update(User u) {
		return userMapper.update(u);
	}

}
