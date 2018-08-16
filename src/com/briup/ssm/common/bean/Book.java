package com.briup.ssm.common.bean;

import java.io.Serializable;
/**
 * 书  book
 * */
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//书id
	private Long id;
	//书的名字
	private String name;
	//书的价格
	private Double price;
	
	public Book(){
		
	}
	
	public Book(Long id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
