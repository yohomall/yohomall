package com.yohomall.pojo;

import java.io.Serializable;

import java.util.List;
/**
 * 
 * @author HerryHx
 *
 */
public class Orderitem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private String itemid;
      private Integer quantity;
      private Double subtotal;
      private Product product;
      private Orders order;
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
}
