package com.yohomall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yohomall.pojo.Product;
import com.yohomall.service.impl.ProductServiceImpl;
import com.yohomall.util.ContantUtil;

@Controller
public class IndexConller {
	
	@Autowired
	private ProductServiceImpl service;
	
	@RequestMapping(value="index")
	public String index(Model model) throws Exception {
		
		List<Product> wList=service.findWomen(ContantUtil.WOMEM);
		List<Product> mList=service.findMen(ContantUtil.MEM);
		
		model.addAttribute("wlist", wList);
		model.addAttribute("mlist", mList);
		
		return "/jsp/index";
		
	}
}
