package com.yohomall.service;

import java.util.List;

import com.yohomall.pojo.Category;

public interface CategoryService {
	/*��ѯ���з���*/
	List<Category> findClist() throws Exception;
	
	/*�����༯��ת��json�ַ���*/
	String findAll() throws Exception;
}
