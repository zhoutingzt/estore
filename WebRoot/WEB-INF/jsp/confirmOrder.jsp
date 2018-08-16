<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href="<%=basePath%>">
    
    <title>My JSP 'confirmOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<LINK href="css/main.css" rel=stylesheet>
	<script language = "JavaScript" src = "js/main.js"></script>

  </head>
<!--   <script type="text/javascript">
  $(function(){
    //获取id
    $("#submitorder").click(function(){
       
        var value=$("#num").val();
        if(value==""){//这里还有点问题如果是 空的话 还是
           $("#messageId").html("<font color='red'>你未有订单</font>");
           $("#submitorder").attr("disabled",false);
        }
    });
  })
</script> -->
 <body onLoad="MM_preloadImages('images/index_on.gif','images/reg_on.gif','../images/order_on.gif','../images/top/topxmas/jp_on.gif','../images/top/topxmas/download_on.gif','../images/top/topxmas/bbs_on.gif','../images/top/topxmas/designwz_on.gif')" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="table2">
		  <tr>
		    <td align="left" width="7%" background="../images/top_bg.gif"><img src="images/logo.gif" width="165" height="60"></td>
		    <td width="62%" background="images/top_bg.gif">　</td>
		    <td width="31%" background="../images/top_bg.gif" align="right">
			<img src="images/top_r.gif" width="352" height="58" border="0"></td>
		  </tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td background="images/dh_bg.gif" align="left" height="12">
		      <table width="100" border="0" cellspacing="0" cellpadding="0" align="center">
		        <tr>
		          <td width="5%">　</td>
		          <td width="10%"><a href="index" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image1','','../images/index_on.gif',1)">
					<img name="Image1" border="0" src="images/index.gif" width="90" height="36"></a></td>
		          <td width="10%"><a href="userinfo" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image2','','../images/reg_on.gif',1)">
					<img name="Image2" border="0" src="images/reg.gif" width="92" height="36"></a></td>
		          <td width="10%"><a href="shopCartController/shopcart" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image4','','../images/carts_on.gif',1)">
					<img name="Image4" border="0" src="images/cart.gif" width="92" height="36"></a></td>
		          <td width="10%"><a href="order" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image5','','../images/order_on.gif',1)">
					<img name="Image5" border="0" src="images/order.gif" width="92" height="36"></a></td>
		          <td width="10%"><a href="index" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image6','','../images/exit_on.gif',1)">
					<img name="Image6" border="0" src="images/exit.gif" width="92" height="36"></a></td>
		        </tr>
		      </table>
		    </td>
		  </tr>
		</table>
		<table cellspacing="1" cellpadding="3" align="center" border="0" width="98%">
		<tr>
		<td width="65%"><BR>
		>> 欢迎访问 <b>杰普电子商务门户</b> </td>
		<td width="35%" align="right">

		</td></tr></table>



<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					确认定单
                </td>
                </tr>
		</table>
              <br>

		<form name="order" method="post" action="orderController/saveOrder"/>
		<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="images/bg2.gif">
			<font color="#ffffff"><b>用户信息</b></font><input type="button" value="修改" onclick="javascript:window.location='userinfo';"></td>
		</tr>
		<input type="hidden" name="id" value="${loginCustomer.getId()}">
		<input type="hidden" name="password" value="${loginCustomer.getPassword()}">
		
		<tr><!-- 原本name为 userid -->
		    <input type="hidden" name="name" value="${loginCustomer.getName()}">
			<td width="40%" class="tablebody2" align="right"><b>用户名</b>：</td>
			<td width="60%" class="tablebody1">${loginCustomer.getName()}</td>
		</tr>
		<tr><!-- 原本name为 street1 -->
		    <input type="hidden" name="address" value="${loginCustomer.getAddress()}">
			<td class="tablebody2" align="right"><b>联系地址</b>：</td>
			<td class="tablebody1">${loginCustomer.getAddress()}</td>
		</tr>
		<tr>
		<input type="hidden" name="zip" value="${loginCustomer.getZip()}"> 
			<td class="tablebody2" align="right"><b>邮编</b>：</td>
			<td class="tablebody1">${loginCustomer.getZip()}</td>
		</tr>
		<tr>
		<input type="hidden" name="homephone" value="${loginCustomer.getTelephone()}">
			<td class="tablebody2" align="right"><b>家庭电话</b>：</td>
			<td class="tablebody1">${loginCustomer.getTelephone()}</td>
		</tr>
		<tr>
		<input type="hidden" name="homephone" value="${loginCustomer.getTelephone()}">
			<td class="tablebody2" align="right"><b>办公室电话</b>：</td>
			<td class="tablebody1">${loginCustomer.getTelephone()}</td>
		</tr>
		<tr>
		<input type="hidden" name="telephone" value="${loginCustomer.getTelephone()}">
			<td class="tablebody2" align="right"><b>手机</b>：</td>
			<td class="tablebody1">${loginCustomer.getTelephone()}</td>
		</tr>
		<tr>
		<input type="hidden" name="email" value="${loginCustomer.getEmail()}">
			<td class="tablebody2" align="right"><b>Email地址</b>：</td>
			<td class="tablebody1">${loginCustomer.getEmail()}</td>
		</tr>
	</table>
<br>
<!--文件尾开始-->
		<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table2">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="images/bg2.gif">
			<font color="#FFFFFF"><b>付款方式</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody2" align="right">　</td>
			<td width="60%" class="tablebody1">
                          <select name="payway">
                            
		                          	<option value="邮局汇款">邮局汇款 </option>
                          	
		                          	<option value="货到付款">货到付款</option>
                          	
		                          	<option value="银行转帐">银行转帐</option>
                          	
                          </select></td>
		</tr>
		</table>
		<br>
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1 id="table3">
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" colspan="5">
			<font color="#ffffff"><b>商品购物清单</b></font><input type="button" value="修改" onclick="javascript:window.location='shopCartController/shopcart';"></td>
		</tr>
	
        <%int count=0;%>
        <c:forEach var="m" items="${map}">  
		<tr>
		    <% count=count+1; %>
			<td class=tablebody2 valign=middle align=center width=""><%=count%></td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="../productDetail.jsp?productid=2" target="_blank">${m.getValue().getBook().getName()}</a></td>
			<td class=tablebody2 valign=middle align=center width="" >价格：${m.getValue().getBook().getPrice()}</td>
			<td class=tablebody1 valign=middle align=center width="" id="num">数量：${m.getValue().getNum()}</td>
			<td class=tablebody2 valign=middle align=left width="" name="cost">小计：￥${m.getValue().getBook().getPrice()*m.getValue().getNum()}</td>
		</tr>
		</c:forEach>  
                
		<tr>
			<td class=tablebody1 valign=middle align=center colspan="4">　</td>
			<td class=tablebody1 valign=middle align=left width="">合计：<font color="#ff0000"><b>${shopcart.getCost()}</b></font></td>
		</tr>
		        </table>
		        <p align="center">请认真检查以上订单信息，确认无误后，点击 → <a id="submitorder" onclick="javascript:document.order.submit();" style="cursor:hand"><!-- <a href="../user/order.jsp"> --><img src="images/submit.gif"></a>
		</form>
</p>

		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" height="28">
		  <tr>
		    <td height="17" background="images/bot_bg.gif">
		      　</td>
		  </tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
		  <tr>
		    <td bgcolor="#f1f1f6" height="53" valign="center">
			<p align="center">Copyright &copy;2004 - 2013 <a href="http://www.briup.com.cn"><b><font face="Verdana,">briup</font></b><font color=#CC0000>.com.cn</font></b><br>
			</td>
		  </tr>
		</table>
		${loginuser.getEmail()}
			<c:forEach var="m" items="${map}">
	  ${m.getValue().getId()}
	  ${m.getValue().getBook().getName()}
      ${m.getValue().getBook().getPrice()}
      ${m.getValue().getNum()}
      ${m.getValue().getNum()*m.getValue().getBook().getPrice()}
      ${shopcart.getCost()}
      </c:forEach>
	</body>
</html>
</body>
</html>