package com.briup.ssm.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.service.interfaces.IBookService;
import com.github.pagehelper.PageInfo;


@Controller
public class IndexController {

	@Autowired
	private IBookService bookService;
	
	@RequestMapping(value={"/","index"})
	public String index(HttpSession session,@RequestParam(value="page",required=false,defaultValue="1") int page){
		try {
			PageInfo<Book> pageInfo = bookService.findBookByPage(page, 4);
			session.setAttribute("pageInfo", pageInfo);
			
		} catch (EstoreCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute("message","查询失败"+e.getMessage());
			
		}	
		return "index";
	}
	
	//模糊查询
	@RequestMapping("/selectBook")
	public String selectBook(String name,String author,String lowprice,String lower ,String  highprice,String selectprice,HttpSession session){
		System.out.println(name+"=="+author+"=="+lowprice+"=="+highprice);
		
		Map<String, Object> map=new HashMap<String, Object>();
        if(!"".equals(name)){
        	map.put("name", name);//"%Java%"
		}
		if(!"".equals(author)){
			map.put("author",author);
		}
		
		map.put("name", name);
		if((!"".equals(lowprice))){
			
			double low=Double.parseDouble(lowprice);
			if(low<0){
				low=0;
			}
			map.put("lowprice", low);
		}
		//如果最低价没有填的话 就默认是0
		map.put("lowprice", 0);
		if(!"".equals(highprice)){
			double high=Double.parseDouble(highprice);
			if(high<0){
				high=0;
			}
			map.put("highprice",high);
		}
		
		try {
			List<Book> booklist = bookService.findBook_bytiaojian(map);
			for(Book book:booklist){
				System.out.println(book.getId()+":"+book.getName()+":"+book.getPrice());
			}
			System.out.println(booklist.size());
			session.setAttribute("bookbytiaojian", booklist);
		} catch (EstoreCommonException e) {
			session.setAttribute("bookmessage", "查询有误"+e.getMessage());
			return "error";
		}
		return "index";
	}
}
