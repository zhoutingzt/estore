package com.briup.ssm.dao;


import java.util.Set;

import com.briup.ssm.common.bean.Order;


/*
 * 订单管理
 */
public interface IOrderDao  {
	
    //保存订单
	public void saveOrder(Order order);
	//删除订单
	public void deleteOrder(Order order);
	//根据订单号来查询订单
	public Order selOrderById(Long id);//老师定义的方法
	//根据订单号来查询订单
	public Order selectOrderById(Long id);//仅仅查找orderform表
	
}
