package com.briup.ssm.service.interfaces;

import java.util.List;



import java.util.Map;

import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.bean.PageBean;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.github.pagehelper.PageInfo;


/*
 * 管理书本
 */
public interface IBookService {

    //通过书本号查询书本信息
	Book findById(Long id) throws EstoreCommonException;
	//自己添加的分页方法
     void getBookByPage(PageBean<Book> pb) throws EstoreCommonException;
     //获取书本的条数
     int getTotalCount()throws EstoreCommonException;
     
     //当前页 一个展示的页数 利用jar
     PageInfo<Book> findBookByPage(int page,int row) throws EstoreCommonException;
     
     //条件查询
     public List<Book> findBook_bytiaojian(Map<String, Object> map) throws EstoreCommonException;
}
