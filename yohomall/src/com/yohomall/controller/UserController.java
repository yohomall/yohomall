package com.yohomall.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yohomall.pojo.User;
import com.yohomall.service.exception.existException;
import com.yohomall.service.impl.UserServiceImpl;
import com.yohomall.util.Util;

@Controller
public class UserController {
	@Resource(name = "userService")
	private UserServiceImpl userService;
	@RequestMapping(value = "loginUI", method = RequestMethod.GET)
	public String loginUI() {
		return "login";
	}

	@RequestMapping(value = "registerUI", method = RequestMethod.GET)
	public String registerUI() throws NoSuchAlgorithmException {
		
		return "register";

	}

	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String register(User u) throws NoSuchAlgorithmException {
		u.setPassword(Util.getMD5(u.getPassword()));
		userService.register(u);

		
		return "redirect:index.action";
		

	}

	@RequestMapping(value = "check", method = RequestMethod.GET)
	public void check(String email, HttpServletResponse res) throws Exception  {
		Integer flag = userService.checkEmail(email);
		 
		if (flag!=null && flag.intValue()>0) {
			String message = "” œ‰“—◊¢≤·£¨÷ÿ–¬ ‰»Î";
			res.setCharacterEncoding("UTF-8");
			res.getWriter().println(message);
		}

	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String email, String password, HttpSession session,
			Model m) throws NoSuchAlgorithmException, IOException {
		User u = new User();
		u = userService.login(email, password);
		if (u != null) {
			if (Util.getMD5(password).equals(u.getPassword())) {
				session.setAttribute("user", u);
			} else {
				m.addAttribute("message", "” œ‰ªÚ√‹¬Î¥ÌŒÛ");
				return "login";
			}

		}
		return "redirect:index.action";
	}
	
	@RequestMapping(value = "editUI", method = RequestMethod.GET)
	public String editUI() {
		return "editU";

	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(User u) throws NoSuchAlgorithmException {
		
		userService.update(u);
		return "redirect:index.action";

	}

	@RequestMapping(value = "loginOut", method = RequestMethod.GET)
	public String loginOut(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		req.getSession().invalidate();
		return "redirect:index.action";
	}
}
