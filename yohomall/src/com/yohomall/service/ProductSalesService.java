package com.yohomall.service;

import com.yohomall.pojo.Orderitem;


import com.yohomall.service.exception.NotMoreProductsException;

/**
 * 
 * @author HerryHx
 *   商品销量接口
 */
public interface ProductSalesService {
  /**
   * 
   * @param pid
   * @return 单件商品对象
   * @throws NotMoreProductsException
   */
    Orderitem oneSales(Integer pid)throws NotMoreProductsException;
    
 /**
  * 
  * @return INT 所有商品销量量
  * @throws NotMoreProductsException
  */
    int AllSales()throws NotMoreProductsException;
}
