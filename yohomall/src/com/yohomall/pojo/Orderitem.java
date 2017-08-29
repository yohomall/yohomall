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
      private Product pid;
      private Orders oid;
      private Integer quantity;
      private List<Product> product;
      
	public Orderitem() {
		
	}
	public Orderitem(Product pid, Orders oid, Integer quantity, List<Product> product) {
		super();
		this.pid = pid;
		this.oid = oid;
		this.quantity = quantity;
		this.product = product;
	}
	public Product getPid() {
		return pid;
	}
	public void setPid(Product pid) {
		this.pid = pid;
	}
	public Orders getOid() {
		return oid;
	}
	public void setOid(Orders oid) {
		this.oid = oid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
      
}
