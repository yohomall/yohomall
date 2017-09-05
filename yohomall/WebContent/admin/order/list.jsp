<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
		<script language="javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
		
		<script type="text/javascript">
			function showDetail(oid){
				//alert(oid);
				//发送ajax
				$.post("${pageContext.request.contextPath}/showDetail.action",{"oid":oid},function(d){
					//alert(d);
					 var s="<table border='1' width='99%' bgcolor='#FFE4C4'>";
					s+="<tr><th>商品名称</th><th>商品图片</th><th>商品价格</th><th>购买数量</th><th>小计</th></tr>"
					
					$(d).each(function(){
						s+="<tr><td>"+this.pname+"</td><td width='60' height='40%'>"+"<img src='${pageContext.request.contextPath}/pictrue/"+this.image+"' width='70' height='60'>"+"</td><td>"+this.sellingprice+"</td><td>"+this.quantity+"</td><td>"+this.subtotal+"</td></tr>";
					});
					
					s+="</table>";
					
					layer.open({
				        type: 1,//0:信息框; 1:页面; 2:iframe层;	3:加载层;	4:tip层
				        title:"订单号:"+oid,//标题
				        area: ['520px', '300px'],//大小
				        shadeClose: true, //点击弹层外区域 遮罩关闭
				        content: s//内容
				    }); 
				},"json");
			}
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1"  method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订单列表</strong>
						</TD>
					</tr>
					
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="10%">
										序号
									</td>
									<td align="center" width="10%">
										订单编号
									</td>
									<td align="center" width="10%">
										订单金额
									</td>
									<td align="center" width="10%">
										收货人
									</td>
									<td align="center" width="10%">
										地址
									</td>
									<td align="center" width="10%">
										订单状态
									</td>
									<td align="center" width="50%">
										订单详情
									</td>
								</tr>
									<c:forEach items="${pg.data }" var="o" varStatus="vs">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												${vs.count }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${o.oid }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${o.total }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${o.aname }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${o.addr }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:if test="${o.status == 0 }">未付款</c:if>
												<c:if test="${o.status == 1 }">
													<a href="${pageContext.request.contextPath }/updateStatus.action?oid=${o.oid}">去发货</a>
												</c:if>
												<c:if test="${o.status == 2 }">待收货</c:if>
												<c:if test="${o.status == 3 }">已完成</c:if>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<input type="button" value="订单详情"  onclick="showDetail('${o.oid}')"/>
											</td>
							
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
								 <tr align="center">
								    <td colspan="7">
											<c:if test="${pg.pageNum==1 }">
												<a href="javascript:void(0);">上一页</a>
											</c:if>
											
											<c:if test="${pg.pageNum!=1 }">
												<a href="${pageContext.request.contextPath }/adminOrder.action?status=${status }&pageNum=${pg.pageNum-1}">上一页</a>
											</c:if>
												
											 <c:forEach  begin="1" step="1"  end="${pg.totalPage }" var="n">
												<c:if test="${pg.pageNum==n }">
													<a href="javascript:void(0);">${n}</a>
												</c:if>
												<c:if test="${pg.pageNum!=n }">
													<a href="${pageContext.request.contextPath }/adminOrder.action?status=${status }&pageNum=${n}">${n }</a>
												</c:if>
											
											</c:forEach> 
										
											<c:if test="${pg.pageNum==pg.totalPage }">
												<a href="javascript:void(0);">下一页</a>
											</c:if>
										
											<c:if test="${pg.pageNum!=pg.totalPage }">
												<a href="${pageContext.request.contextPath }/adminOrder.action?status=${status }&pageNum=${pg.pageNum+1}">下一页</a>
											</c:if>
											<span>共${pg.totalPage }页</span>
											到<input id="p" type="text" maxlength="4" style="width:30px">页<input type="button" value="确定" onclick="search()">
										</td>
									</tr>     
				</TBODY>
				
			</table>
			
		</form>
			
	</body>
	<script type="text/javascript">
				function search(){
					var page=document.getElementById("p").value;
					if (page!=null && page!=''&& page!=0 ) {
						location.href="${pageContext.request.contextPath }/adminOrder.action?status=${status }&pageNum="+page;
					}
				}
			</script>
</HTML>

