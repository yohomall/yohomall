package com.yohomall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yohomall.pojo.Category;
import com.yohomall.service.impl.CategoryServiceImpl;

@Controller
public class AdminCategoryCotroller {
	
	@Autowired
	private CategoryServiceImpl cservice;
	
	@RequestMapping(value="adminCategory")
	public String findAllCategory(Model model) throws Exception {
		List<Category> list =cservice.findClist();
		
		model.addAttribute("list", list);
		
		return "/admin/category/list";
	}	
	
	@RequestMapping(value="addCategory")
	public String add() {
		return "/admin/category/add";
		
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public String save(Category category) throws Exception {
		
		cservice.save(category);
		
		return "redirect:/adminCategory.action";
		
	}
	
	@RequestMapping(value="getCategory")
	public String getgetCategory(Integer tid,Model model) throws Exception {
		Category category=cservice.getCategory(tid);
		
		model.addAttribute("bean", category);
		
		return "/admin/category/edit";
	}
	
	@RequestMapping(value="updateCategory",method=RequestMethod.POST)
	public String updateCategory(Category category) throws Exception {
		cservice.updateCategory(category);
		
		return "redirect:/adminCategory.action";
		
	}
	
	@RequestMapping(value="removeCategory")
	public String removeCategory(Integer tid) throws Exception {
		
		cservice.removeCategory(tid);
		
		return "redirect:/adminCategory.action";
	}
	
}
