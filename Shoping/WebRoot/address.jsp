<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'address.jsp' starting page</title>
    
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
</div>
  <!--  private Integer id;
	private DUser DUser;
	private String receiveName;
	private String fullAddress;
	private String postalCode;
	private String mobile;
	private String phone;
  -->
   <form action="Shop/address" method="post" style="">
   <div class="input-group">
      <span class="input-group-addon">用户昵称</span>
      <input type="text" class="form-control" placeholder="twitterhandle" name="dreceiveadress.receiveName">
   </div>
    <br>
    <div class="input-group">
      <span class="input-group-addon">用户地址</span>
      <input type="text" class="form-control" placeholder="twitterhandle" name="dreceiveadress.fullAddress">
   </div>
    <br>
    <div class="input-group">
      <span class="input-group-addon">用户邮编</span>
      <input type="text" class="form-control" placeholder="twitterhandle" name="dreceiveadress.postalCode">
   </div>
    <br>
    <div class="input-group">
      <span class="input-group-addon">用户电话</span>
      <input type="text" class="form-control" placeholder="twitterhandle" name="dreceiveadress.mobile">
   </div>
    <br>
    <div class="input-group">
      <span class="input-group-addon">用户手机</span>
      <input type="text" class="form-control" placeholder="twitterhandle" name="dreceiveadress.phone">
   </div>
    <br>
 
  <div class="input-group">
    <input type="submit" class="form-control" value="提交" />
   </div>
   </form>
   
   
   <script src="js/jquery-2.2.3.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  </body>
</html>
