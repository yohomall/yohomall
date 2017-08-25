package com.yohomall.service;

import com.yohomall.pojo.Orderitem;


import com.yohomall.service.exception.NotMoreProductsException;

/**
 * 
 * @author HerryHx
 *   ��Ʒ�����ӿ�
 */
public interface ProductSalesService {
  /**
   * 
   * @param pid
   * @return ������Ʒ����
   * @throws NotMoreProductsException
   */
    Orderitem oneSales(Integer pid)throws NotMoreProductsException;
    
 /**
  * 
  * @return INT ������Ʒ������
  * @throws NotMoreProductsException
  */
    int AllSales()throws NotMoreProductsException;
}
