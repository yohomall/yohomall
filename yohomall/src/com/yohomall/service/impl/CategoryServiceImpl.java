package com.yohomall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Service;

//import com.google.gson.Gson;
import com.yohomall.dao.CategoryMapper;
import com.yohomall.pojo.Category;
import com.yohomall.service.CategoryService;

@Service(value="cservice")
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryMapper categoryMapper;
	
	/*��ѯ���з���*/
	@Override
	public List<Category> findClist() throws Exception{
		return categoryMapper.findClist();
	}
	
	//����Ʒ���ͼ���ת��json�ַ���
	@Override
	public String findAll() throws Exception {
		List<Category> list = findClist();
		if (list!=null && list.size()>0) {
			//Gson gson = new Gson();
			//return gson.toJson(list).toString();
		}
		return null;
	}

}
