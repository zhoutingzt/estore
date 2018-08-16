package com.briup.ssm.web.controller;

import java.io.PrintWriter;



import com.briup.ssm.common.util.MD5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;




import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.PageBean;
import com.briup.ssm.common.bean.ShoppingCar;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.common.util.ResponseResult;
import com.briup.ssm.service.impl.BookServiceImpl;
import com.briup.ssm.service.impl.CustomerServiceImpl;



/**
 * 顾客注册管理
 */
@RequestMapping("/customer")
@Controller
public class CustomerController {

	//获取customerService对象
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	
	//获取book的业务处理层对象
	@Autowired
	BookServiceImpl bookServiceImpl;
	
	
	
	/**
     * 将用户存入数据库
     * 
     * @param Customer 存放用户信息
     * @return 返回逻辑视图名
     */
	@RequestMapping("/registercustomer")
	public String registerCustomer(Customer customer,HttpSession session) {
		try {
			customerServiceImpl.register(customer);
			session.setAttribute("msg", "注册成功，请登录");
			return "redirect:/login";//重定向到@RequestMapping("/login")
		} catch (EstoreCommonException e) {
			session.setAttribute("msg", "注册失败:"+e.getMessage());
			return "redirect:/register";
		}
		
	}
	
	
	
	/**
     * 通过名字检查数据库中是否存在 如果存在提示不能注册 不存在能注册
     * 
     * @param username 获取用户姓名
     * @return 返回json格式的对象（即ResponseResult对象）
     */
	@ResponseBody
    @RequestMapping("/checkUserName/{username}") //获取模板中的值
	public Object checkName(@PathVariable String username,HttpSession session){
    	try {
    		
			Customer findCustomer = customerServiceImpl.findCustomerByName(username);
			System.out.println(findCustomer);
			if(findCustomer==null){
				//return "{\"msg\":\"可以注册\"}";
				System.out.println(ResponseResult.ok().getStatus());
				return ResponseResult.ok();
				
				/*return "{\"msg\":\"Y\"}";*/
				
			}
			//return "{\"msg\":\"N\"}";
			System.out.println(ResponseResult.build(500,"fail"));
			return ResponseResult.build(500,"fail");
		} catch (EstoreCommonException e) {
			
			session.setAttribute("message", "核对信息出错："+e.getMessage());
			return ResponseResult.build(500,"fail");
			/*return "{\"msg\":\"N\"}";*/
		}
		
	}
	
	

	/**
     * 通过名字，密码检查用户中是否存在当前登录用户 存在则跳转首页 不存在跳登录页面
     * 
     * @param username 获取用户姓名
     * @param password 获取用户密码
     * @param session session用于保存登录信息 提示用户登录成功与否
     * @return 返回逻辑视图
     */
	@RequestMapping("/checklogin")
	public String checkCustomerLogin(String name,String password,HttpSession session){
		try {
			//对输入的密码加密后再去查 rose 123123
			String password1=MD5.getMD5Str(password);
			Customer customerlogin = customerServiceImpl.login(name, password1);
			//System.out.println("查询用户afa");
			if(customerlogin==null){
				session.setAttribute("msg1", "用户名或密码不正确");
				//System.out.println("用户名或密码不正确");
				return "redirect:/login";
			}
			
			
			//把用户信息放入session在首页中展示
			session.setAttribute("loginUserName",name);
			//便于用户信息的修改
			session.setAttribute("loginCustomer", customerlogin);
			
			//return "redirect:/customer/showbook";
			return "redirect:/index";
		} catch (EstoreCommonException e) {
			session.setAttribute("message", "信息有误"+e.getMessage());
			return "redirect:/login";
		}
		
	}
	
	@RequestMapping("/checkcode/{clientcode}")
	@ResponseBody
	public Object checkCode(@PathVariable String clientcode,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		System.out.println("/验证码："+clientcode);
		//String clientcode=req.getParameter("checkcode");
	    //从Session中获取验证码
		String checkonserver=(String) req.getSession().getAttribute("CHECKNUM");
		System.out.println(checkonserver);
		if(checkonserver!=null && clientcode!=null && clientcode.equals(checkonserver)){
			System.out.println("35435");
			System.out.println(ResponseResult.ok().getStatus());
			return ResponseResult.ok();
		}
		System.out.println(ResponseResult.build(500,"fail"));
		return ResponseResult.build(500,"fail");
	}
	
	/**
     * 分页展示书本信息
     * 
     * @param req 用于获取请求中的当前页
     * @return 返回的String 即返回的是逻辑视图名
     */
	/*@RequestMapping("/showbook")
	public String showBookIndex(HttpServletRequest req){
		String currPage = req.getParameter("currentPage");
		if(currPage==null||"".equals(currPage.trim())){
			currPage="1";
		}
		//设置当前页
		PageBean<Book> pageBean=new PageBean<Book>();
		pageBean.setCurrentPage(Integer.parseInt(currPage));
		try {
			bookServiceImpl.getBookByPage(pageBean);
			HttpSession session = req.getSession();
			session.setAttribute("pageBean", pageBean);
			return "redirect:/customer/index";
		} catch (EstoreCommonException e) {
			return "error";
		}

	}*/
	
	
	@RequestMapping("/modifyCustomer")
	public String modifyCustomer(HttpServletRequest req/*,Customer customer*/){
		HttpSession session = req.getSession();
		String name=req.getParameter("userid");//userid
		String password=req.getParameter("password");
		String city=req.getParameter("city");
		String address=req.getParameter("street1");
		String zip=req.getParameter("zip");
		String homephone=req.getParameter("homephone");
		String email=req.getParameter("email");
		Customer customer=new Customer();
		
		customer.setName(name);
		customer.setPassword(password);
		customer.setZip(zip);
		customer.setAddress(address);
		customer.setTelephone(homephone);
		customer.setEmail(email);
		
		try {
			customerServiceImpl.updateCustomer(customer);
			return "redirect:/index";
		} catch (EstoreCommonException e) {
			session.setAttribute("message", "用户信息修改有误"+e.getMessage());
			return "userinfo";
		}
		
	}
	
	@RequestMapping("/exit")
	public String exitLogin(HttpSession session){
		session.removeAttribute("loginCustomer");
		return "redirect:/login";
	}
	
	
}
