<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/web/inc/header.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<title>注册页面</title>
		<link rel="stylesheet" href="${webRoot}/web/bootstrap/css/bootstrap.min.css">
		<script type="text/javascript" src="${webRoot}/web/js/jquery-1.8.0.js"></script>
		<script type="text/javascript" src="${webRoot}/web/bootstrap/js/bootstrap.min.js"></script>
		<style type="text/css">
			
			body {
				font-family: "Microsoft Yahei", SimSun, Tahoma, Helvetica, Arial, sans-serif;
				padding: 40px 0px;
				background-color: #f5f5f5;
			}
			
			.form-sign {
			  max-width: 300px;
			  background: #fff;
			  margin: 0 auto 20px;
			  padding: 19px 29px 29px;
			  border: 1px solid #e5e5e5;
			  -webkit-border-radius: 5px;
			  -moz-border-radius: 5px;
			  border-radius: 5px;
			  -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
			  -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
			  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
			}
			
		</style>
		<script type="text/javascript">
		</script>
	</head>
	<body>
		<div style="text-align: center;margin-bottom: 50px;"><h1>订单已提交成功，注册可享受更多优惠！</h1></div>
		<div class="container">
			<form class="form-sign">
			  <fieldset>
			    <legend><h2>免费注册</h2></legend>
			    <label>用户名</label>
			    <input type="text" class="input-block-level">
				<label>密码</label>
			    <input type="text" class="input-block-level">
			    <label>确认密码</label>
			    <input type="text" class="input-block-level">
			    <label>电子邮箱</label>
			    <input type="text" class="input-block-level">
			    <label class="checkbox">
      				<input type="checkbox"> 我同意使用<a href="#">条款和协议</a>
      				<button type="submit" class="btn btn-primary btn-large btn-login" style="float: right;">提交</button>
    			</label>
			  </fieldset>
			</form>
		</div>
	</body>
</html>