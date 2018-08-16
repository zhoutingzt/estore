package com.briup.ssm.common.bean;

import java.util.List;
/*
 * 分页的封装类（可以用 但是我项目最后用了PageHelper这个类 别人封装好的类）
 */
public class PageBean<T> {

	private  int currentPage=1; //当前页
	private int totalCount;   //总记录数
	private int pageCount=4;//每页显示的数目 设置每页显示4条数据
	private int totalPage; //总记录数
	private List<T> pageData; //分页查询到的数据
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalPage() {
		if(totalCount%pageCount==0){
			totalPage=totalCount/pageCount;
		}else{
			totalPage=totalCount/pageCount+1;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	
	
}

