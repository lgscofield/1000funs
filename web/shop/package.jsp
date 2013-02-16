<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
						<div class="span3">
							<a class="btn" href="#dialog-add-category" data-toggle="modal"><i class="icon-plus"></i>添加分类</a>
							<a class="btn" href="#dialog-add-package" data-toggle="modal"><i class="icon-plus"></i>添加套餐</a>
						</div>
					</div>
				</div>
				<div class="category">
					<ul>
						<c:forEach items="${packageMaps}" var="packageMap">
						<li>
							<label class="checkbox"><input type="checkbox">${packageMap.key}</label>
						</li>
						</c:forEach>
					</ul>
				</div>
				<table class="foods-area">
					 <c:forEach items="${packageMaps}" var="packageMap">
					 <tr>
						<td class="food-area-head">${packageMap.key}</td>
						<td>
							<ul class="food-area-list">
								<c:forEach items="${packageMap.value}" var="packageVO">
								<li><img src="${webRoot}/${packageVO.image}" alt="${packageVO.packageName}"></li>
								</c:forEach>
								<li><img src="${webRoot}/web/img/plus.png" class="food-add" alt=""></li>
							</ul>
						</td>
					 </tr>
					 </c:forEach>
				</table>
			
			</div>
		</div><!--/ end of container -->

		<!-- 添加分类窗口 -->
		<div id="dialog-add-category" class="modal hide fade">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h3>添加分类</h3>
			</div>
			<div class="modal-body">
				<form action="" class="form-horizontal">
					<div class="control-group">
						<label for="category" class="control-label">分类</label>
						<div class="controls">
							<input id="category" type="text" style="width:178px;">
						</div>
					</div>
					<div class="control-group">
						<label for="price" class="control-label">价格</label>
						<!-- <div class="controls">
							<input id="category" type="text">
						</div> -->
						<div class="controls">
							<div class="input-prepend input-append">
								<span class="add-on">&yen;</span>
								<input id="price" type="text" class="span2">
								<span class="add-on">元</span>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn btn-primary">保存</a>
				<a href="#" class="btn" data-dismiss="modal" aria-hidden="true">关闭</a>
			</div>
		</div><!--/ end of 添加分类 -->

		<!-- 添加套餐窗口 -->
		<div id="dialog-add-package" class="modal hide fade">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h3>添加套餐</h3>
			</div>
			<div class="modal-body">

				<!-- Step 1 -->
				<form action="" class="form-horizontal addfood-form" id="form-add-package-step1">
					<div class="control-group">
						<div class="control-label">
							<img src="${webRoot}/web/img/taochan3.jpg" class="addfood-photo img-rounded" id="addfood-photo" alt="">
							<div class="img-tips hide" id="addfood-photo-tips">点击上传图片</div>
						</div>
						<div class="controls controls-addfood">
							<div class="control-group control-group-small">
								<label for="" class="control-label">名称</label>
								<div class="controls"><input type="text"></div>
							</div>
							<div class="control-group control-group-small">
								<label for="" class="control-label">分类</label>
								<div class="controls">
									<select name="" id="">
										<option value="">25元区</option>
										<option value="">20元区</option>
										<option value="">18元区</option>
										<option value="">15元区</option>
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
				</form><!--/ end of Step 1 -->

				<!-- step 2 -->
				<form action="" class="form-horizontal hide" id="form-add-package-step2">
					<table class="foods-area add-package">
						<tr>
							<td class="food-area-head">25元区</td>
							<td>
								<ul class="food-area-list">
									<li>
										<label>
											<img src="${webRoot}/web/img/taochan2.jpg" alt="">
											<input type="checkbox" value=""/>
										</label>
									</li>
									<li>
										<label>
											<img src="${webRoot}/web/img/taochan2.jpg" alt="">
											<input type="checkbox" value=""/>
										</label>
									</li>
									<li>
										<label>
											<img src="${webRoot}/web/img/taochan2.jpg" alt="">
											<input type="checkbox" value=""/>
										</label>
									</li>
									<li>
										<label>
											<img src="${webRoot}/web/img/taochan2.jpg" alt="">
											<input type="checkbox" value=""/>
										</label>
									</li>
									<li>
										<label>
											<img src="${webRoot}/web/img/taochan2.jpg" alt="">
											<input type="checkbox" value=""/>
										</label>
									</li>
									<li>
										<label>
											<img src="${webRoot}/web/img/taochan2.jpg" alt="">
											<input type="checkbox" value=""/>
										</label>
									</li>
									<li>
										<label>
											<img src="${webRoot}/web/img/taochan2.jpg" alt="">
											<input type="checkbox" value=""/>
										</label>
									</li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="food-area-head">20元区</td>
							<td>
								<ul class="food-area-list">
									<li>
										<label>
											<img src="${webRoot}/web/img/taochan1.jpg" alt="">
											<input type="checkbox" value=""/>
										</label>
									</li>
									<li>
										<label>
											<img src="${webRoot}/web/img/taochan1.jpg" alt="">
											<input type="checkbox" value=""/>
										</label>
									</li>
									<li>
										<label>
											<img src="${webRoot}/web/img/taochan1.jpg" alt="">
											<input type="checkbox" value=""/>
										</label>
									</li>
									<li>
										<label>
											<img src="${webRoot}/web/img/taochan1.jpg" alt="">
											<input type="checkbox" value=""/>
										</label>
									</li>
								</ul>
							</td>
						</tr>
						<tr>
							<td class="food-area-head">18元区</td>
							<td>
								<ul class="food-area-list">
									<li>
										<label>
											<img src="${webRoot}/web/img/taochan3.jpg" alt="">
											<input type="checkbox" value=""/>
										</label>
									</li>
									<li>
										<label>
											<img src="${webRoot}/web/img/taochan3.jpg" alt="">
											<input type="checkbox" value=""/>
										</label>
									</li>
									<li>
										<label>
											<img src="${webRoot}/web/img/taochan3.jpg" alt="">
											<input type="checkbox" value=""/>
										</label>
									</li>
								</ul>
							</td>
						</tr>
					</table>

					
				</form><!--/ end of Step 2 -->

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


		<script type="text/javascript" src="${webRoot}/web/js/jquery-1.8.0.js"></script>
		<script type="text/javascript" src="${webRoot}/web/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${webRoot}/web/js/jquery.pagination.js"></script>
		<script type="text/javascript">

			jQuery(function ($) {

				$("#page").pagination({
					class: "pagination-right", 
					page: 1, 
					count: 10, 
					callback: function (current_page, new_page) {
					}, 
					refresh: false
				});

				$(".foods-area .food-add").click(function () {
					$("#dialog-add-package").modal();
				});

				$("#addfood-photo").hover(function () {
					$("#addfood-photo-tips").removeClass("hide");
				}, function () {
					$("#addfood-photo-tips").addClass("hide");
				});


				// 添加套餐,保存&下一步
				$("#btn_done").click(function() {
					var $this = $(this), 
						$prev = $("#btn_prev");
					if($this.hasClass("next")) { // next
						$this.html("保存").removeClass("next");
						$prev.removeClass("hide");

						$("#form-add-package-step1").addClass("hide");
						$("#form-add-package-step2").removeClass("hide");
						$("#dialog-add-package").addClass("dialog-select-food");
						$("#modal-footer-food-select").removeClass("hide");
						
					}
				});

				// 上一步
				$("#btn_prev").click(function() {
					var $next = $("#btn_done");
					$next.html("下一步").addClass("next");
					$(this).addClass("hide");

					$("#form-add-package-step2").addClass("hide");
					$("#form-add-package-step1").removeClass("hide");
					$("#dialog-add-package").removeClass("dialog-select-food");
					$("#modal-footer-food-select").addClass("hide");
				});

			});

		</script>
	</body>
</html>