<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header1.jsp"></c:import>
<script type="text/javascript">

    window.onload=function(){
        setTimeout(function(){$("#indexjsid").remove()},1000)
    }

</script>
<script type="text/javascript">
  $(function(){
    //获取id
    $("#checkcodeID").blur(function(){
       
        var value=$("#checkcodeID").val();
       
        var url="<%= basePath %>customer/checkcode/"+this.value;
        //alert(url);
        //用模板接收
        $.getJSON(url,function(data){
          alert(data.status);
           
          if(data.status == 200){//data.msg == 'Y'style="width:200px;height:200px;"
             $("#res").html("<img src='images/MsgSent.gif' style='width:14px;height:14px'>"); 
           //  $("img").attr("src","images/MsgSent.gif");    
          }else{
          $("#res").html("<img src='images/MsgError.gif' style='width:14px;height:14px'>"); 
            
          }
        
        });
    });
  })
  </script>
<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="/images/Forum_nav.gif" align="absmiddle">
                  <a href=index.jsp>杰普电子商务门户</a> → 用户登录
                </td>
                </tr>
                
		</table>
              <br>
<!-- login -->
<span id="indexjsid" style="position: absolute;left: 1260px;top: 140px"><font color="red">${sessionScope.commonmessage }</font></span>
<center>

   <span>
   <font color="red" size="5px">${sessionScope.msg}</font>
   </span>
    <span>
   <font color="red" size="5px">${sessionScope.msg1}</font>
   </span>
</center>
<c:remove var="msg" scope="session"/>
<c:remove var="msg1" scope="session"/>
	<form action="customer/checklogin" method=post name="login">
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle colspan=2 align=center height=25 background="images/bg2.gif" ><font color="#ffffff"><b>输入您的用户名、密码登录</b></font></td>
		</tr>
		<tr>
		<td valign=middle class=tablebody1>请输入您的用户名</td>
			<td valign=middle class=tablebody1><INPUT name=name type=text> &nbsp;
				<a href="register">没有注册？</a>
			</td>
		</tr>
		<tr rowspan="2">
			<td valign=middle class=tablebody1>请输入您的密码</td>
			<td valign=middle class=tablebody1><INPUT name=password type=password> &nbsp; </td>
		</tr>
		<tr>
    <td valign=middle class=tablebody1>验证码：</td>
     <td valign=middle class=tablebody1><input size="2" type="text" name="checkcode" id="checkcodeID" maxlength="4">
     <img src="01_image.jsp" /> <span id="res"><img></span></td>
     
     </tr>
     </tr>
		<tr>
			<td class=tablebody2 valign=middle colspan=2 align=center><input type="submit" value="登 录" onclick="javascript:checkMe()"></td>
		</tr>
		<tr>
     
		</table>
	</form>
	

<!--文件尾开始-->
	<c:import url="footer.jsp"></c:import>

