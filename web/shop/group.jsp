<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="/web/inc/header.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>餐点管理-分类管理</title>
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
					<div class="row-fluid">
						<div class="span4">
						</div>
						<div class="span4">
						</div>
						<div class="span4 btn-right">
							<button type="button" class="btn" id="btn_delete" data-toggle="button">删除</button>
							<button type="button" class="btn" id="btn_edit" data-toggle="button">编辑</button>
							<button type="button" class="btn" id="btn_insert" data-toggle="button">新增</button>
						</div>
					</div>
				</div>
				
				<div id="groupList" class="common-list group-list">
					<ul>
						<c:forEach items="${groupList}" var="group">
						<li>
							<div class="list-item">
								<div class="pic">
									<img src="${webRoot}/${group.image }" alt="${group.groupName }">
								</div>
								<div class="btns hide">
									<i class="icon2-edit"></i>
								</div>
								<div class="text">
									<p class="header">${group.groupName }</p>
									<p class="detail">${group.detail }</p>
								</div>
							</div>
						</li>
						</c:forEach>
						
						<c:if test="${fn:length(groupList) < 1}"><!-- empty -->
						<li>
							<div class="list-item center">
								本列表暂无记录
							</div>
						</li>
						</c:if>
					</ul>
				</div><!-- /end of group list -->
				
				<div id="add_panel" class="panel-bottom hide">
					<form class="group-list" id="groupForm" name="groupForm" action="${webRoot}/shop/save/group" method="post" enctype="multipart/form-data">
						<div class="pic">
							<div class="img-wapper"><img id="image-preview" src="" data-toggle="tooltip" data-placement="right" data-original-title="图片不能为空" data-validate="imgValid();"></div>
							<div class="img-tips hide">点击上传图片</div>
							<input type="file" id="file-upload" name="file" class="hide">
						</div>
						<div class="btns">
							<button class="btn btn-primary btn-large" id="btn_save_group">保存</button>
						</div>
						<div class="text">
							<div class="control-group control-group-mini">
								<label for="" class="control-label">分类</label>
								<div class="controls"><input type="text" name="groupName" id="groupName" class="input-block-level" data-toggle="tooltip" data-original-title="分类不能为空" data-validate></div>
							</div>
							<div class="control-group control-group-mini">
								<label for="" class="control-label">描述</label>
								<div class="controls">
									<input type="text" name="detail" id="detail" class="input-block-level" data-toggle="tooltip" data-original-title="描述不能为空" data-validate>
								</div>
							</div>
						</div>
					</form>
				</div><!-- /end of add panel -->
			
			</div>
		</div><!--/ end of container -->


		<script type="text/javascript" src="${webRoot}/web/js/jquery-1.8.0.js"></script>
		<script type="text/javascript" src="${webRoot}/web/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${webRoot}/web/js/jquery.pagination.js"></script>
		<script type="text/javascript" src="${webRoot}/web/js/jquery.bootstrap.extension.js"></script>
		<script type="text/javascript" src="${webRoot}/web/js/1000funs.js"></script>
		<script type="text/javascript">

			jQuery(function ($) {

				$(".img-wapper").hover(function () {
					$(this).siblings(".img-tips").removeClass("hide");
				}, function () {
					$(this).siblings(".img-tips").addClass("hide");
				})
				.click(function() {
					$(this).siblings("input[type='file']").click();
				});
				
				imagePreview($("#file-upload"), $("#image-preview"));

				toggle("btn_insert", insertBtnClick);

				toggle("btn_edit", function (checked) {
					showRowEditBtn(checked, "icon2-edit");
				});

				toggle("btn_delete", function (checked) {
					showRowEditBtn(checked, "icon2-remove");
				});
				
				$(window).bind("resize", resetHeight);
				
				/*
				$("#btn_save_group").click(function() {
					$("#groupForm").submit();
				});
				*/
				
				$.validation().init();
				
				$("#groupForm").submit(function() {
					return $.validation().check();
				});
			});


			/**
			 * single toggle button click event
			 * @param  {string}   id       
			 * @param  {Function} callback 
			 */
			function toggle(id, callback) {
				$("#"+id).click(function () {
					var $this = $(this);
					setTimeout(function() {
						var checked = $this.hasClass("active");
						callback(checked);
					}, 0);
				});
			}

			function insertBtnClick (checked) {
				var $addPanel = $("#add_panel"), 
					$groupList = $("#groupList"), 
					winHeight = $(window).height();
				if(checked) {
					$groupList.addClass("overflow");
					$addPanel.removeClass("hide");
					adjustHeight();
				} else {
					$groupList.height(winHeight).removeClass("overflow");
					$addPanel.addClass("hide");
				}
			}

			function resetHeight () {
				var insertChecked = $("#btn_insert").hasClass("active");
				if(insertChecked) {
					adjustHeight();
				}
			}
			
			function adjustHeight() {
				$("#groupList").height($(window).height() - 200);
			}

			function showRowEditBtn(checked, className) {
				var $btns = $("#groupList .btns");
				if(checked) {
					$btns.removeClass("hide").children("i").removeClass().addClass(className);
				} else {
					$btns.addClass("hide");
				}
			}
			
			function imgValid() {
				return !!$("#file-upload").get(0).files[0];
			}
			
			/**
			 * 校验通过:true; 不通过:false;
			 */
			function check() {
				var msg = [];
				if(!$("#file-upload").get(0).files[0]) {
					msg.push("必须上传图片.");
				}
				if(!$("#groupName").val()) {
					msg.push("分类不能为空.");
				}
				if(!$("#detail").val()) {
					msg.push("描述不能为空.");
				}
				if(msg.length > 0) {
					alert(msg.join("\n"));
					return false;
				}
				return true;
			}

		</script>
	</body>
</html>