package com.yohomall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//��Ʒ	
	private Product product;
	//����
	private Integer count;
	//С��
	private Double subtotal;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return product.getSellingprice()*count;
	}
	/*public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}*/
 
	public CartItem() {

	}
	public CartItem(Product product, Integer count) {
		super();
		this.product = product;
		this.count = count;
	}
	
	
}
