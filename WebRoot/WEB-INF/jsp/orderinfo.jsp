<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp"></c:import>
<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=../index.html>杰普电子商务门户</a> →
					<a href="order.html">定单列表</a> →
					定单明细
                </td>
                </tr>
		</table>
              <br>

		<form name="order" method="post" action="../saveOrder.action"/>
		<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="images/bg2.gif">
			<font color="#ffffff"><b>用户信息</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody2" align="right"><b>用户名</b>：</td>
			<td width="60%" class="tablebody1">${customer.getName()}</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>联系地址</b>：</td>
			<td class="tablebody1">${customer.getAddress()}</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>邮编</b>：</td>
			<td class="tablebody1">${customer.getZip()}</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>家庭电话</b>：</td>
			<td class="tablebody1">sdfadsf</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>办公室电话</b>：</td>
			<td class="tablebody1">${customer.getTelephone()}</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>手机</b>：</td>
			<td class="tablebody1">${customer.getTelephone()}</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>Email地址</b>：</td>
			<td class="tablebody1">${customer.getEmail()}</td>
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
			<td width="60%" class="tablebody1">${sessionScope.order.payway} </td>
		</tr>
		</table>
		<td valign="middle" align="center" height="25" background="../images/bg2.gif" colspan="5">
			<font color="#ffffff"><b>商品购物清单</b></font></td><br>
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1 id="table3">
		<tr>
			
		</tr>
           <c:forEach var="line" items="${lines}" varStatus="vs">   
		<tr>
			<td class=tablebody2 valign=middle align=center width="">${vs.index+1}</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="../productDetail.jsp?productid=2" target="_blank">${line.getBook().getName()}</a></td>
			<td class=tablebody2 valign=middle align=center width="">价格：${line.getBook().getPrice()}</td>
			<td class=tablebody1 valign=middle align=center width="">数量：${line.getNum()}</td>
			<td class=tablebody2 valign=middle align=left width="">小计：￥${line.getNum()*line.getBook().getPrice()}</td>
		</tr>
          </c:forEach>       
		<tr>
			<td class=tablebody1 valign=middle align=center colspan="4">　</td>
			<td class=tablebody1 valign=middle align=left width="">合计：<font color="#ff0000"><b name="cost">￥${sum}</b></font></td>
		</tr>
		        </table>
		</form>
		<br>
</p>

		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" height="28">
		  <tr>
		    <td height="17" background="../images/bot_bg.gif">
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
	</body>
</html>