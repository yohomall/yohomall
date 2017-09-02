package com.yohomall.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yohomall.pojo.User;
import com.yohomall.service.exception.existException;
import com.yohomall.service.impl.UserServiceImpl;
import com.yohomall.util.PageUtil;
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
	public void check(String email, HttpServletResponse res) throws Exception {
		String patter = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern regex = Pattern.compile(patter);
		Matcher matcher = regex.matcher(email);
		boolean isMatched = matcher.matches();
		if (isMatched) {
			Integer flag = userService.checkEmail(email);
			if (flag != null && flag.intValue() > 0) {
				String message = "邮箱已注册，重新输入";
				res.setCharacterEncoding("UTF-8");
				res.getWriter().println(message);
			}
		} else {
			String message = "请输入正确的邮箱格式";
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
				m.addAttribute("message", "邮箱或密码错误");
				return "login";
			}

		}
		return "redirect:index.action";
	}

	@RequestMapping(value = "showUI", method = RequestMethod.GET)
	public String showUI(int uid, Model m) {
		return "showU";

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
	
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public ModelAndView admin(Model m,HttpServletRequest request) throws Exception{
		PageUtil<User> pageUtil =  new PageUtil<User>();
		pageUtil.setTotalRecord(userService.getTotalRecord());
		pageUtil.setPageSize(5);
		int pageNum = 1;
		if (request.getParameter("pageNum")!=null) {
			pageNum=Integer.valueOf(request.getParameter("pageNum"));
		}
		pageUtil.setPageNum(pageNum);
		int StartIndex=pageUtil.getStartIndex();
		List<User> ulist = userService.getByPage(StartIndex, pageUtil.getPageSize());
		pageUtil.setData(ulist);
		m.addAttribute("page", pageUtil);
		
		return new ModelAndView("admin/userList","page",pageUtil);
		
	}
}
