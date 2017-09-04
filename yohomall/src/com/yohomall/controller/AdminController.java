package com.yohomall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yohomall.pojo.Admin;
import com.yohomall.service.impl.AdminServiceImpl;

@Controller
public class AdminController {
	@Autowired
	private AdminServiceImpl adService;
	@RequestMapping(value="/adminLoginUI",method = RequestMethod.GET)
	public String admin(){
		return "admin/index";
		
	}
	
	@RequestMapping(value="/adminLogin",method=RequestMethod.POST)
	public String login(String username,String password,HttpSession session,Model m){
		Admin ad = adService.login(username);
		if(ad!=null){
			if(ad.getPassword().equals(password)){
				session.setAttribute("admin", ad);
			}else{
				m.addAttribute("message", "用户名或密码错误");
				return "admin/index";
			}
		}
		return "admin/home";
		
	}
}
