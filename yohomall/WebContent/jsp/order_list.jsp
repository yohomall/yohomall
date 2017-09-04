<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
							<td>地址</td>
							<td>收货人</td>
							<td>电话</td>
							<td>总额</td>
							<td>时间</td>
							<td>状态</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${order}" var="o">
						<tr>
							<th id="oid">${o.oid}</th> 
							<th id="addr">${o.addr}</th>
							<th id="aname">${o.aname}</th>
							<th id="phone">${o.phone}</th>
							<th id="total">${o.total}</th>
							<th id="time">${o.time}</th>
							<th id="status">${o.status}</th>
							<th><a href="${pageContext.request.contextPath }/detail.action?oid=${o.oid}">订单详细</a></th>
						</tr>
						</c:forEach>
					</table>
				</form>
			</div>
	</body>

</html>