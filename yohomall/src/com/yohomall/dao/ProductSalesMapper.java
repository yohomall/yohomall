package com.yohomall.dao;

import org.apache.ibatis.annotations.Param;

import com.yohomall.pojo.Orderitem;




/**
 * 
 * @author HerryHx
 *   ��Ʒ���۵ķ����
 */
public interface ProductSalesMapper {
	/**
	 * 
	 * @param pid
	 * @return
	 */
	Orderitem findOneSales(@Param("pid")Integer pid);
}
