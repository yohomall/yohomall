package com.yohomall.service;

import java.util.List;

import com.yohomall.pojo.Product;

public interface ProductService {
	/**
	 * 根据商品id查询出单个商品
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Product getById(Integer id) throws Exception;
	
	List<Product> findWomen(Integer wsex) throws Exception;
	
	List<Product> findMen(Integer msex) throws Exception;
	/**
	 * 根据商品类型id查询记录总数
	 * @param tid 商品类型id
	 * @return
	 * @throws Exception
	 */
	int getTotalRecord(Integer tid)throws Exception;
	/**
	 * 根据商品类型id进行分页
	 * @param tid 商品类型id
	 * @param StartIndex 开始索引
	 * @param pageSize	每页记录数
	 * @return
	 * @throws Exception
	 */
	List<Product> getByPage(Integer tid, Integer StartIndex, Integer pageSize) throws Exception;
}
