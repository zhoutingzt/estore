package com.briup.ssm.web.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/pay")
public class PayServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ordercost=req.getParameter("ordercost");
		Double cost=Double.parseDouble(ordercost);
		HttpSession session = req.getSession();
		session.setAttribute("ordercost", cost);
		
		String WIDout_trade_no=req.getParameter("WIDTCout_trade_no1");
	     
		//SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
		//String WIDout_trade_no=sNow;
		Double WIDtotal_amount=cost;
		String WIDsubject="支付";
		String WIDbody="卖书";
		req.setAttribute("WIDout_trade_no", WIDout_trade_no);
		req.setAttribute("WIDtotal_amount", WIDtotal_amount);
		req.setAttribute("WIDsubject", WIDsubject);
		req.setAttribute("WIDbody", WIDbody);
		
		
		//req.getRequestDispatcher("alipay.trade.page.pay.jsp").forward(req, resp);
		
		resp.sendRedirect("index.jsp");//alipay.trade.page.pay.jsp
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
