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
    
    <title>My JSP 'user.jsp' starting page</title>
    
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
   <div>
	<div class="div">
		 <jsp:include page="header.jsp"></jsp:include>
	</div>
	<div class="container">
	<div class="row">
		<div id="" class="col-sm-10">
		<ol class="breadcrumb">
		<li>我的订单</li>
		<li>未付款</li>
		<li>已收到</li>
		</ol>
		<p> <span class="text-primary">书名</span> <span class="text-primary">当当价</span></p>
		<s:iterator value="dtlist" var="dtlist" status='st'>  
		<p>
			<span class="text-primary"><s:property value="productName"/></span>
    		<span class="text-muted"><s:property value="dangPrice"/></span>		 		
		</p>
		</s:iterator>
		</div>
		<div class="col-sm-2">
			<div style="" class="text-center"></div>
			<p>Email:<s:property value="#session.user.email"></s:property></p>
			<p>昵称<s:property value="#session.user.nickname"></s:property></p>
			<p>用户积分<s:property value="#session.user.userIntegral"></s:property></p>
		</div>
	</div>
</div>
	
</div>

		<script src="js/jquery-2.2.3.min.js"></script>
   	 	<script src="js/bootstrap.min.js"></script>
  </body>
</html>
