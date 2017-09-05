<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
	<head></head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>用户信息</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

<style>
  body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
 .container .row div{ 
	 /* position:relative;
	 float:left; */
 }
 
font {
    color: #3164af;
    font-size: 18px;
    font-weight: normal;
    padding: 0 10px;
}
 </style>
</head>
<script type="text/javascript">
	$(function(){
		$('button').on('click',function(){
			location.href="${pageContext.request.contextPath }/editUI.action";
		});
	});
</script>
<body>
<%@ include file="/jsp/head.jsp" %>

<div class="container" style="width:100%;background:url('${pageContext.request.contextPath}/image/regist_bg.jpg');">
<div class="row"> 

	<div class="col-md-2"></div>
	
	


	<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<font>我的信息</font>
		 <form class="form-horizontal" style="margin-top:5px;" method="post" action="${pageContext.request.contextPath }/edit.action">
		<input type="hidden" name="uid" value="${user.uid }">
			 <div class="form-group">
			    <label for="username" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="uname"  name="uname" value="${user.uname }">
			    </div>
			  </div>
			    <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">性别</label>
			    <div class="col-sm-6">
			    	 <input type="text" class="form-control" id="sex"  name="sex" value="${user.sex }">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">生日</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="birthday"  name="birthday" value="<fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd"/>">
			    </div>
			  </div>
			 <div class="form-group">
			    <label for="usercaption" class="col-sm-2 control-label">昵称</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="nickname" name="nickname" value="${user.nickname }">
			    </div>
			  </div>
			 <!--  <div class="form-group opt">  
			  <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>  
			  <div class="col-sm-6">
			    <label class="radio-inline">
			  <input type="radio" name="sex" id="inlineRadio1" value="1"> 男
			</label>
			<label class="radio-inline">
			  <input type="radio" name="sex" id="inlineRadio2" value="0"> 女
			</label>
			</div>
			  </div>		
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">出生日期</label>
			    <div class="col-sm-6">
			      <input type="date" class="form-control"  name="birthday">		      
			    </div>
			  </div> -->
			  
			<%--   <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">验证码</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control"  >
			      
			    </div>
			    <div class="col-sm-2">
			    <img src="${pageContext.request.contextPath}/image/captcha.jhtml"/>
			    </div>
			    
			  </div> --%>
			 
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input type="submit"  width="100" value="保存" name="submit" border="0"
				    style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
			    </div>
			  </div>
			 </form>
	</div>
	
<div class="col-md-2"></div>
</div>
</div>

	  
	
	<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath}/image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			
		</div>

</body></html>




