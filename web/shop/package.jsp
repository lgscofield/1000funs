<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
						<div class="span6">
						</div>
						<div class="span3">
						</div>
						<div class="span3 btn-right">
							<a class="btn" href="#dialog-add-package" data-toggle="modal"><i class="icon-plus"></i>添加套餐</a>
						</div>
					</div>
				</div>
				<div class="category">
					<ul>
						<c:forEach items="${packageMaps}" var="packageMap" varStatus="status">
						<li>
							<label class="checkbox"><input type="checkbox" idx="${status.count }" <c:if test="${fn:length(packageMap.value) > 0}">checked</c:if>
							>${packageMap.key}</label>
						</li>
						</c:forEach>
					</ul>
				</div>
				<table class="foods-area">
					 <c:forEach items="${packageMaps}" var="packageMap" varStatus="status">
					 <tr id="tr_${status.count }" class="<c:if test="${fn:length(packageMap.value) == 0}">hide</c:if>">
						<td class="food-area-head">${packageMap.key}</td>
						<td>
							<ul class="food-area-list">
								<c:forEach items="${packageMap.value}" var="packageVO">
								<li><img src="${webRoot}/${packageVO.image}" alt="${packageVO.foodName}"></li>
								</c:forEach>
								<li><img src="${webRoot}/web/img/plus.png" class="food-add" alt=""></li>
							</ul>
						</td>
					 </tr>
					 </c:forEach>
				</table>
			
			</div>
		</div><!--/ end of container -->


		<!-- 添加套餐窗口 -->
		<div id="dialog-add-package" class="modal hide fade">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h3>添加套餐</h3>
			</div>
			<div class="modal-body">

				<!-- Step 1 -->
				<form id="packageForm" action="" class="form-horizontal form-dialog">
					<div id="step1">
						<div class="control-group">
							<div class="control-label">
								<div class="addfood-photo-wrapper"><img src="${webRoot}/web/img/taochan3.jpg" class="addfood-photo img-rounded" alt=""></div>
								<div class="img-tips hide">点击上传图片</div>
								<input type="file" name="file" class="hide">
							</div>
							<div class="controls controls-clear-right">
								<div class="control-group control-group-small">
									<label for="" class="control-label">名称</label>
									<div class="controls"><input type="text"></div>
								</div>
								<div class="control-group control-group-small">
									<label for="" class="control-label">分类</label>
									<div class="controls">
										<select name="" id="">
											<c:forEach items="${packageMaps}" var="packageMap" varStatus="status">
											<option value="">${packageMap.key }</option>
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

					</div><!--/ end of Step 1 -->

					<!-- step 2 -->
					<table class="foods-area add-package hide" id="step2">
						<c:forEach items="${foodMaps}" var="foodMap" varStatus="status">
						<tr>
							<td class="food-area-head">${foodMap.key }</td>
							<td>
								<ul class="food-area-list">
									<c:forEach items="${foodMap.value }" var="food">
									<li>
										<label>
											<img src="${webRoot}/${food.image}" alt="${food.foodName }">
											<input type="checkbox" value=""/>
										</label>
									</li>
									</c:forEach>
								</ul>
							</td>
						</tr>
						</c:forEach>
					</table><!--/ end of Step 2 -->

				</form>

			</div>
			<div class="modal-footer">

				<div class="control-group control-group-small control-group-left add-package hide" id="modal-footer-food-select">
					<label for="" class="control-label">已添加</label>
					<div class="controls food-to-add">
						<ul class="food-area-list">
							<li><img src="${webRoot}/web/img/mifan.jpg" alt=""></li>
							<li><img src="${webRoot}/web/img/chaixin.jpg" alt=""></li>
						</ul>
					</div>
				</div>

				<a href="#" class="btn hide" id="btn_prev" aria-hidden="true">上一步</a>
				<a href="#" class="btn btn-primary next" id="btn_done">下一步</a>
			</div>
		</div><!--/ end of 添加食物 -->

		<script src="${webRoot}/web/seajs/sea.js" data-config="${webRoot}/web/js/config" data-main="${webRoot}/web/js/shop.package"></script>
		
	</body>
</html>