package com.briup.ssm.service.interfaces;

import com.briup.ssm.common.bean.Customer;

import com.briup.ssm.common.exception.EstoreCommonException;

/*
 * 处理顾客业务
 */
public interface ICustomerService {
	
	//顾客注册
	void register(Customer customer) throws EstoreCommonException;
	//验证顾客登录
	Customer login(String name,String password) throws EstoreCommonException;
	//更新顾客信息
	void updateCustomer(Customer customer) throws EstoreCommonException;
	//通过顾客id查询顾客信息
	Customer findCustomerById(Long id) throws EstoreCommonException;//自己添加的方法
	//通过顾客姓名查找顾客
	Customer findCustomerByName(String name) throws EstoreCommonException;
}
