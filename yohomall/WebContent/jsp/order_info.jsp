<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body>

	<%@include file="/jsp/head.jsp" %>
			<div align="center">
				<form action="">
					<table border="1">
						<tr>
							<td>订单编号</td>
							<td>商品名</td>
							<td>商品数量</td>
							
						</tr>
						<c:forEach items="${item}" var="im">
						<tr>
							<th id="oid">${im.oid}</th> 
							<th id="pname">${im.product.pname}</th>
							<th id="quantity">${im.quantity}</th>
							
						</tr>
					</c:forEach>
					</table>
				</form>
			</div>

	</body>

</html>