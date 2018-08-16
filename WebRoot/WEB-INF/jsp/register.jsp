<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 没有导入jar -->
<!-- <script type="text/javascript" src="jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="province_city.js"></script> -->

<c:import url="header1.jsp"></c:import>

<!-- javasripct可以写在js任意的位置 -->
<script type="text/javascript">
  $(function(){
    //获取id
    $("#usernameId").blur(function(){
        $("#btn").attr("disabled",false);
        var value=$("#usernameId").val();
        if(value==""){//这里还有点问题如果是 空的话 还是
           $("#messageId").html("<font color='red'>请输入姓名</font>");
        }
        /* var va=this.value;
        alert("hello"); */ //按钮失效
        //alert(value);
         /* $("#messageId").html("<font color='red'>用户已经存在</font>");  */
        var url="<%= basePath %>customer/checkUserName/"+this.value;
        //alert(url);
        //用模板接收
        $.getJSON(url,function(data){
           //alert(data.status);
           
          if(data.status == 200){//data.msg == 'Y'
             $("#messageId").html("<font color='green'>可以注册</font>");     
          }else{
              $("#messageId").html("<font color='red'>用户名已存在</font>"); 
              $("#btn").attr("disabled",true);
             
          }
        
        });
    });
  })
  
  $(function(){
    //获取id
    $("#password").blur(function(){
       // $("#btn").attr("disabled",false);
        var value=$("#password").val();
        if(value==""){//这里还有点问题如果是 空的话 还是
           $("#password1").html("<font color='red'>请输入密码</font>");
        }else{
        if(value.length<6){
        $("#password1").html("<font color='red'>输入的密码不能少于6位</font>");
        
        }else{
        $("#password1").html("");
        }
        }
    }); 
  })
  
  $(function(){
    //获取id
    $("#password").blur(function(){
       // $("#btn").attr("disabled",false);
        var value=$("#password").val();
        if(value==""){//这里还有点问题如果是 空的话 还是
           $("#password1").html("<font color='red'>请输入密码</font>");
        }else{
        $("#password1").html("");
        }
    }); 
  })
  
   $(function(){
    //获取id
    $("#password2").blur(function(){
       // $("#btn").attr("disabled",false);
        var value=$("#password2").val();
        if(value==""){//这里还有点问题如果是 空的话 还是
           $("#span2").html("<font color='red'>请输入密码</font>");
        }else{
       
        if($("#password2").val()== $("#password").val()){
         $("#span2").html("");
        }else{
          $("#span2").html("二次密码不一致");
        }
        }
    }); 
  })
</script>
<!--文件体开始-->
<center>
<span>
<font color="red" size="5px">${sessionScope.msg}
</font>
</span>
</center>
<c:remove var="msg" scope="session"/>
		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="/images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> → 用户注册
                </td>
                </tr>
		</table>
              <br>

<form method="post" action="customer/registercustomer" name="reg">
	<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="images/bg2.gif">
			<font color="#ffffff"><b>新用户注册</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1"><b>用户名</b>：<br>
			注册用户名长度限制为0－16字节</td>
			<td width="60%" class="tablebody1">
			<input id="usernameId"  maxLength="8" size="32" name="name"  style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			<!-- 显示信息 -->
			<span id="messageId"><font color="#FF0000">*</font></span>
			</td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1"><b>密码(至少6位，至多8位)</b>：<br>
			请输入密码，区分大小写。<br>
			请不要使用任何类似 \'*\'、\' \' 或 HTML 字符'
			</td>
			<td width="60%" class="tablebody1">
			<input id="password" type="password" maxLength="8" size="32" name="password" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			<font color="#FF0000">*<span id="password1"></span></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1"><b>密码(至少6位，至多8位)</b>：<br>
			请再输一遍确认</td>
			<td class="tablebody1">
			<input id="password2" type="password" maxLength="8" size="32" name="password2" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			<font color="#FF0000">*<span id="span2"></span></font></td>
		</tr>
		<tr>
			<td class="tablebody1"><b>所在地区</b>：</td>
			<td class="tablebody1">
			<select id="province" name="province">
			</select>省
			<select id="city" name="city">
			</select>市
			<select id="area" name="area">
			</select>县
			<!-- <div>
	 地址是：<span id="pro_city"></span>    <input id="txtProCity" type="text" />
     </div>  -->
			<!-- <select name="country" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
				<option value="">中国</option>
				<option value="">中国香港</option>
				<option value="">中国台湾</option>
			</select>
			<select name="province" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                <option value="安徽" selected>安徽</option>

                <option value="北京" >北京</option>

                <option value="重庆" >重庆</option>

                <option value="福建" >福建</option>

                <option value="广东" >广东</option>

                <option value="甘肃" >甘肃</option>

                <option value="广西" >广西</option>

                <option value="贵州" >贵州</option>

                <option value="河南" >河南</option>

                <option value="湖北" >湖北</option>

                <option value="河北" >河北</option>

                <option value="海南" >海南</option>

                <option value="香港" >香港</option>

                <option value="黑龙江" >黑龙江</option>

                <option value="湖南" >湖南</option>

                <option value="吉林" >吉林</option>

                <option value="江苏" >江苏</option>

                <option value="江西" >江西</option>

                <option value="辽宁" >辽宁</option>

                <option value="澳门" >澳门</option>

                <option value="内蒙古" >内蒙古</option>

                <option value="宁夏" >宁夏</option>

                <option value="青海" >青海</option>

                <option value="四川" >四川</option>

                <option value="山东" >山东</option>

                <option value="上海" >上海</option>

                <option value="陕西" >陕西</option>

                <option value="山西" >山西</option>

                <option value="天津" >天津</option>

                <option value="台湾" >台湾</option>

                <option value="新疆" >新疆</option>

                <option value="西藏" >西藏</option>

                <option value="云南" >云南</option>

                <option value="浙江" >浙江</option>

                <option value="其它" >其它</option>
			</select>省 -->
			<!-- <input type="text" size="8" name="city" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">市/县</td> -->
		</tr>
		<tr>
			<td class="tablebody1"><b>联系地址1</b>：</td>
			<td class="tablebody1">
			<!-- <input type="text" size="64" maxlength="32" name="address" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000"> -->
			<div>
	   <span id="pro_city"></span>    <input id="txtProCity" type="text" name="address"/>
       </div> 
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>联系地址2</b>：</td>
			<td class="tablebody1">
			<input type="text" size="64" maxlength="32" name="address2" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>邮编</b>：</td>
			<td class="tablebody1">
			<input type="text" size="32" maxlength="8" name="zip" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>家庭电话</b>：</td>
			<td class="tablebody1">
			<input type="text" size="32" maxlength="16" name="homephone" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>办公室电话</b>：</td>
			<td class="tablebody1">
			<input type="text" size="32" maxlength="16" name="officephone" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>手机</b>：</td>
			<td class="tablebody1">
			<input type="text" size="32" maxlength="16" name="telephone" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>Email地址</b>：<br>
			请输入有效的邮件地址</td>
			<td class="tablebody1">
			<input maxLength="50" size="32" maxlength="32" name="email" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000"></td>
		</tr>
		<tr>
			<td class="tablebody2" valign="middle" colspan="2" align="center">
			<input id="btn" type="button" value="注 册" onclick="javascript:checkReg()">&nbsp;&nbsp;&nbsp;<input type="reset" name="reset" value="清 除"></td>
		</tr>
	</table>
</form>
<!--文件尾开始-->
<c:import url="footer.jsp"></c:import>
