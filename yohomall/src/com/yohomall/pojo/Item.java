package com.yohomall.pojo;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pid;
	private int oid;
	private int quantity;
	private List<Product> product;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}

	
}
