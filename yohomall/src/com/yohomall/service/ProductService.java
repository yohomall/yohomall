package com.yohomall.service;

import java.util.List;

import com.yohomall.pojo.Product;

public interface ProductService {
	/**
	 * ������Ʒid��ѯ��������Ʒ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Product getById(Integer id) throws Exception;
	
	List<Product> findWomen(Integer wsex) throws Exception;
	
	List<Product> findMen(Integer msex) throws Exception;
	/**
	 * ������Ʒ����id��ѯ��¼����
	 * @param tid ��Ʒ����id
	 * @return
	 * @throws Exception
	 */
	int getTotalRecord(Integer tid)throws Exception;
	/**
	 * ������Ʒ����id���з�ҳ
	 * @param tid ��Ʒ����id
	 * @param StartIndex ��ʼ����
	 * @param pageSize	ÿҳ��¼��
	 * @return
	 * @throws Exception
	 */
	List<Product> getByPage(Integer tid, Integer StartIndex, Integer pageSize) throws Exception;
}
