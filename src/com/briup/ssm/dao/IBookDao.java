package com.briup.ssm.dao;

import java.util.List;
import java.util.Map;

import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.github.pagehelper.PageInfo;

/*
 * 与数据库交互的Book Dao层
 */
public interface IBookDao {
	
	//利用jar包的分页查询的方法
	public List<Book> queryAll();
	//根据书本id查询书
	public Book queryBookById(Long id);
	
	//分页查询
	public List<Book> queryBookIntoPage(int endpage,int startpage)throws EstoreCommonException;
	//获取总记录数
	int getTotalCount() throws EstoreCommonException;
	
	//条件查询
	List<Book> findBook_bywhere(Map<String, Object> map);
}
