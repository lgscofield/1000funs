<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/web/inc/header.jsp" %>
<!DOCTYPE html>
<html>
	<head>	
		<title>首页</title>
		<link rel="stylesheet" href="${webRoot}/web/bootstrap/css/bootstrap.min.css">
		<script type="text/javascript" src="${webRoot}/web/js/jquery-1.8.0.js"></script>
		<script type="text/javascript" src="${webRoot}/web/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${webRoot}/dwr/engine.js"></script>
		<script type="text/javascript" src="${webRoot}/dwr/interface/AddressAction.js"></script>
		<style type="text/css">
			body{
				background: url("${webRoot}/web/client/img/bg.jpg") no-repeat;
				font-family: "Microsoft Yahei", SimSun, Tahoma, Helvetica, Arial, sans-serif;
			}
			
			.logo{
				background: url("${webRoot}/web/client/img/logo.png") center bottom no-repeat;
				height: 150px;
			}
			
			.center{
				position: relative; 
				left: 50%; 
				padding-top: 50px; 
				overflow: auto;
				margin-left: -315px;
			}
			
			.bottom{
				width: 326px;
				margin-top: 50px;
				position: relative;
				left: 50%;
				margin-left: -163px;
			}
			
			.region{
				margin-left: 15px; 
				margin-right: 15px;
			}
			
			.list{
				margin-bottom: 0px;
				background-color: white;
				display: none;
				position: absolute;
			}
			
			.addAddress{
				background-color: white;
			}
			
			.text_center{
				text-align: center;
			}
		</style>
		<script type="text/javascript">
		var chooseURL = '${webRoot}/web/client/ChooseFood.jsp';
		$(function(){
			initRegion();
		});

		//初始化区域
		function initRegion(){
			AddressAction.queryChildRegion(-1,function(data){
				for(var i=0;i<data.length;++i){
					createRegion(data[i]);
				}
			});
		}

		//创建一个区域
		function createRegion(obj){
			var objLi = $('<li>').append(
						$('<a>').attr('href',encodeURI(chooseURL+'?regionId='+obj.id+'&regionName='+obj.regionName)).attr('class','thumbnail text_center').append(
							$('<img>').attr('src','${webRoot}'+obj.image).css('width','100px').css('height','100px').attr('class','img-circle')
						).append($('<div>').html(obj.regionName))
					);
			$('#region_box').append(objLi);
		}

		//创建一个地址
		function createAddress(obj){
			var objTr = $('<tr>').append(
							$('<td>').attr('id',obj.id).html(obj.fullName).css('cursor','pointer').click(function(){
								window.location.href = chooseURL+'?addressId='+obj.id+'&addressName='+obj.shortName;
							})
						);
			$('#list').append(objTr);
		}

		//添加临时地址
		function addTempAddress(){
			AddressAction.addTempAddress($('#tempAddress').val(),$('#phone').val(),function(data){
				$('#addAddress').modal('hide');
			});
		}

		//打开注册窗口
		function openFindPassword(){
			window.open('${webRoot}/web/client/FindPassword.jsp','findPassword');
		}

		//打开注册窗口
		function openRegister(){
			window.open('${webRoot}/web/client/register.jsp','register');
		}

		//查询地址
		function queryAddress(){
			var keyword = $('#keyword').val();
			if(keyword!=''){
				AddressAction.queryAddress(keyword,function(data){
					if(data.length==0){
						$("#alert").show();
						$("#list").hide();
					}else{
						$("#list").children().remove();
						$("#list").show();
						$("#alert").hide();
						for(var i=0;i<data.length;++i){
							createAddress(data[i]);
						}
						$('#list').css('top','-'+$('#list').css('height'));
					}
				});
			}else{
				$("#list").hide();
			}
		}
		</script>
	</head>
	<body style="overflow-x: hidden">
		<div class="navbar navbar-static-top">
			<div class="navbar-inner">
				<ul class="nav pull-right">
					<li><a href="#login" data-toggle="modal">登录</a></li>
					<li><a href="#register" data-toggle="modal">注册</a></li>
				</ul>
			</div>
		</div>
		<div>
			<div class="logo"></div>
			<div class="center">
				<ul id="region_box" class="thumbnails">
				</ul>
			</div>
			<div class="bottom" align="center">
				<table id="list" class="table table-hover list">
				</table>
				<div class="input-prepend" align="center">
					<span class="add-on"><i class="icon-search"></i></span>
					<input class="span4" id="keyword" type="text" placeholder="输入地址查找" onkeyup="queryAddress();">
				</div>
				<div id="alert" class="alert" style="display: none; cursor: pointer;">
				  <button type="button" class="close" data-dismiss="alert">&times;</button>
				  <a href="#addAddress" data-toggle="modal">没找到您的位置吗？请点击这里</a>
				</div>
			</div>
		</div>

		<div id="addAddress" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 490px;">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h3 id="myModalLabel">请提交您的地址</h3>
		  </div>
		  <div class="modal-body">
		    <form>
			  <fieldset>
			     <input id="tempAddress" type="text" class="span6" placeholder="请输入地址">
			     <br>
			     <input id="phone" type="text" placeholder="请输入手机">
			  </fieldset>
			</form>
		  </div>
		  <div class="modal-footer">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		    <button class="btn btn-primary" onclick="addTempAddress();">提交</button>
		  </div>
		</div>
		
		<div id="register" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 400px;">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h2 id="myModalLabel">免费注册</h2>
		  </div>
		  <div class="modal-body">
		    <form class="form-sign">
			  <fieldset>
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
    			</label>
			  </fieldset>
			</form>
		  </div>
		  <div class="modal-footer">
		    <button class="btn btn-primary">提交</button>
		  </div>
		</div>
		
		<div id="login" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 400px;">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h2 id="myModalLabel">会员登录</h2>
		  </div>
		  <div class="modal-body">
		    <form class="form-sign">
			  <fieldset>
			    <label>用户名/Email/手机号</label>
			    <input type="text" class="input-block-level">
				<label>密码</label>
			    <input type="text" class="input-block-level">
			    <label class="checkbox">
      				<input type="checkbox"> 10天内免登录
      				<div style="float: right;">
      					<a href="#" onclick="openFindPassword();">忘记密码</a>|<a href="#" onclick="openRegister();">注册账号</a>
      				</div>
    			</label>
			  </fieldset>
			</form>
		  </div>
		  <div class="modal-footer">
		    <button class="btn btn-primary">登录</button>
		  </div>
		</div>
	</body>
</html>
