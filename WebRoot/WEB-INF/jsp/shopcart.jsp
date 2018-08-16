<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp"></c:import>
<script type="text/javascript">
  function checkOrder(){
		
			if($("#cost").val() == null || $("#cost").text()== 0.0){
			    $("#tishiId").html("<center><font color='red'><h1>请先选择商品</h1></font></center>");
				$("#submitId").attr("disabled", true);
				$("#clearId").attr("disabled", true);
			    
			}
			else{
				$("#submitId").attr("disabled", false);
				window.location.href='confirmOrder';
			}
			
		}
  
</script>
<!--文件体开始-->
        <span id="tishiId"></span>
		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					购物清单
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>数量</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>合计</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>

        <c:forEach var="m" items="${sessionScope.map}" varStatus="vs">
		<tr>
			<form method="post" action="shopCartController/eidtOrderLine" name="f1"><!--addorderline  -->
			<input type="hidden" name="productid" value="${m.getValue().getBook().getId()}">
			<input type="hidden" name="number" value="1">
			<td class=tablebody2 valign=middle align=center width="" id="lineid">${vs.index+1}</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.jsp?productid=2">${m.getValue().getBook().getName()}</a></td>
			<td class=tablebody2 valign=middle align=center width="">${m.getValue().getBook().getPrice()}</td>
			<td class=tablebody1 valign=middle align=center width=""><input type="text" name="num" value="${m.getValue().getNum()}" size="4" onblur="javascript:if(this.value<1){ <!-- alert('对不起，产品数量不能小于 1 '); -->number.value=0;this.focus();}else{number.value=this.value;}"/></td>
			<td class=tablebody2 valign=middle align=left width="" id="cost">&nbsp;&nbsp;${m.getValue().getNum()*m.getValue().getBook().getPrice()}</td>
			<td class=tablebody1 valign=middle align=center width="">
			<input type="button" value="取消" onclick="javascript:window.location='shopCartController/deleteOrderLine?productid=${m.getValue().getBook().getId()}';"> <input type="submit" value="保存修改"></td>
			</form>
		</tr>
      </c:forEach>
		<tr>
			<td class=tablebody1 valign=middle align=center colspan="4">　</td>
			<td class=tablebody1 valign=middle align=left width="">&nbsp;&nbsp;<font color="#ff0000"><b id="totalCost">￥${shopcart.getCost()}</b></font></td>
			<td class=tablebody1 valign=middle align=center width="">　</td>
		</tr>
		
		<tr>
			<td class=tablebody2 valign=middle align=center colspan="6"><input id="submitId" type="button" value="提交订单" onclick="javascript:checkOrder()<!-- javascript:window.location='confirmOrder' -->;"> <input type="button" value="继续购物" onclick="javascript:window.location='index';"> <input id="clearId" type="button" value="清空购物车" onclick="javascript:window.location='shopCartController/clearShopCart';"></td>
		</tr>
                </table><br>
<!--文件尾开始-->
	<c:import url="footer.jsp"></c:import>