package com.yohomall.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yohomall.pojo.Cart;
import com.yohomall.pojo.CartItem;
import com.yohomall.pojo.Product;
import com.yohomall.pojo.User;
import com.yohomall.service.impl.ProductServiceImpl;

/**
 * 购物车模块
 * @author Administrator
 *
 */
@Controller
public class CartController {
	@Autowired
	private ProductServiceImpl service;
	/**
	 * 将商品添加到购物车
	 * @param pid 商品id
	 * @param count 商品数量
	 * @param request
	 * @return
	 */
	@RequestMapping(value="cart", method=RequestMethod.GET)
	public String add2cart(@RequestParam(value="pid") Integer pid,@RequestParam(value="count") int count,HttpServletRequest request) {
		User user= (User) request.getSession().getAttribute("user");
		
		//1.封装cartitem
		//调用service得到product
		try {
			Product product=service.getById(pid);
			//创建cartitem
			CartItem cartItem=new CartItem(product, count);
			
			//2.将cartitem加入购物车
			//获取购物车
			Cart cart=getCart(request);
			
			cart.add2cart(cartItem);
			
			if (user==null) {
				cart.clearCart();
			}
			
			return "redirect:/jsp/cart.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "添加购物车失败!");
			return "msg";
		}
		
	}
	/**
	 * 将购物放入session中，从session中获取购物车
	 * @param request
	 * @return
	 */
	private Cart getCart(HttpServletRequest request) {
		
		Cart cart=(Cart) request.getSession().getAttribute("cart");
			if (cart==null) {
				cart=new Cart();
				request.getSession().setAttribute("cart", cart);
			}
		
		return cart;
		
	}
	/**
	 * 从购物车中删除商品
	 * @param pid 商品id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="remove")
	public String  remove(@RequestParam(value="pid")Integer pid,HttpServletRequest request) {
		//获取商品id
		getCart(request).removeCarItem(pid);
		
		return "redirect:/jsp/cart.jsp";
	}
	/**
	 * 清空购物车
	 * @param request
	 * @return
	 */
	@RequestMapping()
	public String clear(HttpServletRequest request) {
		//清空购物车
		getCart(request).clearCart();
		return "redirect:/jsp/cart.jsp";
		
	} 
}
