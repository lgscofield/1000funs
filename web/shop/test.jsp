<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/web/inc/header.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>test</title>
		<link rel="stylesheet" href="${webRoot}/web/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${webRoot}/web/bootstrap/css/bootstrap-responsive.min.css">
		<link rel="stylesheet" href="${webRoot}/web/css/order.css">
	</head>
	<body>
	    <div class="alert hide" id="msg">
		    <div id="msg-content"><strong>Warning!</strong> Best check yo self, you're not looking too good.</div>
	    </div>
	    
		<p>Test Spring MVC HttpMessageConverter(json)<input type="button" value="get json" class="btn" id="get-json"/> </p>
		<p>Test Spring MVC HttpMessageConverter(json) query2<input type="button" value="get json" class="btn" id="get-json2"/> </p>
		
		<script type="text/javascript" src="${webRoot}/web/js/jquery-1.8.0.js"></script>
		<script type="text/javascript" src="${webRoot}/web/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			jQuery(function($) {
				$("#get-json").click(function() {
					/*
					$.get("${webRoot}/shop/query/group/1.ac", function(data) {
						showSuccess("<strong>Well done!</strong> data: " + data);
					}, "json")
					.fail(function(e) {
						showError("<strong>Error!</strong> " + e);
					});
					*/

					$.ajax({
						url: "${webRoot}/shop/query/group/1.ac",
						beforeSend: function(req) {
							req.setRequestHeader("Accept", "application/json");
						}, 
						success: function(json) {
							showSuccess("<strong>Well done!</strong> json: " + json);
						}, 
						error: function(xhr) {
							showError("<strong>Error!</strong> " + xhr.responseText);
						}
					});
					
				});

				$("#get-json2").click(function() {
					$.get("${webRoot}/shop/query2/group/1.ac", function(data) {
						showSuccess("<strong>Well done!</strong> data: " + data);
					}, "json")
					.fail(function(e) {
						showError("<strong>Error!</strong> " + e);
					});
				});


				//showSuccess("<strong>Well done!</strong> You successfully read this important alert message. ");
				//showError("<strong>Oh shit!</strong> It seem's something wrong. ");
			});

			function showSuccess(html) {
				showMsg(html, "alert-success");
			}

			function showError(html) {
				showMsg(html, "alert-error");
			}

			function showMsg(html, className) {
				$("#msg-content").html(html);
				$("#msg").addClass(className).removeClass("hide")
					.fadeIn(400)
					.delay(2000)
					.fadeOut(800, function() {
						$(this).removeClass(className).addClass("hide");
					});
			}
		</script>
	</body>
</html>