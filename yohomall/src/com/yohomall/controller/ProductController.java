package com.yohomall.controller;

import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yohomall.pojo.Product;
import com.yohomall.service.impl.ProductServiceImpl;
import com.yohomall.util.PageUtil;


@Controller
public class ProductController {
	@Autowired
	private ProductServiceImpl service;
	
	@RequestMapping(value="product")
	public String list(Model model,Integer tid,HttpServletRequest request) throws Exception {
		PageUtil<Product> pageUtil =new PageUtil<>();
		pageUtil.setTotalRecord(service.getTotalRecord(tid));
		pageUtil.setPageSize(6);
		int pageNum=1;
		if (request.getParameter("pageNum")!=null) {
			pageNum=Integer.valueOf(request.getParameter("pageNum"));
		}
		/*System.out.println(pageNum);*/
		pageUtil.setPageNum(pageNum);
		int StartIndex=pageUtil.getStartIndex();
		
		List<Product> list= service.getByPage(tid, StartIndex, 6);
		/*System.out.println(list.size());*/
		pageUtil.setData(list);
		
		model.addAttribute("page", pageUtil);
		return "product_list";
	}
	
	@RequestMapping(value="getProduct")
	public String getById(Integer id,Model model) throws Exception {
		
		Product product=service.getById(id);
		
		model.addAttribute("bean", product);
		
		return  "product_info";
	}
	
}
