package com.yohomall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yohomall.dao.ProductMapper;
import com.yohomall.pojo.Product;
import com.yohomall.service.ProductService;

@Service(value="service")
public class ProductServiceImpl implements  ProductService{
	
	@Autowired
	private ProductMapper productMapper;
	/*查询单个商品*/
	@Override
	public Product getById(Integer id) throws Exception {
		return productMapper.getById(id);
	}
	
	@Override
	public List<Product> findWomen(Integer wsex) throws Exception {
		return productMapper.findWomen(wsex);
	}
	@Override
	public List<Product> findMen(Integer msex) throws Exception {
		return productMapper.findMen(msex);
	}

	@Override
	public int getTotalRecord(Integer tid) throws Exception{
		// TODO Auto-generated method stub
		return productMapper.getTotalRecord(tid);
	}

	@Override
	public List<Product> getByPage(Integer tid, Integer StartIndex, Integer pageSize)throws Exception {
		// TODO Auto-generated method stub
		return productMapper.getByPage(tid, StartIndex, pageSize);
	}

	/*@Override
	public List<Product> seek(String pname) throws Exception {
		List<Product> list = productMapper.seek(pname);
		return list;
	}*/

	@Override
	public List<Product> findAllProduct() throws Exception {
		// TODO Auto-generated method stub
		return productMapper.findAllProduct();
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productMapper.saveProduct(product);
	}

	@Override
	public void removeProduct(Integer pid) {
		// TODO Auto-generated method stub
		productMapper.removeProduct(pid);
	}
}
