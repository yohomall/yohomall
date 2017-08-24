package com.yohomall.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yohomall.pojo.User;
import com.yohomall.service.UserService;
import com.yohomall.service.exception.existException;
import com.yohomall.service.impl.UserServiceImpl;


@Controller
public class UserController {
	@Resource(name="userService")
	private UserServiceImpl userService;
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String add(User u){
		userService.register(u);
		return "redirect:index";
		
	}
	@RequestMapping(value="check",method = RequestMethod.GET)
	public void check(String email,HttpServletResponse res) throws Exception {
		boolean u1=userService.checkEmail(email);
		if(u1){
			String message = "邮箱已注册，重新输入";
			res.setCharacterEncoding("UTF-8");
			res.getWriter().println(message);
		}
		
		
	}
}
