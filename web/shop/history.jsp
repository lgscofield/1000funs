<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/web/inc/header.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>订单管理-已处理页面</title>
		<link rel="stylesheet" href="${webRoot}/web/bootstrap/css/bootstrap.min.css">
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
					<div class="row-fluid">
						<div class="span4">
							<form action="" class="form-search">
								<div class="input-prepend">
									<button type="submit" class="btn"><i class="icon-search"></i></button>
									<input type="text" class="search-query search-query-width" placeholder="search" >
								</div>
							</form>
						</div>
						<div class="span4">
							<div class="btn-group" data-toggle="buttons-radio">
								<button type="button" class="btn active">全部</button>
								<button type="button" class="btn ">正常</button>
								<button type="button" class="btn ">异常</button>
							</div>
						</div>
						<div class="span4">
						</div>
					</div>
				</div>
				
				<div class="table-list">
					<ul>
						<c:forEach items="${orderList}" var="order" >
						<li>
							<div class="table-item <c:if test="${order.orderStatus == 2 }">abnormal</c:if>">
								<div class="row-fluid head">
									<div class="pull-left link left-panel">
										<span class="">${order.address }</span>
										<span class="forestgreen">${order.phone }</span>
									</div>
									<div class="pull-right">
										<span class="brown">${order.totalPrice }元 (共${order.totalAmount }个)</span>
										<a href="#" class="btn btn-mini order-btn-abnormal"><i class="icon-warning-sign"></i>&nbsp;异常</a>
									</div>
								</div>
								<div class="row-fluid body">
									<div>
										<span class="order-number">订单号: ${order.id }</span>
										<span class="order-time">
											下单时间: ${order.createTime }
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
					</ul>
				</div>
				
				<div class="table-list-comment">
					<span class="red">红色</span>表示此订单为异常的订单。
				</div>
				<!-- pagination -->
				<div id="page"></div>
			</div>
		</div>

		<script type="text/javascript" src="${webRoot}/web/js/jquery-1.8.0.js"></script>
		<script type="text/javascript" src="${webRoot}/web/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${webRoot}/web/js/jquery.pagination.js"></script>
		<script type="text/javascript" src="${webRoot}/web/js/order-tablelist.js"></script>
		<script type="text/javascript">

			jQuery(function ($) {

				$("#page").pagination({
					className: "pagination-right", 
					page: 1, 
					count: 10, 
					callback: function (current_page, new_page) {
					}, 
					refresh: false
				});

			});

		</script>
	</body>
</html>