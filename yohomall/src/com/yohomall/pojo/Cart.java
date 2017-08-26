package com.yohomall.pojo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<Integer, CartItem> itemMap=new HashMap<>();
	
	public  Collection<CartItem> getCartItems(){
		return itemMap.values();
	}
	
	private Double total=0.0;

	public Map<Integer, CartItem> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<Integer, CartItem> itemMap) {
		this.itemMap = itemMap;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	/**
	 * 加入到购物车
	 * @param cartItem
	 */
	public void add2cart(CartItem cartItem) {
		//获取商品id
		Integer pid = cartItem.getProduct().getPid();
		//判断购物车是否有购物项
		if (itemMap.containsKey(pid)) {
			//有 修改数量  = 原来数量+新加的数量
			//原有的购物项
			CartItem ocartItem=itemMap.get(pid);
			
			ocartItem.setCount(ocartItem.getCount()+cartItem.getCount());
			
		} else {
			//无
			itemMap.put(pid, cartItem);
		}
		
		//修改总金额
		total+=cartItem.getSubtotal();
	}
	/**
	 * 从购物车移除一个购物项
	 * @param pid
	 */
	public void removeCarItem(Integer pid) {
		//从购物车(map)中移除购物项
		CartItem item = itemMap.remove(pid);
		//修改总金额
		total-=item.getSubtotal();
	}
	/**
	 * 清空购物车
	 */
	public void clearCart() {
		//清空map
		itemMap.clear();
		//修改总金额 0.0
		total=0.0;
	}
	
}
