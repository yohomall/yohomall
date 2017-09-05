<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
	
	</HEAD>
	<body>
	
 <br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="80%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>用户列表</strong>
						</TD>
					</tr>
					<tr>
						
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 40px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%" >
										序号
									</td>
									<td align="center" width="17%" >
										用户邮箱
									</td>
									<td align="center" width="17%">
										真实姓名
									</td>
									<td align="center" width="17%" >
										性别
									</td>
									<td align="center" width="17%" >
										昵称
									</td>
								
									
								</tr>
									<!-- <s:iterator var="u" value="pageBean.list" status="status"> -->
									<c:forEach items="${page.data }" var="p" varStatus="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';" height="40px">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												${status.index + 1 }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.email }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.uname }
											</td>
												<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.sex }
											</td>
												<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.nickname }
											</td>
											<%--<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/userAdmin_edit.action?uid=${user.uid}">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
											 <td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/userAdmin_delete.action?uid=${user.uid}">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td> --%>
										</tr>
									<!-- </s:iterator> -->	
									</c:forEach>
							</table>
						</td>
					</tr>
					<tr align="center">
						<td colspan="7">
							
							<!-- 判断是否是第一页 -->
						<c:if test="${page.pageNum == 1 }">
							<a href="javascript:void(0);"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a>
						</c:if>

						<!-- 不是第一页 -->
						<c:if test="${page.pageNum != 1 }">
							<a
								href="${pageContext.request.contextPath}/admin.action?&pageNum=${page.pageNum-1 }"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a>
						</c:if>
						
						<!-- 展示所有页码 -->
						<c:forEach begin="1" end="${page.totalPage }" var="n">
							
							<!-- 判断是否是当前页 -->
							<c:if test="${page.pageNum == n }">
								<a href="javascript:void(0);" style="font-size: medium;">${n }</a>
							</c:if>
							<c:if test="${page.pageNum != n }">
								<a
									href="${pageContext.request.contextPath}/admin.action?&pageNum=${n}" style="font-size: medium;">${n }</a>
							</c:if>
						</c:forEach>
						
						<!-- 判断是否是最后一页 -->
						<c:if test="${page.pageNum == page.totalPage }">
							<a href="javascript:void(0);"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a>
						</c:if>
						
						<c:if test="${page.pageNum != page.totalPage }">
							<a
								href="${pageContext.request.contextPath}/admin.action?&pageNum=${page.pageNum+1 }"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a>
						</c:if>
						<span style="font-size: medium; float: right;">当前页：${page.pageNum }</span>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

