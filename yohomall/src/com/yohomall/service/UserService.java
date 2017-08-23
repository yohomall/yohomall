package com.yohomall.service;

import com.yohomall.pojo.User;
import com.yohomall.service.exception.InvalidNameException;
import com.yohomall.service.exception.InvalidPasswordException;
import com.yohomall.service.exception.existException;

/**
 * 
 * @author YL
 *
 */
public interface UserService {

	/**
	 * �ͻ���¼
	 * 
	 * @param name
	 *            �û������ֻ��ţ�
	 * @param password
	 *            ����
	 * @return
	 * @throws InvalidNameException
	 * @throws InvalidPasswordException
	 */
	User login(String email, String password);
	User checkEmail(String email)throws existException;
	int register(User u);
	int update(User u);
}
