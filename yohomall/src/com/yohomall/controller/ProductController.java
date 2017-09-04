package com.yohomall.controller;

import java.util.List;

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
	/**
	 * 
	 * @param model 
	 * @param tid 	��Ʒ����id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	//��Ʒ��ҳ
	@RequestMapping(value="product")
	public String list(Model model,Integer tid,HttpServletRequest request) throws Exception {
		PageUtil<Product> pageUtil =new PageUtil<>();
		pageUtil.setTotalRecord(service.getTotalRecord(tid));
		pageUtil.setPageSize(8);
		int pageNum=1;
		if (request.getParameter("pageNum")!=null) {
			pageNum=Integer.valueOf(request.getParameter("pageNum"));
		}
		
		pageUtil.setPageNum(pageNum);
		int StartIndex=pageUtil.getStartIndex();
		
		List<Product> list= service.getByPage(tid, StartIndex, pageUtil.getPageSize());
		
		pageUtil.setData(list);
		
		model.addAttribute("page", pageUtil);
		return "product_list";
	}
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	//��ѯ������Ʒ
	@RequestMapping(value="getProduct")
	public String getById(Integer id,Model model) throws Exception {
		
		Product product=service.getById(id);
		
		model.addAttribute("bean", product);
		
		return  "product_info";
	}
	
	@RequestMapping(value="seek")
	public String getSeek(String pname,Model model) throws Exception{
		List<Product> list = service.seek(pname);

		model.addAttribute("seek",list);
		return "seek_info";	
	}
	
}
