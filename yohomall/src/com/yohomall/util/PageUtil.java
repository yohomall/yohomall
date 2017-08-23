package com.yohomall.util;

import java.util.List;

public class PageUtil<T> {
	private int pageNum;//��ǰҳ
	private int pageSize;//ÿҳ��¼��
	private int totalRecord;//��¼����
	
	@SuppressWarnings("unused")
	private int totalPage;//��ҳ��
	
	private List<T> data;//��ǰҳ������	
	
	
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
