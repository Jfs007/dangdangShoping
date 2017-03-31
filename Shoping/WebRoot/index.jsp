<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/bootstrap.css">
    	
   	 	<style type="text/css">
   	 		.login{
   	 			width:400px
   	 		}
   	 		.mar{margin-bottom:30px}
   	 	</style>
	</head>
	<body>
	<!-- 顶部  -->
	
<div>
	<div class="div">
		 <jsp:include page="header.jsp"></jsp:include>
		
	</div>
</div>
	<!-- 图书浏览部 -->
<div class="div">
    <div class="row">
    	<div class="col-sm-2" >
         	<s:action name="catLoad" executeResult="true" namespace="/Cat"></s:action>
        </div>
        
	    <div class="col-sm-8">
	    	<s:if test="#request.op!=1"><s:action name="recommend" executeResult="true" namespace="/BookDetial"></s:action></s:if>
	    	<s:else> <jsp:include page="booklist.jsp"></jsp:include></s:else>
	 <!-- 新书推荐 -->
			<s:action name="newbook" executeResult="true" namespace="/BookDetial"></s:action>
	     </div>
	</div>
</div>
	  	   		<!-- 这里是模态-->
      <div class="modal fade " id="myModal" tabindex="-1" role="dialog" 
                aria-labelledby="myModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
         			<div class="modal-content ">
         				
         				<div class="modal-body">
         					<ul class="nav nav-tabs row mar">        
         					<li class="col-sm-6 active"><a href="#login" data-toggle="tab"><h5>登陆</h5></a></li>
         					<li class="col-sm-6"><a href="#reg" data-toggle="tab"><h5>注册</h5></a></li>
         					</ul>
         					<!--   表格 -->
         				<div id="myTabContent" class="tab-content">
         					<!--   登陆  -->
   							<div class="tab-pane fade in active" id="login">
    							<form class="bs-example bs-example-form"  action="User/login" method="post">
      								<div class="input-group">
         								<span class="input-group-addon ">邮箱</span>
         								<input type="text" class="form-control" placeholder="twitterhandle" name="duser.email">
      								</div>
      							<br>

      							<div class="input-group">
         							<input type="password" class="form-control" name="duser.password">
         							<span class="input-group-addon">密码</span>
      							</div>
      							<br>
      							<div class="input-group">
         						    <input type="submit" class="form-control" value="登录" />
      							</div>
  								</form>
  							</div>
  							<!-- 注册 -->
   							<div class="tab-pane fade " id="reg">
   								<form class="bs-example bs-example-form" role="form" method="post" action="User/reg">
      								<div class="input-group">
         								<span class="input-group-addon">邮箱地址</span>
         								<input type="text" class="form-control" placeholder="twitterhandle" name="duser.email">
      								</div>
      							<br>

      							<div class="input-group">
      							<span class="input-group-addon">昵称</span>
         							<input type="text" class="form-control" name="duser.nickname">
         							
      							</div>
      							<br>
      							<div class="input-group">
         							<span class="input-group-addon">密码</span>
         							<input type="password" class="form-control" name="duser.password">
         							
      							</div>
      							<br>
      							<div class="input-group">
         							<span class="input-group-addon">确认密码</span>
         							<input type="password" class="form-control">
      							</div>
      							<br>
      							<div class="input-group">
         							
         							<input type="text" class="form-control" id="validateText">
         							<span class="input-group-addon" id="validat" style="color:black;backgroud:gray;padding:0 20px 0 20px;"></span>
      							</div>
      							<br>
      							<div class="input-group">
         							
         							<input type="submit" class="form-control" id="regbt">
         							<input type="reset" class="form-control">
      							</div>
      							<br>
  								</form>
      						</div> 					                              
         				</div>
         				
         			</div>
         		  </div>
         		</div>
         		</div>
         		
         		<!--  -->
         
		<script src="js/jquery-2.2.3.min.js"></script>
   	 	<script src="js/bootstrap.min.js"></script>
   	 	<script type="text/javascript">  
	//alert("d");
	//$("#loginOut").css("color","blue");
	//
	$("#validat").click(function(){
	//alert("dd");
	var url ="User/validat";
	var data = "";
	$.ajax({
	type:"get",
	async:true,
	url:url,
	data:data,
	dataType:'json',
	success:function(data){
	//alert("dd");
	$("#validat").html(data);
	},
	error:function(){
	alert("error");
	}
	});
	
	});
	//登出：ajax实现局部刷新
	
	$("#regbt").click(function(){
	
	
	if($("#validateText").val()==$("#validat").text())
	{
	alert("ol");
	}
	else{alert("dd");}
	});
	
	
	</script>
	</body>
</html>

