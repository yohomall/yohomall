package com.yohomall.pojo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<Integer, CartItem> itemMap=new HashMap<>();
	
	public  Collection<CartItem> getCartItems(){
		return itemMap.values();
	}
	
	private Double total=0.0;

	public Map<Integer, CartItem> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<Integer, CartItem> itemMap) {
		this.itemMap = itemMap;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	/**
	 * ���뵽���ﳵ
	 * @param cartItem
	 */
	public void add2cart(CartItem cartItem) {
		//��ȡ��Ʒid
		Integer pid = cartItem.getProduct().getPid();
		//�жϹ��ﳵ�Ƿ��й�����
		if (itemMap.containsKey(pid)) {
			//�� �޸�����  = ԭ������+�¼ӵ�����
			//ԭ�еĹ�����
			CartItem ocartItem=itemMap.get(pid);
			
			ocartItem.setCount(ocartItem.getCount()+cartItem.getCount());
			
		} else {
			//��
			itemMap.put(pid, cartItem);
		}
		
		//�޸��ܽ��
		total+=cartItem.getSubtotal();
	}
	/**
	 * �ӹ��ﳵ�Ƴ�һ��������
	 * @param pid
	 */
	public void removeCarItem(Integer pid) {
		//�ӹ��ﳵ(map)���Ƴ�������
		CartItem item = itemMap.remove(pid);
		//�޸��ܽ��
		total-=item.getSubtotal();
	}
	/**
	 * ��չ��ﳵ
	 */
	public void clearCart() {
		//���map
		itemMap.clear();
		//�޸��ܽ�� 0.0
		total=0.0;
	}
	
}
