<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderend.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <link rel="stylesheet" href="css/bootstrap.css">
  <body>
  
  <div>
	<div class="div">
		 <jsp:include page="header.jsp"></jsp:include>
		
	</div>
  </div>
  
  <div class="row">
  <i id='user'><s:property value="#session.user.id"></s:property></i>
  <s:iterator value="addresslist" var="alist">
  <div class="col-sm-1"></div>
  <div class="col-sm-11">
  
  <h3 class="active">
  <input type="radio" name="address" value="<s:property value="#alist.id"></s:property>">
  <s:property value="receiveName"></s:property>
  <s:property value="fullAddress"></s:property>
  <s:property value="postalCode"></s:property>
  <s:property value="mobile"></s:property></h3>
  <p><s:property value="phone"></s:property>
  </p>
  
  </div>
  </s:iterator>
  </div>
  <div class="row">
  <div class="col-sm-1"></div>
  <div class="col-sm-2">
   <a href="Shop/toaddress">添加新地址</a>
  </div>
  </div>

    <s:iterator value="itlist" var="itlist" status='st'>          
    	<div class="row">
    		<div class="col-sm-1">
    		<span style="line-height:100px;text-align:center">
    		</span>
    		</div>
    		<div class="col-sm-2">
    			 <a href="BookDetial/bookdisplay?id=<s:property value="id"/>" class="thumbnail">
    			<img src="img/<s:property value='DProduct.productPic'/>" width="100" height="100" />	
    			</a>
    	   	</div>
    	   	<div class="col-sm-3"></div>
    	   	<div class="col-sm-3">	
    	            <span><s:property value="DProduct.id"/></span> 			
    				<p class="text-primary">作者：<s:property value="productName"/></p>
    				<p class="text-muted">出版社：<span><s:property value="dangPrice"/></span>出版时间：<span><s:property value=""/></span></p>
					<p><s:property value=""/></p>
					<p><span>定价：￥</span><span><s:property value=""/></span><span> 当当价：￥</span><span><s:property value=""/></span></p>   			  			
    		</div>
    		<div class="col-sm-1">
    		
    		  
    		</div>
    	</div>	
</s:iterator>
<div>
<a href="Shop/orderOK? addressid=<s:property value="#alist.id" />& userid=<s:property value="#session.user.id" />">完成订单</a>
</div>

<div id="load" style="border-radius:13px;background:gray;display:none;position:absolute;left:50%;top:50%">请稍等呢...</div>
 <script src="js/jquery-2.2.3.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript">
  function loaddd(){
    load.style.display="block";
    }
 var radioO = $("input:radio");
 //alert(radioO[1]);
 //alert(radioO[1].value);
 for(var i=0;i<radioO.length;i++){
 radioO[i].index=i;
 //alert("------");
 radioO[i].onclick=function(){
 var addressid = radioO[this.index].value;
 var user= $("#user");
 var userid=user.innerText;
 var url ="Shop/addressupdate";
 var data = {"userid":userid,"addressid":addressid};
	        //ajax
	$.ajax({
	type:"get",
	async:true,
	url:url,
	data:data,
	
	beforeSend:function(){
	loaddd();
	},
	//dataType:'json',
	success:function(){
	//alert("dd");
	//$("#validat").html(data);
	load.style.display="none";
	//dujia.innerText=data;
	},
	error:function(){
	alert("error");
	
	}
	});
 }
 }
  </script>

  </body>
</html>
