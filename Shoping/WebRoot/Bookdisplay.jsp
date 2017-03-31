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
    
    <title>My JSP 'Bookdisplay.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div>
	<div class="div">
		 <jsp:include page="header.jsp"></jsp:include>
		
	</div>
</div>
<div class="row">
<div class="col-sm-3"></div>
<div class="col-sm-2">
   <img src="img/<s:property value='#request.dproduct.productPic'/>" width="100">
</div>
<div class="col-sm-3">
   <s:property value="#session.user.id"/>
   <s:property value="#request.dproduct.productName"/>
   <s:if test="#session.user!=null">
   <a href="Shop/shoptransadd?dcartItem.UserId=<s:property value="#session.user.id"/>&dcartItem.ProId=<s:property value="#request.dproduct.id" />">添加购物单</a>
   </s:if>
   <a href="">返回</a>
   <s:if test="#session.user!=null">
   <a href="Shop/shoptrans?userid=<s:property value="#session.user.id"/>">购物车</a>
 </s:if>
 
 </div>
 </div>
  </body>
</html>
