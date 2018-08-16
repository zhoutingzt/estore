# estore

1.1.1ESTORE部分功能分析
1.1.1.1注册
 	在register.jsp页面注册一个新用户，用户名作为以后登陆唯一标识。当注册成功的话，跳转到login.jsp页面
详细描述：1．需要判断注册的用户名是否已经在数据库中存在。
		  2．最后将注册信息保存到Customer表

具体步骤：1. 实现CustomerDao接口中的saveCustomer()方法
		  2．实现ICustomerService接口中的业务逻辑register()方法
		  4．创建RegisterServlet.java，在该Servlet中调用ICustomerService接口中的register()方法进行注册。
      效果图如下：
      图1
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/register.png)
      图2
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/register2.png)
1.1.1.2登陆
在login.jsp页面上用户可以输入用户名和密码进行登陆，如果用户名和密码都正确，则登陆成功跳转到index.jsp。如果不正确，需要提示用户并且还是跳转到login.jsp页面继续登陆。
具体登陆过程：
1．查看登陆的用户名是否存在
2．查看密码是否正确
		
具体步骤：1. 实现CustomerDao接口中的findByName()方法
		  2．实现ICustomerService接口中的业务逻辑login()方法
		  4．创建LoginServlet.java，在该Servlet中调用ICustomerService接口中的login()方法进行登陆。
		  5. 从application中取出所有的Book在index.jsp中显示
      效果图如下：
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/login.png)
  登录成功效果图：
   效果图如下：
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/index.png)
    书的详细：
     效果图如下：
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/bookinfo.png)
1.1.1.3购物车
1．增加订单明细line
在index.jsp页面中点击添加到购物车按钮后往购物车(ShoppingCart.java)中增加一个line.（自己也可以添加一列，表示购买数量）

具体步骤： 1) 创建AddOrderlineServlet.java
		   2) 在该Servlet中,先从session中获取当前登陆用户对象和购物车对象，根据从index.jsp页面传入的bookid来构造一个line对象，然后用ShoppingCart对象，并且调用其中的add(Line orderline)方法往购物车中增加一个line对象。
			3) 增加Orderline成功后跳转到index.jsp页面
  效果图如下：
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/shopcart.png)
2．查看购物车
在index.jsp页面上点击查看购物车的按钮可以查看购物车中所有Line的信息。

具体步骤：1) 点击查看购物车按钮后链接到shopcar.jsp
		  2) 在shopcar.jsp页面中，从Session中取出ShoppingCart中的line对象并且在该页面上输出所有其中的line信息。
  效果图如下：
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/showshopchart.png)
3．删除line
在shopcar.jsp页面中点击取消按钮就可以从购物车中删除一个指定的Orderline。

具体步骤：1) 创建DelOrderlineServlet.java
		  2) 在Servlet中获得shopcar.jsp页面中传递过来的lineid(bookid)。
		  3) 从Session中获得ShoppingCart对象，并且调用它的dropLine(Long lineid)方法来删除一个指定的Orderline对象。
		  4) 删除成功后跳转到shopcar.jsp页面

4．修改line
在shopcar.jsp页面上修改图书数量并点击保存修改按钮后可以修改指定一个line的信息。

具体步骤：1) 创建EditOrderlineServlet.java
		  2) 在该Servlet中先从Session中获得ShoppingCart对象，然后获得从shopcar.jsp传递过来的lineid(bookid)和num，最后根据lineid来获得指定的Orderline对象，并且修改数量为num。
		  3) 修改成功后跳转到shopcar.jsp页面
 效果图如下：
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/modifyhopchart.png)
3．删除line
5．清空购物车
在shopcar.jsp页面中点击清空购物车后可以删除购物车中所有的line。

具体步骤：1) 创建ClearCartServlet.java
		  2) 在该Servlet中获得ShoppingCart对象，然后调用其中的clear()方法来清空购物车。
		  3) 清空购物车成功后跳转到index.jsp页面
 效果图如下：
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/ordernull.png)
1.1.1.4订单
1．查看用户所有订单
在(任何页面中都可以)index.jsp页面上点击查看订单按钮后可以查看当前登陆用户所有的订单信息。

具体步骤：在orderlist.jsp页面中从session中取出当前登陆用户的的所有order对象，使用foreach标签循环遍历，显示所有的order信息 
 效果图如下：
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/order.png)
2．提交订单
在shopCart.jsp页面上点击提交订单的按钮后链接到Orderinfo.jsp页面，然后在该页面上点击确认订单按钮后才正式提交订单，将订单信息分别保存到line表中。

具体步骤：1) 先链接到Orderinfo.jsp页面，在该页面上从session中分别取出Customer和ShoppingCart对象并将它们的信息显示在页面，在该页面还可以修改用户信息。
		  2) 实现OrderDao接口中的saveOrder()接口方法
		  3) 实现IOrderService接口中的业务接口方法saveOrder()
		  4) 实现ICustomerService接口中的业务接口方法update()
		  5) 创建ConfirmServlet.java
		  6) 在该Servlet中从session中获得Customer对象并更新属性信息，从session中获得ShoppingCart对象并将它包装成一个Order (订单)对象(注意要建立起Order对象和所有line对象之间的双向关联关系)，最后调用ICustomerService接口中的confirmOrder ()方法和IOrderService接口中的saveOrder()方法分别进行用户信息的更新和订单保存。
		  7) 提交订单成功后跳转到index.jsp，失败跳转到confirmorder.jsp页面上.
效果图如下：
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/orderform.png)
  
3．查询订单明细
在Orderlist.jsp页面上点击明细按钮可以查看一个订单的明细信息。

具体步骤：1) 实现OrderDao接口中的findById()接口方法
		  2) 实现IOrderService接口中的业务接口方法findById()方法
		  3) 创建OrderinfoServlet.java
		  4) 在该Servlet中获得从Orderlist.jsp传递过来的orderid，然后根据该orderid，调用IOrderService接口中的findById()方法查询指定的订单。
		  5) 查询成功后跳转到orderinfo.jsp，在该页面上显示该订单的所有明细信息。
效果图如下：
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/orderinfo.png)      
4.  删除订单
在listOrder.jsp页面上点击删除按钮可以删除指定的一个用户订单。

具体步骤：1) 实现OrderDao接口中的deleteOrder()方法
		  2) 实现IOrderService接口中的业务接口方法deleteOrder()
		  3) 创建DelOrderServlet.java
		  4) 在该Servlet中获得从Orderlist.jsp传递过来的orderid，然后根据该orderid，调用IOrderService接口中的deleteOrder()方法删除指定的订单。
		  5) 订单删除成功后跳转到Orderlist.jsp
      
5.查询
 效果图如下：
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/selectbyname.png)
 效果图如下：
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/select1.png)
 6.支付界面
  效果图如下：
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/pay.png)
  效果图如下：
      ![image](https://github.com/zhoutingzt/estore/blob/master/images/pay2.png)
