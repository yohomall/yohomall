package com.yohomall.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yohomall.pojo.Category;
import com.yohomall.pojo.Product;
import com.yohomall.service.impl.CategoryServiceImpl;
import com.yohomall.service.impl.ProductServiceImpl;
import com.yohomall.util.UUIDUtils;

@Controller
public class AdminProductConroller {
	@Autowired
	private ProductServiceImpl service;
	@Autowired
	private CategoryServiceImpl cservice;
	
	@RequestMapping(value="adminProduct")
	public String findAllProduct(Model model) throws Exception {
		List<Product> list = service.findAllProduct();
		
		model.addAttribute("list", list);
		
		return "/admin/product/list";
		
	}
	
	@RequestMapping(value="addProduct")
	public String add(Model model) throws Exception {
		
		model.addAttribute("list", cservice.findClist());
		
		return "/admin/product/add";
	}
	
	@RequestMapping(value="saveProduct",method=RequestMethod.POST)
	public String save(MultipartFile pimage,Product product,Category category,HttpServletRequest request) throws Exception{
		//原始名称
		String originalFilename = pimage.getOriginalFilename(); 
		
		if (pimage!=null && originalFilename!=null && originalFilename.length()>0) {
			//存储图片的物理路径
			String pic_path="C:\\Users\\Administrator\\git\\yohomall\\yohomall\\WebContent\\pictrue\\";	
			
			//新的图片名称
			String newFileName=UUIDUtils.getId()+originalFilename.substring(originalFilename.lastIndexOf("."));
			
			//新图片
			File newPictrue=new File(pic_path+newFileName);
			//写入磁盘
			pimage.transferTo(newPictrue);
			
			product.setImage(newFileName);
		}
		
		product.setCategory(category);
		
		service.saveProduct(product);
		
		return "redirect:/adminProduct.action";
	}
	
	@RequestMapping(value="removeProduct")
	public String removeProduct(Integer pid) throws Exception {
		
		service.removeProduct(pid);
		
		return "redirect:/adminProduct.action";
	}
}
