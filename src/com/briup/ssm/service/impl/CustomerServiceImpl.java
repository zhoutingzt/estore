package com.briup.ssm.service.impl;

import com.briup.ssm.common.util.MD5;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.dao.ICustomerDao;
import com.briup.ssm.service.interfaces.ICustomerService;

/*
 * 管理顾客信息
 */
@Service
public class CustomerServiceImpl implements ICustomerService{
	
	//注入CustomerDao(与数据库交互的对象)
	@Autowired
	ICustomerDao customerDao;
	
	/**
     * 顾客注册
     * 
     * @param customer 待保存的顾客
     * 
     */
	@Override
	public void register(Customer customer) throws EstoreCommonException {
		   if(customer==null){
			   throw EstoreCommonException.getException(404);
		   }
	        String password = customer.getPassword();
		    customer.setPassword(MD5.getMD5Str(password));
	        customerDao.saveCustomer(customer);
			//加密
	}

	/*
	 * 核对用户登录时，查找数据库有没有该用户 
	 * 
	 * @param1 名字
	 * @param2 密码
	 * @return customer
	 */
	@Override
	public Customer login(String name, String password)
			throws EstoreCommonException {
		Customer customer = customerDao.findByNameAndPassword(name, password);
		//加了这句话的话 就不再页面中提示用户登录时用户或密码错误/////////////
		if(customer==null){  
			throw EstoreCommonException.getException(402);
		}
		return customer;
	}

	
	/*
	 * 更新顾客信息
	 * 
	 * @param1  用户
	 * @return 
	 */
	@Override
	public void updateCustomer(Customer customer) throws EstoreCommonException {
		//对密码加密后再与数据库中密码匹配
		String passord = MD5.getMD5Str(customer.getPassword());
		//System.out.println(passord);
		Customer customer2 = customerDao.findByNameAndPassword(customer.getName(),passord);
		if(customer2==null){
			throw EstoreCommonException.getException(404);
		}
		customer.setPassword(MD5.getMD5Str(passord));
		customerDao.updateCustomer(customer);
		
	}

	/*
	 * 根据顾客id查询
	 * 
	 * @param1 id 顾客编号
	 * @return 顾客信息
	 */
	@Override
	public Customer findCustomerById(Long id) throws EstoreCommonException {
		
		Customer customer = customerDao.findBycustomerId(id);
		if(customer==null){
			throw EstoreCommonException.getException(404);
		}
		
		return customer;
	}

	/*
	 * 根据顾客名字查询
	 * 
	 * @param1 name 顾客姓名
	 * @return 顾客信息
	 */
	@Override
	public Customer findCustomerByName(String name) throws EstoreCommonException {
		Customer customer = customerDao.findByName(name);
		if(StringUtils.isBlank(name)){///这里写的是什么
			// throw  xxx.getException(401);
			throw EstoreCommonException.getException(401);
		}
		
		return customer;
	}

	
	
}
