package com.yohomall.service;

import com.yohomall.pojo.User;
import com.yohomall.service.exception.InvalidNameException;
import com.yohomall.service.exception.InvalidPasswordException;

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
	User login(String name, String password) throws InvalidNameException,
			InvalidPasswordException;

}
