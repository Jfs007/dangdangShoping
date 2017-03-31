<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="css/bootstrap.css">
  </head>
  
  <body>
   <div class="row">
			<div class="col-sm-12">
				<ol class="breadcrumb">
					<s:if test="#session.user!=null">
					<li><a href="Shop/shoptrans?userid=<s:property value="#session.user.id"/>">购物车</a></li>
					<li><a href="User/toBackstage?userid=<s:property value="#session.user.id"/>">我的当当</a></li>
					<li><a id="loginOut" href="">登出</a></li>
					<li><a id="" href="">首页</a></li>
					</s:if>
					<s:else>
					<li><a id="" href="" class="text-danger">欢迎来到当当网</a></li>
					<li><a href="" data-toggle="modal" data-target="#myModal" >登陆</a> </li>
					</s:else>
				</ol>
			</div>
			<div class="col-sm-0">
				
			</div>
		</div>
		<script src="js/jquery-2.2.3.min.js"></script>
   	 	<script src="js/bootstrap.min.js"></script>
   	 	<script type="text/javascript">
   	 	$("#loginOut").click(function(){
		var url = "User/loginOut";
		var data = "";
		$.ajax({
			type : "get",
			async : true,
			url : url,
			data : data,
			
			success:function(){
			
			$("#adminNavbar").html();
			
			//alert("ddd");
			},
			error: function() {
			alert("error");
            }
		});
		
		
	});
   	 	</script>
  </body>
</html>
