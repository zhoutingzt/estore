<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"></c:import>
<script type="text/javascript">
function GetDateNow() {
		var vNow = new Date();
		var sNow = "";
		sNow += String(vNow.getFullYear());
		sNow += String(vNow.getMonth() + 1);
		sNow += String(vNow.getDate());
		sNow += String(vNow.getHours());
		sNow += String(vNow.getMinutes());
		sNow += String(vNow.getSeconds());
		sNow += String(vNow.getMilliseconds());
		document.getElementById("WIDout_trade_no").value =  sNow;
		document.getElementById("WIDsubject").value = "测试";
		document.getElementById("WIDtotal_amount").value = ${ordercost};
	}
	GetDateNow();
</script>
<!--文件体开始-->
<input id="WIDTCout_trade_no" name="WIDTCout_trade_no" type="hidden" />
<input id="WIDTQtrade_no" name="WIDTQtrade_no" type="hidden"/>
<input id="WIDTRout_trade_no" name="WIDTRout_trade_no" type="hidden"/>
<input id="WIDout_trade_no" name="WIDout_trade_no" type="hidden"/>
<input id="WIDsubject" name="WIDsubject" type="hidden"/>
<input id="WIDtotal_amount" name="WIDtotal_amount" type="hidden"/>
		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					订单列表
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单编号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单金额</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单状态</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>付款方式</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>
		
         <%-- <c:forEach var="set" items="${loginuser.getOrders()}" varStatus="vs">  --%>
        
             <c:forEach var="order" items="${sessionScope.orders}" varStatus="vs"> 
             <%-- <%double ordercost=order.value.getCost();%> --%>
		<tr>
			<td class=tablebody2 valign=middle align=center width="">${vs.index+1}</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="orderController/showorderinfo?orderid=${order.value.id}">${order.value.id}</a></td>
			<td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;${order.value.cost}</td><!-- ${shopcart.getCost()} -->
			<td class=tablebody1 valign=middle align=center width="">${order.value.orderDate}</td>
			<td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;${order.value.payway} </td>
			<td class=tablebody1 valign=middle align=center width="">
			<input type="button" value="删除" onclick="javascript:window.location='orderController/deleteOrder?orderid=${order.value.id}';">&nbsp;<input type="button" value="明细" onclick="javascript:window.location='orderController/showorderinfo?orderid=${order.value.id}';"><input type="button" value="支付" onclick="javascript:window.location='pay?ordercost=${order.value.cost}';"><!--&nbsp;<input type="button" value="修改"/>--> </td>
		</tr>
          </c:forEach>  
                </table><br>
                ${order.value.payway}
<!--文件尾开始-->
		<c:import url="footer.jsp"></c:import>
