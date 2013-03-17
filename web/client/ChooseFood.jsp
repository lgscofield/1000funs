<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>选择食物</title>
		<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
		<script type="text/javascript" src="../js/jquery-1.8.0.js"></script>
		<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/1000funs/dwr/engine.js"></script>
		<script type="text/javascript" src="/1000funs/dwr/interface/FoodAction.js"></script>
		<script type="text/javascript" src="/1000funs/dwr/interface/PackageAction.js"></script>
		<style type="text/css">
		
			body {
				font-family: "Microsoft Yahei", SimSun, Tahoma, Helvetica, Arial, sans-serif;
			}
			
			.tab{
				height: 80px; 
				text-align: center;
				font-size: 30px;
				padding-top: 25px;
				cursor: pointer;
			}
			
			.active{
				background-color: #0088cc;
				color: white;
			}
			
			.notActive{
				background-color: #f7f7f9;
				color: black;
			}
			
			.plate-area{
				position: fixed;
			}
			
			.plate{
				border: 1px solid rgba(0, 0, 0, 0.3);
				width: 300px;
				margin-bottom: 10px;
			}
			
			.plate_title{
				text-align: center;
				font-size: 18px;
				height: 30px; 
				padding-top: 7px;
				cursor: pointer;
			}
			
			.plate_bottom{
				border-top: 1px solid rgba(0, 0, 0, 0.3); 
				text-align: right;
			}
			
			.input_num{
				width: 11px;
			}
			
			.total{
				text-align: right;
				font-size: 30px;
				width: 300px;
				margin-bottom: 10px;
			}
			
			.ok{
				width: 300px;
			}
			
			.foods-area {
				margin: 15px 0px 0px 0px;
				padding: 0px;
				width: 750px;
			}
			.foods-area td {
				border-width: 1px 0px 1px 1px;
				border-style: solid;
				border-color: rgba(0, 0, 0, 0.15);
			}
			.foods-area .food-area-head {
				font-size: 30px;
				vertical-align: middle;
				text-align: center;
				width: 100px;
				padding: 0px 10px;
			}
			ul.food-area-list {
				padding: 0px;
				margin: 0px;
				list-style: none outside none;
			}
			ul.food-area-list > li {
				float: left;
				margin: 10px 0px 10px 15px;
			}
			ul.food-area-list > li > img {
				width: 100px;
				height: 100px;
			}
		</style>
		<script type="text/javascript">

			var plateCount=1;//餐盘数量

			$(function(){
				$('#personNO').val(plateCount);
				queryFoods();
				queryPackages();
			});

			//激活单品
			function activateSingle(){
				$('#single-bar').removeClass('notActive');
				$('#single-bar').addClass('active');
				$('#package-bar').removeClass('active');
				$('#package-bar').addClass('notActive');
				$("#package").hide();
				$("#single").show();
			}

			//激活套餐
			function activatePackage(){
				$('#package-bar').removeClass('notActive');
				$('#package-bar').addClass('active');
				$('#single-bar').removeClass('active');
				$('#single-bar').addClass('notActive');
				$("#single").hide();
				$("#package").show();
			}

			//加一
			jQuery.fn.plus = function(){
				var input = this.next();
				var val = input.val();
				if(val==5){
					$('#alert-over-max-num').show();
					return;
				}
				if(val==''){
					val=0;
				}
				input.val(parseInt(val)+1);
			}
			
			//减一
			jQuery.fn.reduce = function(){
				$('#alert-over-max-num').hide();
				var input = this.prev();
				var val = input.val();
				if(val==''||val==1){
					return;
				}
				input.val(parseInt(val)-1);
			}

			//添加餐盘
			function addPlate(){
				if(plateCount==5){
					return;
				}
				plateCount++;
				$('#plate-list').append(
					$('<div>').attr('class','plate').attr('id','plate'+plateCount).append(
						$('<div>').attr('class','plate_title notActive').html('餐盘'+plateCount).click(function(){
							$(this).activatePlate();
						})
					).append(
						$('<div>').attr('class','plate_content')
						.append('<table class="table table-condensed table-hover" style="margin-bottom: 0px;"></table>')
					).append(
						$('<div>').attr('class','plate_bottom').html('合计    21元').css('display','none')
					)
				);
			}

			//删除餐盘
			function reducePlate(){
				if(plateCount==1){
					return;
				}
				$('#plate'+plateCount).remove();
				plateCount--;
			}

			//收起餐盘
			jQuery.fn.fold = function(){
				this.children('.plate_content').hide('fast');
				this.children('.plate_bottom').hide('fast');
			}

			//展开餐盘
			jQuery.fn.unfold = function(){
				this.children('.plate_content').show('fast');
				this.children('.plate_bottom').show('fast');
			}

			//激活一个餐盘，收起其他餐盘
			jQuery.fn.activatePlate = function(){
				$('#plate-area').find('.active').removeClass('active').addClass('notActive');
				this.removeClass('notActive').addClass('active');
				$('.plate').fold();
				this.parent().unfold();
			}

			//查询食物单品
			function queryFoods(){
				FoodAction.queryFoods(function(data){
					for(var i=0;i<data.length;++i){
						createFood(data[i]);
					}
				});
			}

			//查询套餐
			function queryPackages(){
				PackageAction.queryPackages(function(data){
					for(var i=0;i<data.length;++i){
						createPackage(data[i]);
					}
				});
			}

			//创建一个食物单品
			function createFood(vo){
				var obj=$('<li>').attr('id','food_'+vo.id).attr('title',vo.foodName).click(function(){
					console.log(vo);
				}).append(
						$('<img>').attr('src','../img/'+vo.image)
						);
				if($('#ul_'+vo.groupId).length==1){//已存在分区
					$('#ul_'+vo.groupId).append(obj);
				}else{//未存在分区
					$('#single').append(
							$('<tr>').append(
									$('<td>').attr('class','food-area-head').html(vo.groupName)
									).append(
									$('<td>').append(
											$('<ul>').attr('id','ul_'+vo.groupId).attr('class','food-area-list').append(obj)
											)
									)
							);
				}
			}

			//创建一个套餐
			function createPackage(vo){
				var obj=$('<li>').append(
						$('<img>').attr('id','package_'+vo.id).attr('src','../img/'+vo.image)
						);
				if($('#ul_'+vo.groupId).length==1){//已存在分区
					$('#ul_'+vo.groupId).append(obj);
				}else{//未存在分区
					$('#package').append(
							$('<tr>').append(
									$('<td>').attr('class','food-area-head').html(vo.groupName)
									).append(
									$('<td>').append(
											$('<ul>').attr('id','ul_'+vo.groupId).attr('class','food-area-list').append(obj)
											)
									)
							);
				}
			}
		</script>
	</head>
	<body>
		<div class="navbar navbar-static-top">
			<div class="navbar-inner">
				<ul class="nav pull-right">
					<li><a href="#">登录</a></li>
					<li><a href="#">注册</a></li>
				</ul>
			</div>
		</div>
		<div style="padding-left: 50px; padding-top: 10px; padding-bottom: 10px;">
			香丽大厦
			<a href="/1000funs/web/client/FirstPage.jsp">[修改地址]</a>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
			    <div class="span8" style="border-right: 1px solid rgba(0, 0, 0, 0.15);">
			    	<div class="container-fluid">
						<div class="row-fluid">
						    <div id="single-bar" class="span3 tab active" onclick="activateSingle();">
						    	随意配餐
						    </div>
						    <div id="package-bar" class="span3 tab notActive" onclick="activatePackage();">
						    	经典套餐
						    </div>
						</div>
					</div>
					<div>
						<table id="single" class="foods-area">
						</table>
						<table id="package" class="foods-area" style="display: none;">
						</table>
					</div>
			    </div>
			    <div class="span4">
			    	<div id="plate-area" class="plate-area">
				    	<label>
				    		共
				    		<a href="#" onclick="$(this).plus();addPlate();"><i class="icon-plus"></i></a>
				    		<input id="personNO" class="input_num" type="text" value="1" style="margin-bottom: 0px;" disabled="disabled">
							<a href="#" onclick="$(this).reduce();reducePlate();"><i class="icon-minus"></i></a>
				    		人用餐
				    		<div id="alert-over-max-num" class="alert alert-error" style="display: none;float: left;position: absolute">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								一个订单最多5人用餐，你可以提交一个新的订单
							</div>
				    	</label>
				    	<div id="plate-list">
					    	<div id="plate_1" class="plate">
					    		<div class="plate_title active" onclick="$(this).activatePlate();">
					    			餐盘1
					    		</div>
					    		<div class="plate_content">
					    			<table class="table table-condensed table-hover" style="margin-bottom: 0px;">
					    				<tr>
					    					<td>宫保鸡丁</td>
					    					<td>
					    						7元X
									    		<a href="#" onclick="$(this).plus();"><i class="icon-plus"></i></a>
									    		<input id="personNO" class="input_num" type="text" value="1" style="margin-bottom: 0px;">
												<a href="#" onclick="$(this).reduce();"><i class="icon-minus"></i></a>
												份
					    					</td>
					    				</tr>
					    				<tr>
					    					<td>米饭</td>
					    					<td>
					    						7元X
									    		<a href="#" onclick="$(this).plus();"><i class="icon-plus"></i></a>
									    		<input id="personNO" class="input_num" type="text" value="1" style="margin-bottom: 0px;">
												<a href="#" onclick="$(this).reduce();"><i class="icon-minus"></i></a>
												份
					    					</td>
					    				</tr>
					    				<tr>
					    					<td>酸辣排骨</td>
					    					<td>
					    						7元X
									    		<a href="#" onclick="$(this).plus();"><i class="icon-plus"></i></a>
									    		<input id="personNO" class="input_num" type="text" value="1" style="margin-bottom: 0px;">
												<a href="#" onclick="$(this).reduce();"><i class="icon-minus"></i></a>
												份
					    					</td>
					    				</tr>
									</table>
					    		</div>
					    		<div class="plate_bottom">
					    			合计    21元
					    		</div>
					    	</div>
					    </div>
				    	<div class="total">
				    		合计    21元
				    	</div>
						<button class="btn btn-large btn-primary ok" type="button">确定</button>
					</div>
			    </div>
			</div>
		</div>
	</body>
</html>
