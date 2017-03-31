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
    
    <title>My JSP 'newbook.jsp' starting page</title>
    
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
   <div class="panel panel-info">
   		<div class="panel-heading">
      		<h3 class="panel-title">新书推荐</h3>
   		</div>
 		<div class="panel-body" >
   
 			<div class="row" style="margin-bottom:20px" style="height:400px">
 <!-- 遍历开始  -->
 
  <s:iterator value="newplist" var="newpl" status='st'>          
    		<div class="col-sm-4">
    			 <a href="BookDetial/bookdisplay?id=<s:property value="id"/>" class="thumbnail">
    			<img src="img/<s:property value='productPic'/>" width="200" height="400" />	
    			</a>
    			<div class="caption">  			
    				<h4 class="text-primary">作者：<s:property value="productName"/></h4>
    				<p class="text-muted">出版社：<span><s:property value="DBook.author"/></span>出版时间：<span><s:property value="DBook.publishing"/></span></p>
					
					<p><s:property value="description"/></p>
					<p><span>定价：￥</span><span><s:property value="fixedPrice"/></span><span> 当当价：￥</span><span><s:property value="dangPrice"/></span></p>
    			</div>
    		</div>
</s:iterator>
<!-- 遍历结束 -->
			</div>
	</div>			
</div>	
  </body>
</html>
