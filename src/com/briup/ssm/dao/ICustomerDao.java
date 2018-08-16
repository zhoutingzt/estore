package com.briup.ssm.dao;


import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.exception.EstoreCommonException;

/*
 * 与数据库交互的顾客Dao层
 */
public interface ICustomerDao  {
	
	//通过顾客姓名查询顾客信息
	public Customer findByName(String name)throws EstoreCommonException;
	//保存顾客信息
	public void saveCustomer(Customer customer) throws EstoreCommonException;
	//更新顾客信息
	public void updateCustomer(Customer customer)throws EstoreCommonException;
	//根据顾客id查询顾客信息
	public Customer findBycustomerId(Long id)throws EstoreCommonException;
	//通过姓名的密码查询用户
	public Customer findByNameAndPassword(String name,String password) throws EstoreCommonException;
}
