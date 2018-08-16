package com.briup.ssm.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.Order;
import com.briup.ssm.common.bean.ShoppingCar;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.service.interfaces.ICustomerService;
import com.briup.ssm.service.interfaces.ILineService;
import com.briup.ssm.service.interfaces.IOrderService;

/*
 * 订单管理
 */
@Controller
@RequestMapping("/orderController")
public class OrderController {
	
	//注入顾客层对象
	@Autowired
	ICustomerService customerService;
	
	//注入订单项service层对象
	@Autowired
	ILineService lineService;
	
	//注入订单sevice层对象
	@Autowired
	IOrderService orderService;
	
	/**
     * 通过页面提交order.jsp来保存用户 、订单信息
     * 
     * @param customer 用来接收顾客信息
     * @param session 用来获取购物车信息
     * @param order 用来接收订单信息
     * @return 返回视图名
     */
	@RequestMapping("/saveOrder")
	public String saveOrder(Customer customer,Order order,HttpSession session){
		
		//System.out.println("支付方式为："+order.getPayway());
		//System.out.println(order.getCost());
		/*if(order.getCost()== null){
			session.setAttribute("message", "你好 你未有订单");
			return "redirect:/error";
		}*/
		//从session中获取购物车对象
		ShoppingCar cart=(ShoppingCar) session.getAttribute("shopcart");
		//从购物车中取出订单项
		Map<Long, Line> lines = cart.getLines();
		Set<Line> lineset=new HashSet<Line>();
		for(Entry<Long, Line> line:lines.entrySet()){
			lineset.add(line.getValue());
		}
		
		
		order.setCustomer(customer);
		order.setCost(cart.getCost());///可以去掉
		order.setOrderDate(new Date());
		order.setLines(lineset);
		//order.setPayway(payway);
		
		//顺带把订单信息也保存
		Set<Order> orderinCustomer=new HashSet<Order>();
		orderinCustomer.add(order);
		customer.setOrders(orderinCustomer);
		
		
		try {
			//同时保存顾客 订单 订单详细消息
			orderService.confirmOrder(customer, order, lineset);
			Customer findCustomer = customerService.findCustomerById(customer.getId()); //long类型
			//System.out.println("w2q52q45");
			Set<Order> orderset = findCustomer.getOrders();
			System.out.println(orderset.size());
			Map<Long, Order> orders=new HashMap<Long, Order>();
			
			for(Order o:orderset){
				
				//System.out.println("id的大小："+o.getId());
				//o.setPayway(payway);
				orders.put(o.getId(),o);
				//System.out.println("支付方式："+o.getPayway());
				//session.setAttribute("orderCost"+i, o.getCost());
				
			}
			
			session.setAttribute("orders", orders);
			
			//提交完订单后删除购物车的订单项
			session.removeAttribute("map");
			session.removeAttribute("shopcart");
			//session.setAttribute("everyordercost", );
			return "redirect:/order";
		} catch (EstoreCommonException e) {
			
			session.setAttribute("message","保存订单信息失败"+e.getMessage());
			return "redirect:/error";
		}
		
	}
	
	/**
     * 通过页面点击 删除订单
     * 
     * @param orderid 接收页面传来的订单号 
     * @param session 用来获取orders信息
     * @return 返回视图名
     */
		@RequestMapping("/deleteOrder")
		public String deleteOrder(int orderid,HttpSession session){
			//在Confirm订单的时候就把orders给存入session
			System.out.println(orderid);
			
			Map<Long,Order> orders = (Map<Long, Order>)session.getAttribute("orders");
			System.out.println(orders.size());
			orders.remove((long)orderid);
			try {
				System.out.println("deleteOrderfadsffffffffffff");
				//删了含外键的表中的数据
				lineService.delLine((long)orderid);
				orderService.deleteOrder((long)orderid);
				System.out.println("成功删除订单");
				System.out.println(orders.size());
				//return "order";
			} catch (EstoreCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "order";
		}
	
		/**
	     * 展示订单明细
	     * 
	     * @param orderid 接收页面传来的订单号 
	     * @param session 用来获取保存信息
	     * @return 返回视图名
	     */
		@RequestMapping("/showorderinfo")
		public String testbyOrder(int orderid,HttpSession session){
			System.out.println("======================================");
			Customer customer=(Customer) session.getAttribute("loginCustomer");
			
			try {//查询到了订单明细
				Order order = orderService.findOrderById((long)orderid);
				//System.out.println("订单"+order);//在order类中不能写toString方法
				Set<Line> lineset = order.getLines();
					for(Line line1:lineset){
						System.out.println("书名1："+line1.getBook().getName());
						System.out.println("数量1："+line1.getNum());
						System.out.println("价格1："+line1.getBook().getPrice());
					}
				
				System.out.println("集合的大小："+lineset.size());
				Set<Order> orders=new HashSet<>();
				orders.add(order);
				customer.setOrders(orders);
				System.out.println("支付方法为："+order.getPayway());
				for(Order o:orders){
					System.out.println("订单花费："+o.getCost());
					Set<Line> lines = o.getLines();
					System.out.println("订单项的大小："+lines.size());
					session.setAttribute("lines", lines);
					System.out.println("支付方法为："+o.getPayway());
					int sum=0;
					for(Line line:lines){
						System.out.println("书名："+line.getBook().getName());
						System.out.println("数量："+line.getNum());
						System.out.println("价格："+line.getBook().getPrice());
						sum=(int) (sum+(line.getBook().getPrice()*line.getNum()));
					}
					session.setAttribute("sum",sum);
					
				}
				
				//含有订单信息的customer
				session.setAttribute("customer", customer);
				
				
				return "orderinfo";
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
				return "error";
			}
			
			
		}
		
    /*
     * 订单支付页面
     */
    @RequestMapping("/pay")
	public String pay(Double ordercost,HttpSession session,String orderDate){
    	session.setAttribute("orderDate", orderDate);
		session.setAttribute("ordercost", ordercost);
		return "redirect:/index";
	}
		
}
