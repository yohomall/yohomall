package com.yohomall.dao;

import org.apache.ibatis.annotations.Param;

import com.yohomall.pojo.Orderitem;




/**
 * 
 * @author HerryHx
 *   商品销售的服务层
 */
public interface ProductSalesMapper {
	/**
	 * 
	 * @param pid
	 * @return
	 */
	Orderitem findOneSales(@Param("pid")Integer pid);
}
