package com.yohomall.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

	public static String getMD5(String password) throws NoSuchAlgorithmException {
		MessageDigest md5  = MessageDigest.getInstance("MD5");
		md5.update(password.getBytes());
		String result = new BigInteger(1,md5.digest()).toString(16);
		return result;
	}

}
