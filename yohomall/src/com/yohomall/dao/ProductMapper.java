package com.yohomall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yohomall.pojo.Product;

/*@Repository(value="productMapper")*/
public interface ProductMapper {
	
	Product getById(@Param(value = "id")Integer id);
	
	List<Product> findWomen(@Param(value = "wsex") Integer wsex);
	
	List<Product> findMen(@Param(value = "msex") Integer msex);
	
	int getTotalRecord(@Param("tid") Integer tid);
	
	List<Product> getByPage(@Param("tid") Integer tid,@Param("StartIndex")Integer StartIndex,
			@Param("pageSize")Integer pageSize);
	
		List<Product> seek(@Param("pname") String pname);
}
