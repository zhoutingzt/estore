package com.briup.ssm.web.controller;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;








import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.ShoppingCar;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.service.impl.BookServiceImpl;

@Controller 
@RequestMapping("/shopCartController")
public class ShopCartController {
	
	@Autowired
	BookServiceImpl bookServiceImpl;
	
	@RequestMapping("/shopcart")
	public String shopcart(HttpSession session){
		Customer name=(Customer) session.getAttribute("loginCustomer");
		if(name==null){
			return "redirect:/login";
		}
		return "shopcart";
	}
	
	/**
     * 将产品添加到添加购物车
     * 
     * @param productid 获取请求中的产品id
     * @param session  用于存放购物车
     * @return 返回逻辑视图名
     */
	@RequestMapping("/addline")
	public String addLine(int productid,HttpSession session){
		int count = 0;
		ShoppingCar cart = (ShoppingCar) session.getAttribute("shopcart");
		if(cart==null){
			cart=new ShoppingCar();
		}
		session.setMaxInactiveInterval(24*60*60);
	    Customer user = (Customer) session.getAttribute("loginCustomer");
		try {
			Book book = bookServiceImpl.findById((long)productid);
			Line line = new Line();
			line.setBook(book);
			cart.add(line);
			session.setAttribute("shopcart",cart);
			session.setAttribute("totallineCost",cart.getCost());
			count=count+1;
			session.setAttribute("count",count);
		    ShoppingCar shopcart1 = (ShoppingCar) session.getAttribute("shopcart");
		    Map<Long, Line> map = shopcart1.getLines();
		    for (Entry<Long,Line> m : map.entrySet()) {
				System.out.println(m);
				m.getValue().getNum();
			}
		    System.out.println("map的大小："+map.size());
		   session.setAttribute("map",map);
		   return "redirect:/shopCartController/shopcart";
		} catch (EstoreCommonException e) {
			
			e.printStackTrace();
			return "error";
		}	
	}
	
	
	/**
     * 清空购物车
     * 
     * @param session  用于之前存放的购物车
     * @return 返回逻辑视图名
     */
	@RequestMapping("/clearShopCart")
	public String clearShopCart(HttpSession session){
		ShoppingCar shoppingCar=(ShoppingCar) session.getAttribute("shopcart");
		shoppingCar.clear();
		return "redirect:/shopCartController/shopcart";
	}
	
	
	/**
     * 修改购物车产品的数量
     * 
     * @param productid 获取请求中的产品id
     * @param session  用于存获取放购物车
     * @param num  用于接收请求里面修改的值
     * @return 返回逻辑视图名
     */
	@RequestMapping("/eidtOrderLine")
	public String editLineNum(int productid,int num,HttpSession session){
		if(num<=0){
			num=0;
		}
		ShoppingCar cart=(ShoppingCar) session.getAttribute("shopcart");
		Long bookId=(long)productid;
		//int num = Integer.parseInt(request.getParameter("num"));
		
		 Map<Long, Line> lines = cart.getLines();
		  System.out.println("更新成功1");
		    for(Entry<Long, Line> m:lines.entrySet()){
	    	   if(bookId.equals(m.getValue().getBook().getId())){
	    		   m.getValue().setNum(num);
	    		   System.out.println("更新成功2");
	    	   }
		    }
		return "redirect:/shopCartController/shopcart";
	}
	
	/**
     * 删除特定的订单项
     * 
     * @param productid 获取请求中的产品id
     * @param session  用于存获取放购物车
     * @return 返回逻辑视图名
     */
	@RequestMapping("/deleteOrderLine")
	public String deleteOrderLine(int productid,HttpSession session){
		ShoppingCar cart=(ShoppingCar) session.getAttribute("shopcart");
		cart.delete((long)productid);
		return "redirect:/shopCartController/shopcart";
	}
}
