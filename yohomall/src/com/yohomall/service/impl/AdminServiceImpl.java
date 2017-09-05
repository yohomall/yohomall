package com.yohomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yohomall.dao.AdminMapper;
import com.yohomall.pojo.Admin;
import com.yohomall.service.AdminService;

@Service(value="adService")
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper adMapper;
	
	@Override
	public Admin login(String username) {
	
		return adMapper.check(username);
	}

}
