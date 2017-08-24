package com.yohomall.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yohomall.service.impl.CategoryServiceImpl;

@Controller
public class CategoryController {
	
	@Autowired
	 private CategoryServiceImpl cservice;
	 /**
	  * 将json数据返回给请求页面
	  * @param request
	  * @param response
	  * @throws Exception
	  */
	@RequestMapping(value="category")
	public void findAll(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");	
		
		String value = cservice.findAll();
		
		response.getWriter().println(value);
	} 
	 
}