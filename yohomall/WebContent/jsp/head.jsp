<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<div class="container-fluid">
				<div class="col-md-4">
					<%-- <img src="${pageContext.request.contextPath}/img/logo2.png" /> --%>
				</div>
				<div class="col-md-5">
					<img src="${pageContext.request.contextPath}/img/header.png" />
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						
						<c:if test="${empty user }">
							<li><a href="${pageContext.request.contextPath }/loginUI.action">登录</a></li>
							<li><a href="${pageContext.request.contextPath }/registerUI.action">注册</a></li>
						</c:if>
						<c:if test="${not empty user }">
							姓名：${user.uname } 欢迎你
							<li><a href="${pageContext.request.contextPath }/showUI.action?uid=${user.uid}">我的信息</a></li>

							<li><a href="${pageContext.request.contextPath }/MyOrders.action?pageNum=1">我的订单</a></li>

							<li><a href="${pageContext.request.contextPath }/loginOut.action">退出</a></li>
						</c:if>
						

						<li><a href="${pageContext.request.contextPath }/jsp/cart.jsp">购物车</a></li>	
					</ol>
				</div>
			</div>
				
	
			<!--
            	时间：2015-12-30
            	描述：导航条
            -->
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="${pageContext.request.contextPath }/index.action">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav" id="c_ul">
							</ul>
							<form class="navbar-form navbar-right" role="search">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Search">
								</div>
								<button type="submit" class="btn btn-default">Submit</button>
							</form>

						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>
<script type="text/javascript">
	      $(function(){
		$.post("${pageContext.request.contextPath}/category.action",function(obj){
			 $(obj).each(function(){
				  $("#c_ul").append("<li><a href='${pageContext.request.contextPath}/product.action?pageNum=1&tid="+this.tid+"'>"+this.type+"</a></li>");  
			}); 
		},"json");
	});   
	
	
	
	
</script>
