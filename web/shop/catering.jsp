<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="/web/inc/header.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>餐点管理-配餐模式</title>
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
						<div class="span3">
						</div>
						<div class="span6">
						</div>
						<div class="span3 btn-right">
							<a class="btn" href="#dialog-add-food" data-toggle="modal"><i class="icon-plus"></i>添加食物</a>
						</div>
					</div>
				</div>
				<div class="category">
					<ul>
						<c:forEach items="${foodMaps}" var="foodMap" varStatus="status">
						<li>
							<label class="checkbox"><input type="checkbox" idx="${status.count }" <c:if test="${fn:length(foodMap.value) > 0}">checked</c:if> 
							>${foodMap.key}</label>
						</li>
						</c:forEach>
					</ul>
				</div>
				
				<table class="foods-area">
					<c:forEach items="${foodMaps}" var="foodMap" varStatus="status">
					<tr id="tr_${status.count }" class="<c:if test="${fn:length(foodMap.value) == 0}">hide</c:if>">
						<td class="food-area-head">${foodMap.key}</td>
						<td>
							<ul class="food-area-list">
								<c:forEach items="${foodMap.value }" var="food">
								<li><img src="${webRoot}/${food.image}" alt=""></li>
								</c:forEach>
								<li><img src="${webRoot}/web/img/plus.png" class="food-add" alt=""></li>
							</ul>
						</td>
					</tr>
					</c:forEach>
				</table>
				
			</div>
		</div><!--/ end of container -->


		<!-- 添加食物窗口 -->
		<div id="dialog-add-food" class="modal hide fade">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h3>添加食物</h3>
			</div>
			<div class="modal-body" style="max-height: 350px;">
				<form action="" class="form-horizontal form-dialog">

					<!-- step 1 -->
					<div id="step1" class="food-grid">
						<span class="title">请先选择食物:</span>
						<ul id="food-list" class="item-list">
							<c:forEach items="${foodList }" var="food" varStatus="status">
							<li>
								<div><img id="food_${status.index }" src="${webRoot}/${food.image}" alt="${food.foodName }" class="img-polaroid"><span>${food.foodName }</span></div>
							</li>
							</c:forEach>
						</ul>
					</div>
					<!--/ end of step 1 -->

					<!-- step 2 -->
					<div id="step2" class="hide">
						<div class="control-group">
							<div class="control-label">
								<div class="addfood-photo-wrapper"><img src="" class="addfood-photo img-rounded" id="addfood-photo" alt=""></div>
								<div class="img-tips hide">点击上传图片</div>
							</div>
							<div class="controls controls-clear-right">
								<div class="control-group control-group-small">
									<label for="" class="control-label">名称</label>
									<div class="controls"><input type="text" name=""></div>
								</div>
								<div class="control-group control-group-small">
									<label for="" class="control-label">分类</label>
									<div class="controls">
										<select name="" id="">
											<c:forEach items="${foodMaps}" var="foodMap" varStatus="status">
											<option value="">${foodMap.key }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="control-group control-group-small">
									<label for="" class="control-label">原价</label>
									<div class="controls">
										<!-- <input type="text"> -->
										<div class="input-prepend input-append">
											<span class="add-on">&yen;</span>
											<input id="price" type="text" style="width:153px;">
											<span class="add-on">元</span>
										</div>
									</div>
								</div>
								<div class="control-group control-group-small">
									<label for="" class="control-label">现价</label>
									<div class="controls">
										<!-- <input type="text"> -->
										<div class="input-prepend input-append">
											<span class="add-on">&yen;</span>
											<input id="price" type="text" style="width:153px;">
											<span class="add-on">元</span>
										</div>
									</div>
								</div>
								<div class="control-group control-group-small">
									<label for="" class="control-label">库存</label>
									<div class="controls"><input type="text"></div>
								</div>
							</div>
						</div>
						<div class="control-group control-group-mini control-group-left addfood-describe">
							<label for="" class="control-label">介绍</label>
							<div class="controls">
								<textarea name="" rows="3" ></textarea>
							</div>
						</div>
						<div class="pull-right">
							<label class="checkbox inline"><input type="checkbox" value="">缺货标记</label>
							<label class="checkbox inline"><input type="checkbox" value="">下架</label>
						</div>
					</div>
					<!--/ end of step 2 -->
					
				</form>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn hide" id="btn_prev" aria-hidden="true">上一步</a>
				<a href="#" class="btn btn-primary next" id="btn_done">下一步</a>
			</div>
		</div><!--/ end of 添加食物 -->

		
		<script src="${webRoot}/web/seajs/sea.js" data-config="${webRoot}/web/js/config" data-main="${webRoot}/web/js/shop.catering"></script>
	</body>
</html>