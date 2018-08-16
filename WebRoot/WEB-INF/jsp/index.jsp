<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp"></c:import>

<script type="text/javascript">

    window.onload=function(){
        setTimeout(function(){$("#indexjsid").remove()},1000)
    }

</script>
<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					欢迎<font size="2px" color="blue">${sessionScope.loginUserName}</font>光临！
                     
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
		<form action="selectBook" method="post">
		<td>书名：<input id="nameID" type="text" name="name" size="20px"/></td>
		<td>作者：<input id="authorID" type="text" name="author" size="20px"/>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td>最低价：<input id="lowpriceID" type="text" name="lowprice" size="20px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td colspan="1">最高价：<input id="highpriceID" type="text" name="highprice" size="15px"/>&nbsp;&nbsp;
		评价等级：<select name="country" id="selectprice" >
				<option value="">*</option>
				<option value="">**</option>
				<option value="">***</option>
			</select>
		<input type="submit" value="搜索"/></td>
		</form>
		</tr>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>
      <%--  <c:forEach var="b" items="${sessionScope.pageBean.pageData}" varStatus="vs"> 
          <c:forEach var="b" items="${books}" varStatus="vs">
		<tr>
			<td class=tablebody2 valign=middle align=center width="">${vs.index+1}</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.action?productid=${b.id}">${b.name}</a></td>
			<td class=tablebody2 valign=middle align=center width="">${b.price}</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="shopCartController/addline?productid=${b.id}">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>
		</c:forEach> --%>
		
		<c:choose>
		  <c:when test="${!empty sessionScope.bookbytiaojian}">
		    <c:forEach var="book1" items="${sessionScope.bookbytiaojian}" varStatus="status">
		    <tr>
			<td class=tablebody2 valign=middle align=center width="">${status.index + 1 }</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.action?productid=${book1.id}">${book1.name }</a></td>
			<td class=tablebody2 valign=middle align=center width="">${book1.price }</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="shopCartController/addline?productid=${book1.id}">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>
		    </c:forEach>
		   
		  </c:when>
		   
		  <c:when test="${!empty sessionScope.pageInfo.list }">
		  <c:forEach var="book" items="${sessionScope.pageInfo.list }" varStatus="status">
         
       	<tr>
			<td class=tablebody2 valign=middle align=center width="">${status.index + 1 }</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.action?productid=${book.id}">${book.name }</a></td>
			<td class=tablebody2 valign=middle align=center width="">${book.price }</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="shopCartController/addline?productid=${book.id}">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>
       </c:forEach> 
	</c:when>
		</c:choose>
		<c:remove var="bookbytiaojian" scope="session"></c:remove>
		 <%-- <c:forEach var="book1" items="${sessionScope.bookbytiaojian}" varStatus="status">
		    <tr>
			<td class=tablebody2 valign=middle align=center width="">${status.index + 1 }</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.action?productid=${book1.id}">${book1.name }</a></td>
			<td class=tablebody2 valign=middle align=center width="">${book1.price }</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="shopCartController/addline?productid=${book1.id}">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>
		    </c:forEach> --%>
		<%-- <c:forEach var="book" items="${sessionScope.pageInfo.list }" varStatus="status">
       
       	<tr>
			<td class=tablebody2 valign=middle align=center width="">${status.index + 1 }</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.action?productid=${book.id}">${book.name }</a></td>
			<td class=tablebody2 valign=middle align=center width="">${book.price }</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="shopCartController/addline?productid=${book.id}">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>
       </c:forEach>  --%>
		
		
		
        <%--  <tr rowspan="2">
  			<td colspan="3"  rowspan="2" align="center"  class=tablebody2 width=100%>
  				当前${sessionScope.pageBean.currentPage }/${sessionScope.pageBean.totalPage }页     &nbsp;&nbsp;
  				<a href="${pageContext.request.contextPath }/customer/showbook?currentPage=1">首页</a>
  				<a href="${pageContext.request.contextPath }/customer/showbook?currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>
  				<a href="customer/showbook?currentPage=${sessionScope.pageBean.currentPage+1}">下一页 </a>
  				<a href="customer/showbook?currentPage=${sessionScope.pageBean.totalPage}">末页</a>
  			</td>
  			<td colspan="3" align="center" border="1" class=tablebody2 width=100%></td>
  		</tr> --%>
  		<tr align="center" bgcolor="#FFFFFF">
			<td colspan="5">共${sessionScope.pageInfo.total }条记录 每页 4 条 第${sessionScope.pageInfo.pageNum }/${sessionScope.pageInfo.pageSize }页 
			<a	href="index?page=1">首页</a>
					<c:if test="${sessionScope.pageInfo.hasPreviousPage}">
						<a href="index?page=${sessionScope.pageInfo.prePage }">上一页</a>
					</c:if>
					<c:if test="${sessionScope.pageInfo.hasNextPage}">
						<a href="index?page=${sessionScope.pageInfo.nextPage }">下一页</a>
					</c:if>
				<a href="index?page=${sessionScope.pageInfo.lastPage }">尾页</a>
			</td>
		</tr>
               <%--  <% ${sessionScope.bookbytiaojian}%> --%>
<!--文件尾开始-->
		<c:import url="footer.jsp"></c:import>