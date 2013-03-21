<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="/web/inc/header.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>订单管理-待处理页面</title>
		<link rel="stylesheet" href="${webRoot}/web/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${webRoot}/web/bootstrap/css/bootstrap-responsive.min.css">
		<link rel="stylesheet" href="${webRoot}/web/css/order.css">
		<style type="text/css">
			body {
				/*padding: 50px 0px;*/
				/*background-color: #f5f5f5;*/
			}
		</style>
	</head>
	<body>
		<div class="row-fluid container-fixed">
			<div class="span12">
				<div class="querybar">
					<form:form method="post" modelAttribute="queryForm" cssClass="form-search">
					<div class="row-fluid">
						<div class="span4">
							<div class="input-prepend">
								<button type="submit" class="btn"><i class="icon-search"></i></button>
								<!-- <input type="text" class="search-query search-query-width" placeholder="search" > -->
								<form:input path="keyword" cssClass="search-query search-query-width" placeholder="search"/>
							</div>
						</div>
						<div class="span4">
							<!-- <button class="btn" data-toggle="button" type="button">超过20分钟</button> -->
							超时:
							<div class="btn-group" data-toggle="buttons-radio">
								<button type="button" class="btn" value="0">无</button>
								<button type="button" class="btn" value="10">10分钟</button>
								<button type="button" class="btn" value="20">20分钟</button>
							</div>
						</div>
						<div class="span4">
							<label for="auto_checkbox" class="checkbox toggle ios pull-right">
								<span>自动出单</span>
								<input id="auto_checkbox" type="checkbox">
								<div class="toggle">
									<i></i>
								</div>
							</label>
						</div>
					</div>
					
					<form:hidden path="overtime"/>
					</form:form>
				</div>
				
				<div class="table-list">
					<ul>
						<%-- 
						<c:forEach items="${orderList}" var="order" >
						<li>
							<div class="table-item">
								<div class="row-fluid head">
									<div class="pull-left link left-panel">
										<span class="">${order.address}</span>
										<span class="forestgreen">${order.phone}</span>
									</div>
									<div class="pull-right left-panel">
										<span class="brown">${order.totalPrice}元 (共${order.totalAmount}个)</span>
										<a href="#" class="btn btn-mini order-btn-out"><i class="icon-print"></i>&nbsp;出单</a>
									</div>
								</div>
								<div class="row-fluid body">
									<div>
										<span class="order-number">订单号: ${order.id }</span>
										<span class="order-time">
											预计送达时间: ${order.exceptTime } (下单时间: ${order.createTime })
										</span>
									</div>
									<div class="food-collapse">
										<p class="food-list">
										<c:forEach items="${order.foodList}" var="food">
											<span>${food }</span>
										</c:forEach>
										</p>
									</div>
									<div class="food-expand">
										<ul class="food-list">
										<c:forEach items="${order.foodList}" var="food">
											<li>${food }</li>
										</c:forEach>
										</ul>
									</div>
								</div>
							</div>
						</li>
						</c:forEach>
						--%>
						
						<c:forEach items="${orderList}" var="order" >
						<li>
							<div class="table-item">
								<div class="row-fluid head">
									<div class="pull-left link left-panel">
										<span class="">${order.address}</span>
										<span class="forestgreen">${order.phone}</span>
									</div>
									<div class="pull-right">
										<span class="brown">${order.totalPrice}元 (共${order.totalAmount}个)</span>
										<a href="#" class="btn btn-mini order-btn-out"><i class="icon-print"></i>&nbsp;出单</a>
									</div>
								</div>
								<div class="row-fluid body">
									<div class="left-panel">
										<span class="order-number">订单号: ${order.id }</span>
										<span class="order-time">
											预计送达时间: ${order.exceptTime } (下单时间: ${order.createTime })
										</span>
									</div>
									<div class="food-collapse">
										<p class="food-list">
										<c:forEach items="${order.plateList }" var="foodList" varStatus="status">
											<span>餐盘${status.count }:</span>
											<c:forEach items="${foodList }" var="food">
											<span>${food }</span>
											</c:forEach>
										</c:forEach>
										</p>
									</div>
									<div class="food-expand">
										<ul class="plate-list">
										<c:forEach items="${order.plateList }" var="foodList">
											<li>
												<ul class="food-list">
												<c:forEach items="${foodList }" var="food">
													<li><span>x${food.amount }</span>${food.food } </li>
												</c:forEach>
												</ul>
											</li>
										</c:forEach>
										</ul>
									</div>
								</div>
							</div>
						</li>
						</c:forEach>
					</ul>
				</div>
				
				<!-- pagination -->
				<!-- <div id="page"></div> -->
			</div>
		</div>

		<script type="text/javascript" src="${webRoot}/web/js/jquery-1.8.0.js"></script>
		<script type="text/javascript" src="${webRoot}/web/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${webRoot}/web/js/jquery.pagination.js"></script>
		<script type="text/javascript" src="${webRoot}/web/js/jquery.bootstrap.extension.js"></script>
		<script type="text/javascript" src="${webRoot}/web/js/order-tablelist.js"></script>
		<script type="text/javascript">

			jQuery(function ($) {
				init();
				initEvent();
			});

			function init() {
				// button group init
				var ot = $("#overtime").val();
				$(".btn-group > button[value='"+ot+"']").addClass("active");
				
			}

			function initEvent() {
				$("#page").pagination({
					className: "pagination-right", 
					page: 1, 
					count: 10, 
					callback: function (current_page, new_page) {
					}, 
					refresh: false
				});

				$(".btn-group").buttonGroup().change(function(e) {
					$("#overtime").val(this.val());
					$("#queryForm").submit();
				});
			}

		</script>
	</body>
</html>