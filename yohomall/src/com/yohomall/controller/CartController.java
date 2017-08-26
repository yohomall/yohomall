package com.yohomall.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yohomall.pojo.Cart;
import com.yohomall.pojo.CartItem;
import com.yohomall.pojo.Product;
import com.yohomall.service.impl.ProductServiceImpl;

@Controller
public class CartController {
	@Autowired
	private ProductServiceImpl service;
	/**
	 * ����Ʒ��ӵ����ﳵ
	 * @param pid ��Ʒid
	 * @param count ��Ʒ����
	 * @param request
	 * @return
	 */
	@RequestMapping(value="cart", method=RequestMethod.GET)
	public String add2cart(@RequestParam(value="pid") Integer pid,@RequestParam(value="count") int count,HttpServletRequest request) {
		//1.��װcartitem
		//����service�õ�product
		try {
			Product product=service.getById(pid);
			//����cartitem
			CartItem cartItem=new CartItem(product, count);
			
			//2.��cartitem���빺�ﳵ
			//��ȡ���ﳵ
			Cart cart=getCart(request);
			
			cart.add2cart(cartItem);
			
			return "redirect:/jsp/cart.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "��ӹ��ﳵʧ��!");
			return "msg";
		}
		
	}
	/**
	 * ���������session�У���session�л�ȡ���ﳵ
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
	 * �ӹ��ﳵ��ɾ����Ʒ
	 * @param pid ��Ʒid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="remove")
	public String  remove(@RequestParam(value="pid")Integer pid,HttpServletRequest request) {
		//��ȡ��Ʒid
		getCart(request).removeCarItem(pid);
		
		return "redirect:/jsp/cart.jsp";
	}
	/**
	 * ��չ��ﳵ
	 * @param request
	 * @return
	 */
	@RequestMapping()
	public String clear(HttpServletRequest request) {
		//��չ��ﳵ
		getCart(request).clearCart();
		return "redirect:/jsp/cart.jsp";
		
	} 
}
