<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
	   ul,li{list-style: none;}
		.trans{padding:18px;border: 1px solid darkgray;height: 140px;background:#FCFCFC;margin-bottom:60px}
		.trans ul li{float: left;margin-right: 20px;}
		.trans ul li.price{width:30px}
		 
		ul li input[type=number]{width:60px;padding: 0;margin: 0;}
		
		
	</style>
	</head>
  <link rel="stylesheet" href="css/bootstrap.css">
  <body>
  <div>
	<div class="div">
		 <jsp:include page="header.jsp"></jsp:include>
		
	</div>
  </div>

<div id="load" style="border-radius:13px;background:gray;display:none;position:absolute;left:50%;top:50%">请稍等呢...</div>
  <div id="duyiwuer">
    <s:iterator value="itlist" var="itlist" status='st'> 
    <div class="row">         
		<div class="trans">
			<i class="sr-only"><s:property value="#session.user.id"/></i>
		<ul>
			<li><input type="checkbox" name="" id="" value="" /></li>
			<li><a href="BookDetial/bookdisplay?id=<s:property value="id"/>" class="thumbnail" style="width:100px;height:100px;overflow:hidden">
    			<img src="img/<s:property value='DProduct.productPic'/>" height="100" />	
    			</a>
			</li>
			<li>
			<span></span>
			<span class="sr-only"><s:property value="DProduct.id"/></span> 
			<p><s:property value='DProduct.description'/></p></li>
			<li><p class="text-muted"><s:property value='productName'/></p></li>
			<li class="price">
				<del><s:property value='DProduct.fixedPrice'/></del>
				<span id="">
					<s:property value='dangPrice'/>
				</span>
			</li>
			<li><input type="number" name="" min="1" max="10" /></li>
			<li><p class="text-danger"></p></li>
			<li><a href="Shop/shoptransremove?dcartItem.UserId=<s:property value="#session.user.id"/>&dcartItem.ProId=<s:property value="DProduct.id" />">移除购物车</a></li>
		</ul>
		</div>
		</div>	
</s:iterator>
<div style="height:50px;width:100px;background:orange;position:fixed;right:0;bottom:50px"id="dujia">0</div>
</div>
<input type="submit" value="提交订单" />
<a href = "Shop/orderop?userid=<s:property value="#session.user.id"/>">提交订单</a>

 <script src="js/jquery-2.2.3.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript">
  //alert("d----------d");
    function loaddd(){
    load.style.display="block";
    }
	var Oninput = $("input:checkbox");
	var Onshop = document.getElementById("shop");
	var Ondiv= document.getElementsByTagName("div");
	/*var Onnumber =document.getElementsByTagName("input");
	alert(Onnumber.length);
	alert(Onnumber[2].type);
	var Onnum = [];
	for(var i=0;i<Onnumber.length;i++)
	{
	if(Onnumber[i].type=="number"){
	alert("YEs");
	Onnum[i]=Onnumber[i];
	}
	else{
	}
	}
	alert("天使"+Onnum[3].type);
	//判断 check是否选中
	/*for(var i=0;i<Onnumber.length;i++)
	{
	Onnumber[i].index=i;
	Onnumber[i].onclick=function(){
	alert("d");
	if(Oninput[this.index].checked==true)
	{
	alert(Onnumber[this.index].value);
	
	}
	
	}
	
	
	}*/
	
	
	
	//var p= $(".row");
	for(var i=0;i<Oninput.length;i++)
	{   //Ondiv[i].index=i;
		Oninput[i].index= i;
		Oninput[i].onclick=function()
		{	
		if(Oninput[this.index].checked==true)	
		{   
			var row =$("#duyiwuer .row");
			var span = row[this.index].getElementsByTagName("span");
			var init = row[this.index].getElementsByTagName("input");
			var ii = row[this.index].getElementsByTagName("i");
			var num = init[1].value;
			var dprid=span[1].innerText;
			var userid=ii[0].innerText;
			//alert( "书号"+dprid+"数量"+num+"用户id"+userid);
			var url ="Shop/itemselect";
	        var data = {"userid":userid,"num":num,"dprid":dprid};
	        //ajax
	$.ajax({
	type:"get",
	async:true,
	url:url,
	data:data,
	dataType:'text',
	beforeSend:function(){
	loaddd();
	},
	//dataType:'json',
	success:function(data){
	//alert("dd");
	//$("#validat").html(data);
	load.style.display="none";
	dujia.innerText=data;
	},
	error:function(){
	alert("error");
	
	}
	});
	
	
		}
		else
		{
			
				var row =$("#duyiwuer .row");
			var span = row[this.index].getElementsByTagName("span");
			var init = row[this.index].getElementsByTagName("input");
			var ii = row[this.index].getElementsByTagName("i");
			var num = 0;
			var dprid=span[1].innerText;
			var userid=ii[0].innerText;
			//alert( "书号"+dprid+"数量"+num+"用户id"+userid);
			var url ="Shop/itemselect";
	        var data = {"userid":userid,"num":num,"dprid":dprid};
	        //ajax
	$.ajax({
	type:"get",
	async:true,
	url:url,
	data:data,
	//dataType:'json',
	beforeSend:function(){
	loaddd();
	},
	success:function(data){
	load.style.display="none";
	//$("#validat").html(data);
	dujia.innerText=data;
	},
	error:function(){
	alert("error");
	}
	});	
			
		}
		}
	}
	
</script>
  </body>
</html>
