<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证码的检查</title>
<script type="text/javascript" src="js/ajax.js"></script>
</head>
<body>
 <form>
   <table border="0" align="center">
     <tr>
     <th>验证码：</th>
     <td><input size="2" type="text" name="checkcode" id="checkcodeID" maxlength="4"></td>
     <td><img src="01_image.jsp" /></td>
     <td id="res"></td>
     </tr>
     
   </table>
 </form>
 <script type="text/javascript">
   function trim(str){
	   str=str.replace(/^\s*/,"");//将^表示左侧 左侧的空格去掉 \s表示空白符
       str=str.replace(/\s*$/,"");
	   return str;
   }
 </script>
 <script type="text/javascript">
   document.getElementById("checkcodeID").onkeyup=function(){
	   var checkcode=this.value;
	  // alert(checkcode);
	   //去掉俩边空格
	   checkcode=trim(checkcode);//
	   if(checkcode.length==4){
		   //NO.1
		   var ajax=createAjax();
		  // alert(ajax!=null);
		   //NO.2
		   var method="POST";
		   var url="${pageContext.request.contextPath}/checkcode?time="+new Date().getTime();
		   //alert(url);
		   ajax.open(method,url);
		   //NO.3
		   ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
		   //NO.4
		    var content="checkcode="+checkcode;
		  // alert(content);
		   ajax.send(content);
		   //==============================等待
		   
		   //NO.5onreadystatechange
		   ajax.onreadystatechange=function(){
			   if(ajax.readyState==4){
				   if(ajax.status==200){
					   //NO.6
					   var tip=ajax.responseText;
					   //alert(tip);
					   //NO.7
					   var img=document.createElement("img");
					   img.src=tip;
					   img.style.width="14px";
					   img.style.height="14px";
					   var td=document.getElementById("res");
					   td.innerHTML="";
					   td.appendChild(img);
				   }
				   
			   }
		   }
	   }else{
		   //清空图片
		   var td=document.getElementById("res");
		   td.innerHTML="";
	   }
   }
 </script>
</body>
</html>