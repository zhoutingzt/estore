package com.briup.ssm.web.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.ssm.common.bean.Customer;

//页面展示 也可以在springmvc.xml中配置
@Controller
public class ShowViewController {

	//confirmOrder.jsp
	@RequestMapping("/confirmOrder")
	public String confirmorder(HttpSession session){
	    Customer name=(Customer) session.getAttribute("loginCustomer");
		if(name==null){
			session.setAttribute("commonmessage", "请先登录");
			return "redirect:/login";
		}
		return "confirmOrder";
	}
	//oroder.jsp
	@RequestMapping("/order")
	public String order(HttpSession session){
		//写了过滤器就不需要写了
		Customer name=(Customer) session.getAttribute("loginCustomer");
		if(name==null){
			session.setAttribute("commonmessage", "请先登录");
			return "redirect:/login"; //如果再重定向到order页面会陷入死循环
		}
		return "order";
	}
	
	@RequestMapping("/orderinfo")
	public String orderinfo(HttpSession session){
		Customer name=(Customer) session.getAttribute("loginCustomer");
		if(name==null){
			session.setAttribute("commonmessage", "请先登录");
			return "redirect:/login";
		}
		return "orderinfo";
	}
	
	@RequestMapping("/productDetail.action")
	public String productDetail(HttpSession session){
		Customer name=(Customer) session.getAttribute("loginCustomer");
		if(name==null)
		{
			session.setAttribute("commonmessage", "请先登录");
			return "redirect:/login";
		}
		return "productDetail";
	}
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/register")
	public String register(HttpSession session){
		return "register";
	}
	@RequestMapping("/userinfo")
	public String userinfo(HttpSession session){
		Customer name=(Customer) session.getAttribute("loginCustomer");
		if(name==null){
			session.setAttribute("commonmessage", "请先登录");
			return "redirect:/login";
		}
		return "userinfo";
	}
	@RequestMapping("/error")
	public String error(){
		return "error";
	}
	

}
