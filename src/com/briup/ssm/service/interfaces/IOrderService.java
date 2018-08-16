package com.briup.ssm.service.interfaces;

import java.util.Collection;
import java.util.Set;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.Order;
import com.briup.ssm.common.exception.EstoreCommonException;

/*
 * 管理订单的service
 */
public interface IOrderService {
	
	//订单验证
	void confirmOrder(Customer customer,Order order,Collection<Line> lines) throws EstoreCommonException;
	//删除订单
	void deleteOrder(Long id) throws EstoreCommonException;
	//Order queryOrderById(Long id) ;//老师定义的方法
	//Set<Order> findById(Long id) throws OrderException;
	//void saveOrder(Order order) throws OrderException;
	//Order findById2(Long id) throws EstoreCommonException;
	
	//通过订单号查询订单
	Order findOrderById(Long id) throws EstoreCommonException;
}
