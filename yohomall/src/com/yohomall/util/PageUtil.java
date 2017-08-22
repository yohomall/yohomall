package com.yohomall.util;

import java.util.List;

public class PageUtil<T> {
	private int pageNum;//当前页
	private int pageSize;//每页记录数
	private int totalRecord;//记录总数
	
	@SuppressWarnings("unused")
	private int totalPage;//总页数
	
	private List<T> data;//当前页的数据	
	
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		if (totalRecord%pageSize==0) {
			return totalPage=totalRecord/pageSize;
		}
		return totalPage=(totalRecord/pageSize+1);
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public int getStartIndex(){
		return (pageNum-1)*pageSize;
	}
	
}
