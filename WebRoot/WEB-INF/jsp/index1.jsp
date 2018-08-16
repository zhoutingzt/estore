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
                  <a href=index.jsp>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					欢迎<font size="2px" color="blue">${sessionScope.loginUserName}</font>光临！
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>
       <c:forEach var="b" items="${sessionScope.pageBean.pageData}" varStatus="vs"> 
          <%-- <c:forEach var="b" items="${books}" varStatus="vs"> --%>
		<tr>
			<td class=tablebody2 valign=middle align=center width="">${vs.index+1}</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.action?productid=${b.id}">${b.name}</a></td>
			<td class=tablebody2 valign=middle align=center width="">${b.price}</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="shopCartController/addline?productid=${b.id}">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>
		</c:forEach>
		
         <tr rowspan="2">
  			<td colspan="3"  rowspan="2" align="center"  class=tablebody2 width=100%>
  				当前${sessionScope.pageBean.currentPage }/${sessionScope.pageBean.totalPage }页     &nbsp;&nbsp;
  				<a href="${pageContext.request.contextPath }/customer/showbook?currentPage=1">首页</a>
  				<a href="${pageContext.request.contextPath }/customer/showbook?currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>
  				<a href="customer/showbook?currentPage=${sessionScope.pageBean.currentPage+1}">下一页 </a>
  				<a href="customer/showbook?currentPage=${sessionScope.pageBean.totalPage}">末页</a>
  			</td>
  			<td colspan="3" align="center" border="1" class=tablebody2 width=100%></td>
  		</tr>
                
                
		<!-- <tr>
			<td class=tablebody2 valign=middle align=center width="">2</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.jsp?productid=4">Effective Java中文版</a></td>
			<td class=tablebody2 valign=middle align=center width="">39.0</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="addorderline?productid=2">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>
                
		<tr>
			<td class=tablebody2 valign=middle align=center width="">3</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.jsp?productid=8">精通Spring</a></td>
			<td class=tablebody2 valign=middle align=center width="">39.0</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="addorderline?productid=3">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>
                
		<tr>
			<td class=tablebody2 valign=middle align=center width="">4</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.jsp?productid=6">深入浅出Hibernate</a></td>
			<td class=tablebody2 valign=middle align=center width="">59.0</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="addorderline?productid=4">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>
                
		<tr>
			<td class=tablebody2 valign=middle align=center width="">5</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.jsp?productid=1">JAVA编程思想：第3版</a></td>
			<td class=tablebody2 valign=middle align=center width="">95.0</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="addorderline?productid=5">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>
                
		<tr>
			<td class=tablebody2 valign=middle align=center width="">6</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.jsp?productid=3">Java 2核心技术（第6版） 卷I：基础知识 </a></td>
			<td class=tablebody2 valign=middle align=center width="">75.0</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="addorderline?productid=6">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>
                
		<tr>
			<td class=tablebody2 valign=middle align=center width="">7</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.jsp?productid=7">Tomcat与Java Web开发技术详解</a></td>
			<td class=tablebody2 valign=middle align=center width="">45.0</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="addorderline?productid=7">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>
                
		<tr>
			<td class=tablebody2 valign=middle align=center width="">8</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.jsp?productid=5">Java与模式</a></td>
			<td class=tablebody2 valign=middle align=center width="">88.0</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="addorderline?productid=8">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>  -->
                
		</table>
<!--文件尾开始-->
		<c:import url="footer.jsp"></c:import>