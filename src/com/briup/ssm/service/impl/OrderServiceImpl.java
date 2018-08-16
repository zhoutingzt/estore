package com.briup.ssm.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.Order;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.dao.ICustomerDao;
import com.briup.ssm.dao.ILineDao;
import com.briup.ssm.dao.IOrderDao;
import com.briup.ssm.service.interfaces.IOrderService;

/**
 * 管理订单的业务实现
 */
@Service
public class OrderServiceImpl implements IOrderService{

    //注入订单的dao层对象
	@Autowired
	IOrderDao orderDao;
	
	//注入订单详细的dao层对象
	@Autowired
	ILineDao lineDao;
	
	//注入顾客的dao层对象
	@Autowired
	ICustomerDao customerDao;
	
	/*
	 * 验证信息 同时保存顾客 订单 订单详细信息
	 * 
	 * @param1   customer 顾客对象
	 * @param2  order 订单对象
	 * @return   lines 订单详细集合
	 */
	@Override
	public void confirmOrder(Customer customer, Order order,
			Collection<Line> lines) throws EstoreCommonException {
		if(customer==null || order==null || lines==null){
			throw EstoreCommonException.getException(404);
		}
		customerDao.updateCustomer(customer);
		order.setCustomer(customer);
		orderDao.saveOrder(order);
		for(Line line:lines){
			line.setOrder(order);
			lineDao.saveLine(line);
		}
		
	}

	/*
	 * 根据订单号删除订单
	 * 
	 * @param1  id  订单id
	 */
	@Override
	public void deleteOrder(Long id) throws EstoreCommonException {
		Order order = orderDao.selectOrderById(id);
		if(order == null){
			throw EstoreCommonException.getException(404);
		}
		orderDao.deleteOrder(order);
		
	}

	/*
	 * 根据订单号查询订单
	 * 
	 * @param1   id 订单号
	 * @return   order 订单
	 */
/*	@Override
	public Order queryOrderById(Long id) {
		Order order = orderDao.selOrderById(id);
		System.out.println("service层："+order);
		return order;
	}*/

	/*
	 * 根据订单号查询订单
	 * 
	 * @param1   id 订单号
	 * @return   order 订单
	 */
	@Override
	public Order findOrderById(Long id) throws EstoreCommonException {
		Order selOrderById = orderDao.selOrderById(id);
		if(selOrderById == null){
			throw EstoreCommonException.getException(404);
		}
		return selOrderById;
	}

	
}
