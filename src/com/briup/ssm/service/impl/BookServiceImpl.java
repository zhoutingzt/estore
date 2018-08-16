package com.briup.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.bean.PageBean;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.dao.IBookDao;
import com.briup.ssm.service.interfaces.IBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/*
 * 管理书籍
 */
@Service
public class BookServiceImpl implements IBookService{

	//注入book的dao层对象
	@Autowired
	IBookDao bookDao;
	
	/**
     * 获取书本的总数 （自己定义的实现分页查询总记录数 ）
     *
     * @return 返回书本的总记录数
     */
	@Override
	public int getTotalCount() throws EstoreCommonException {
		int totalCount=0;
		totalCount = bookDao.getTotalCount();
		//System.out.println("总记录数为："+totalCount);
		return totalCount;
	}

	/**
     * 通过对PageBean设置相对应的属性 之后方便获取当前页 总页数 书本信息等
     * 
     * @param pb 用来设置分页对象其他属性
     */
	@Override
	public void getBookByPage(PageBean<Book> pb) throws EstoreCommonException {
		//2.查询总记录数 设置到pb中
		int totalCount=this.getTotalCount();
		pb.setTotalCount(totalCount);
		//如果当前页大<0的话 就把当前页设置为1
		if(pb.getCurrentPage()<=0){
			pb.setCurrentPage(1);
		}
		//如果当前页大于最大页数的话 就把它设置为最大页数
		if(pb.getCurrentPage()>pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		//获取当前页 计算起始行
		int currentPage=pb.getCurrentPage();
		int pageCount=pb.getPageCount();
		int startPage=(currentPage-1)*pageCount;
		int endPage=pageCount*currentPage;
		//输入结束行和起始行
	    List<Book> booklist = bookDao.queryBookIntoPage(endPage,startPage);
		pb.setPageData(booklist);
		
		
	}

	/**
     * 通过id来查询书本信息
     * 
     * @param pb 用来设置分页对象其他属性
     * @return 返回书本对象
     */
	@Override
	public Book findById(Long id) throws EstoreCommonException {
		Book book = bookDao.queryBookById(id);
		if(book==null){
			throw EstoreCommonException.getException(404);
		}
		return book;
	}

	/**
     * 通过当前页，每页条数 来对数据库进行分页查询
     * 
     * @param page 当前页
     * @param page 每页的条数
     * @return 返回查询到的书本信息
     */
	@Override
	public PageInfo<Book> findBookByPage(int page, int row)
			throws EstoreCommonException {
		PageHelper.startPage(page, row);//查询条数
		List<Book> books = bookDao.queryAll();
		return new PageInfo<>(books);
	}

	@Override
	public List<Book> findBook_bytiaojian(Map<String, Object> map) throws EstoreCommonException {
       if(map.size()==0){
    	   throw EstoreCommonException.getException(404);
       }
		
		List<Book> findBook_bywhere = bookDao.findBook_bywhere(map);
        if(findBook_bywhere.size()==0){
        	throw EstoreCommonException.getException(404);
        }
        
		return findBook_bywhere;
	}

	

	
}
