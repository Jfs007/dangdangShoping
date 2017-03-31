

 
 <div>
 <s:iterator value="Plist" var="plist">
 <!-- 父循环 -->
 <dl><dt style="color:Orange font-size:20px"><a href="BookDetial/seach?id=<s:property value="id"/>" style="text-decoration:none;color:Orange"><s:property value="#plist.name"/></a></dt>
 
 <s:set name="plsitcurrent" value="#plist" />
 <s:iterator value="Clist" var="clist">
 <!-- 子循环 -->
 <s:if test="#plsitcurrent.turn+1==#clist.parentId">
 <dd style="float:left;"><a href="BookDetial/seach?id=<s:property value="id"/>" style="text-decoration:none;color:#000"><s:property value="#clist.name"/>|</a></dd>
 </s:if>
 </s:iterator>

 </dl>
 </s:iterator>
  </div>
  
  
  
  
  
  <div class="panel panel-info">
   <div class="panel-heading">
      <h3 class="panel-title">面板标题</h3>
   </div>
   <div class="panel-body">
    <s:if test="#request.Prolist!=null">
  <s:iterator value="plist" var="pl">
  
    		<div class="row" style="margin-bottom:20px">
    			<div class="col-sm-3">
    			<img src="img/<s:property value='productPic'/>" class="center-block" height="180" width="130" />	
    			</div>
    			<div class="col-sm-9">
    				<h5 class="text-primary">作者：<s:property value="productName"/></h5>
    				<p class="text-muted">出版社：<span><s:property value="DBook.author"/></span>出版时间：<span><s:property value="DBook.publishing"/></span></p>
					
					<p><s:property value="description"/></p>
					<p><span>定价：￥</span><span><s:property value="fixedPrice"/></span><span> 当当价：￥</span><span><s:property value="dangPrice"/></span></p>
    			</div>
    		</div>
  
</s:iterator>
</s:if>
 <s:else>
 <div>NO==================</div>
 </s:else>
   </div>
</div>	
  
  
  
  
   
  <script src="js/jquery-2.2.3.min.js"></script>
   
		
   	 	<script src="js/bootstrap.min.js"></script>
   	 	<script type="text/javascript">  

	</script>
 

