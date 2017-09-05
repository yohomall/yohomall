package com.yohomall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yohomall.pojo.Product;

/*@Repository(value="productMapper")*/
public interface ProductMapper {
	
	Product getById(@Param(value = "id")Integer id);
	
	List<Product> findWomen(@Param(value = "wsex") Integer wsex);
	
	List<Product> findMen(@Param(value = "msex") Integer msex);
	
	int getTotalRecord(@Param("tid") Integer tid);
	
	List<Product> getByPage(@Param("tid") Integer tid,@Param("StartIndex")Integer StartIndex,
			@Param("pageSize")Integer pageSize);
	

	 /*@Select("select * from products where pname like %${name}%")
		List<Product> seek(String name);*/
	 
	 @Select("SELECT * from products")
	 List<Product> findAllProduct();
	 
	 @Insert("INSERT INTO products(image,pname,price,sellingprice,tid) VALUES(#{image},#{pname},#{price},#{sellingprice},#{category.tid})")
	 void saveProduct(Product product);
	 
	 @Delete("DELETE FROM products WHERE pid=#{pid}")
	 void removeProduct(Integer pid);

	

}
