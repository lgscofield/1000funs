<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/web/inc/header.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>店铺管理主页</title>
		<link rel="stylesheet" href="${webRoot}/web/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${webRoot}/web/bootstrap/css/bootstrap-responsive.min.css">
		<link rel="stylesheet" href="${webRoot}/web/css/usercenter.css">
		<style type="text/css">
			body {
				padding: 50px 0px 0px;
				/*background-color: #f5f5f5;*/
			}
		</style>
	</head>
	<body>
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container-fluid">

					<ul class="nav pull-right">
						<li>
							<a href="#">
								<i class="icon-bell"></i> 待评价订单(<span class="red">20</span>)
							</a>
						</li>
						<li id="userBar">
							<a href="#"><i class="icon-user"></i> ksfifa</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	<div class="container usercenter-main">
		<div class="container-fluid ">
			<div class="row-fluid">
				<div class="span2">
					<div class="side-profile">
						<a href="/space/c/account/avatar" id="avatar-box">
							<img class="avatar" src="xiopei.jpg" alt="" >
						</a>
						<h2>
						<a href="#">柯尚福</a>
						</h2>
					</div>
				
					<hr/>
					
					<ul class="nav nav-tabs nav-stacked">
					  <li class="active">
					    <a href="#">我的订单</a>
					  </li>
					  <li><a href="#">个人信息</a></li>
					  <li><a href="#">评价管理</a></li>
					</ul>

					
					
				</div>
				<div class="span10 usercenter-content">
					<div class="btn-group">
					  <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
					    Action
					    <span class="caret"></span>
					  </a>
					  <ul class="dropdown-menu">
					    <!-- dropdown menu links -->
					  </ul>
					</div>
				
				</div>
			</div>
		</div>
		</div>

		<script src="${webRoot}/web/seajs/sea.js" data-config="${webRoot}/web/js/config" data-main="${webRoot}/web/js/shop.index"></script>
	</body>
</html>