package com.briup.ssm.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.ssm.common.bean.Customer;

//@WebFilter(filterName="myFilter2",urlPatterns={"/*"})
public class LoginFilter  implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFilter()....................");
           HttpServletRequest request=(HttpServletRequest) arg0;
           HttpServletResponse response=(HttpServletResponse) arg1;
           HttpSession session = request.getSession();
           Customer customer=(Customer) session.getAttribute("loginCustomer");
           
           String url=request.getRequestURI();
           System.out.println(url);
           if(customer!=null || url.indexOf("customer/registercustomer")>=0 || url.indexOf("customer/checkUserName/{username}")>=0
	               || url.indexOf("register")>=0 ||url.indexOf("index.jsp")>=0
        		   || url.indexOf("customer/checklogin")>=0 || url.indexOf("customer/checkcode/{clientcode}")>0 || url.indexOf("customer/exit")>=0
        		   || url.indexOf("index")>=0 || url.contains("css/") || url.contains("images/") || url.contains("js/") || url.indexOf("01_image.jsp")>=0
        		   || url.indexOf("jquery-1.8.2.js")>=0 || url.indexOf("main.js")>=0 || url.indexOf("province_city_select_info.xml")>=0 || url.indexOf("ajax.js")>=0
        		   || url.indexOf("province_city.js")>=0
        		   ){
        	   chain.doFilter(request, response);
           }else{
        	   //未登录的跳转到登录界面
        	   session.setAttribute("commonmessage", "你未登录请先登录");
        	   request.getRequestDispatcher("/login").forward(request, response);
           }
           
        	   
		
		 
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

	
}
