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
    
    <title>My JSP 'ok.jsp' starting page</title>
    
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

<div class="row">	
  
 <div>
<div class="panel panel-primary">
   <div class="panel-heading">
      <h3 class="panel-title">面板标题</h3>
   </div>
   <div class="panel-body">
     <s:iterator value="Plist" var="plist">
 <!-- 父循环 -->
 <div class="col-sm-12">
 <dl><dt style="color:Orange font-size:20px"><a href="BookDetial/seach?id=<s:property value="id"/>&op=1&pagenum=1" style="text-decoration:none;color:Orange"><s:property value="#plist.name"/></a></dt>
 
 <s:set name="plsitcurrent" value="#plist" />
 <s:iterator value="Clist" var="clist">
 <!-- 子循环 -->
 <s:if test="#plsitcurrent.turn+1==#clist.parentId">
 <dd style="float:left;" id="try">
 <a href="BookDetial/seach?id=<s:property value="id"/>&op=1&pagenum=1" style="text-decoration:none;color:#000"><s:property value="#clist.name"/>|
 </a>
 </dd>
 </s:if>
 </s:iterator>
 </dl>
 </div>
 </s:iterator>
   </div>
</div>	
</div>
 
 
 </div>
   
  <script src="js/jquery-2.2.3.min.js"></script>
   
		
   	 	<script src="js/bootstrap.min.js"></script>
   	<script type="text/javascript"> 
   	 
  //  var tryid=document.getElementById("try");
  //var tyra=tryid.getElementsByTagName("a");
  //for(var i=0;i<tyra.length;i++){
  	//alert(tyra[i].innerHTML);
  //}
	</script>
  </body>
</html>

