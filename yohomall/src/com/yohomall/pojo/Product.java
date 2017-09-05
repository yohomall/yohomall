package com.yohomall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pid;
	private String image;
	private String pname;
	private Double price;
	private Double sellingprice;
	private Integer  sex;
	//商品类型
	private Category category;
	private List<Item> items;
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSellingprice() {
		return sellingprice;
	}

	public void setSellingprice(Double sellingprice) {
		this.sellingprice = sellingprice;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
	
}
