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
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
	
</div>
<div>
<div class="panel panel-info">
   		<div class="panel-heading">
      		<h3 class="panel-title">图书浏览</h3>
   		</div>
 		<div class="panel-body" >
   
 			<div class="row" style="margin-bottom:20px" style="height:600px">
 <!-- 遍历开始  -->
 
  <s:iterator value="plist" var="pl" status='st'>
  <s:if test="#st.First">
          <div class="row" style="margin-bottom:20px">
    			<div class="col-sm-4">
    			 <a href="BookDetial/bookdisplay?id=<s:property value="id"/>" class="thumbnail">
    			<img src="img/<s:property value='productPic'/>" width="400" height="600" />	
    			</a>
    			</div>
    			<div class="col-sm-6">
    				<h3 class="text-primary">作者：<s:property value="productName"/></h3>
    				<h4 class="text-muted">出版社：<span><s:property value="DBook.author"/></span>出版时间：<span><s:property value="DBook.publishing"/></span></h4>
					
					<h4><s:property value="description"/></h4>
					<h4><span>定价：￥</span><span><s:property value="fixedPrice"/></span><span> 当当价：￥</span><span><s:property value="dangPrice"/></span></h4>
    			</div>
    		</div>
  </s:if>
  <s:elseif test="#st.Even">
    		<div class="row" style="margin-bottom:20px">
    			<div class="col-sm-3">
    			 <a href="BookDetial/bookdisplay?id=<s:property value="id"/>" class="thumbnail" >
    			<img src="img/<s:property value='productPic'/>" class="" width="180" height="280" />
    			</a>	
    			</div>
    			<div class="col-sm-3">
    				<h5 class="text-primary">作者：<s:property value="productName"/></h5>
    				<p class="text-muted">出版社：<span><s:property value="DBook.author"/></span>出版时间：<span><s:property value="DBook.publishing"/></span></p>
					
					<p><s:property value="description"/></p>
					<p><span>定价：￥</span><span><s:property value="fixedPrice"/></span><span> 当当价：￥</span><span><s:property value="dangPrice"/></span></p>
    			</div>
    		
  </s:elseif>
  <s:else>
  
  	<div class="col-sm-3">
    			 <a href="#BookDetial/bookdisplay?id=<s:property value="id"/>" class="thumbnail" >
    			<img src="img/<s:property value='productPic'/>" class=""width="180" height="280" />
    			</a>	
    			</div>
    			<div class="col-sm-3">
    				<h5 class="text-primary">作者：<s:property value="productName"/></h5>
    				<p class="text-muted">出版社：<span><s:property value="DBook.author"/></span>出版时间：<span><s:property value="DBook.publishing"/></span></p>
					
					<p><s:property value="description"/></p>
					<p><span>定价：￥</span><span><s:property value="fixedPrice"/></span><span> 当当价：￥</span><span><s:property value="dangPrice"/></span></p>
    			</div>
    		</div>
  </s:else>
 
</s:iterator>
<!-- 遍历结束 -->
			</div>
	</div>		
<div class="panel-footer">
 <ul class="pager">
 	<s:property value="pagenum" />

  
  <s:if test="#request.pagecount==#request.pagenum">
  <li class="previous">
  <a href="BookDetial/seach?id=<s:property value="id"/>&pagenum=1&op=1">&larr;首页</a>
  </li>
  </s:if>
  <s:else>
  <li class="previous disabled"><a href="#">&larr; 首页</a></li>
  </s:else>
  
 
  <s:if test="#request.pagecount>#request.pagenum">
  <li class="next">
  <a href="BookDetial/seach?id=<s:property value="id"/>&pagenum=<s:property value="pagenum+1" />&op=1">下一页&rarr;</a></s:if>
  </li>
  <s:else>
  <li class="next disabled"><a href="#">下一页&rarr;</a></li>
  </s:else>  
</ul>
 </div>
			
	
	
</div>	
</div>
  
  <script src="js/jquery-2.2.3.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
   	<script type="text/javascript">
   //	alert("hhh");
   //	$(document).click(function(){
  // 	alert("ddd");
   	
   	//});
   	</script> 	
  </body>
</html>
