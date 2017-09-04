package com.yohomall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.yohomall.pojo.Orders;
import com.yohomall.pojo.OrdersVo;
import com.yohomall.service.impl.OrdersServiceImpl;
import com.yohomall.util.ContantUtil;
import com.yohomall.util.PageUtil;

@Controller
public class AdminOrderController {
	@Autowired
	private OrdersServiceImpl oservice;
	
	
	@RequestMapping(value="updateStatus")
	public String updateStatus(String oid) throws Exception {
		Orders order= oservice.getByID(oid);
		
		order.setStatus(ContantUtil.ORDER_YIFAHUO);
		
		oservice.update(order);
		
		return "redirect:/adminOrder.action?status=1&pageNum=1";
	}
	
	
	
	@RequestMapping(value="adminOrder")
	public String findALLOrder(Integer status,Model model,HttpServletRequest request) {
		PageUtil<Orders> pageUtil=new PageUtil<>();
		pageUtil.setTotalRecord(oservice.getAdminTotalRecord(status));
		int pageNum=1;
		if (request.getParameter("pageNum")!=null) {
			pageNum=Integer.valueOf(request.getParameter("pageNum"));
		}
		pageUtil.setPageNum(pageNum);
		pageUtil.setPageSize(5);
		
		int StartIndex=pageUtil.getStartIndex();
		
		List<Orders> list=oservice.findAllOrder(status,StartIndex,pageUtil.getPageSize());
		if (status!=null) {
			String status1= String.valueOf(status);
			model.addAttribute("status", status1);
		}
		
		pageUtil.setData(list);
		
		model.addAttribute("pg", pageUtil);
		
		return "/admin/order/list";
		
	}	
	
	@RequestMapping(value="showDetail",method=RequestMethod.POST)
	public void showDetail(HttpServletResponse response,String oid) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		Orders order=oservice.getByID(oid);
		
		List<OrdersVo> list= order.getOrdersVos();
		
		Gson gson=new Gson();
		if (list!=null && list.size()>0) {
			String value= gson.toJson(list).toString();
			response.getWriter().println(value);
		}
	}
	
}
