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
	 * 
	 * @param email
	 * @param password
	 * @return User
	 */
	User login(String email, String password);

	/**
	 * 
	 * @param email
	 * @return
	 * @throws existException
	 */
	int checkEmail(String email) throws existException;

	/**
	 * 
	 * @param u
	 * @return
	 */
	int register(User u);

	/**
	 * 
	 * @param u
	 * @return
	 */
	int update(User u);
	
	User findById(int id);
	
}
