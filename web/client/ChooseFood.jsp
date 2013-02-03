<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>选择食物</title>
		<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
		<script type="text/javascript" src="../js/jquery-1.8.0.js"></script>
		<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
		<style type="text/css">
		
			body {
				font-family: "Microsoft Yahei", SimSun, Tahoma, Helvetica, Arial, sans-serif;
			}
			
			.tab{
				height: 80px; 
				text-align: center;
				font-size: 30px;
				padding-top: 25px;
			}
			
			.active{
				background-color: #0088cc;
				color: white;
			}
			
			.notActive{
				background-color: #f7f7f9;
				color: black;
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
			}
			
			.plate_bottom{
				border-top: 1px solid rgba(0, 0, 0, 0.3); 
			}
			
			.input_num{
				width: 11px;
			}
		</style>
		<script type="text/javascript">

			//加一
			function plus(id){
				var val = $('#'+id).val();
				if(val==''){
					val=0;
				}
				$('#'+id).val(parseInt(val)+1);
			}
			
			//减一
			function reduce(id){
				var val = $('#'+id).val();
				if(val==''||val==1){
					return;
				}
				$('#'+id).val(parseInt(val)-1);
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
						    <div class="span3 tab active">
						    	随意配餐
						    </div>
						    <div class="span3 tab notActive">
						    	经典套餐
						    </div>
						</div>
					</div>
					<div>
						<iframe id="food-area-frame" src=""></iframe>
					</div>
			    </div>
			    <div class="span4">
			    	<label>
			    		共
			    		<a href="#" onclick="plus('personNO');"><i class="icon-plus"></i></a>
			    		<input id="personNO" class="input_num" type="text" value="1" style="margin-bottom: 0px;">
						<a href="#" onclick="reduce('personNO');"><i class="icon-minus"></i></a>
			    		人用餐
			    	</label>
			    	<div class="plate">
			    		<div class="plate_title active">
			    			餐盘一
			    		</div>
			    		<div class="plate_content">
			    			<table class="table table-condensed table-hover" style="margin-bottom: 0px;">
			    				<tr>
			    					<td>宫保鸡丁</td>
			    					<td>
			    						7元X
							    		<a href="#" onclick="plus('personNO');"><i class="icon-plus"></i></a>
							    		<input id="personNO" class="input_num" type="text" value="1" style="margin-bottom: 0px;">
										<a href="#" onclick="reduce('personNO');"><i class="icon-minus"></i></a>
										份
			    					</td>
			    				</tr>
			    				<tr>
			    					<td>米饭</td>
			    					<td>
			    						7元X
							    		<a href="#" onclick="plus('personNO');"><i class="icon-plus"></i></a>
							    		<input id="personNO" class="input_num" type="text" value="1" style="margin-bottom: 0px;">
										<a href="#" onclick="reduce('personNO');"><i class="icon-minus"></i></a>
										份
			    					</td>
			    				</tr>
			    				<tr>
			    					<td>酸辣排骨</td>
			    					<td>
			    						7元X
							    		<a href="#" onclick="plus('personNO');"><i class="icon-plus"></i></a>
							    		<input id="personNO" class="input_num" type="text" value="1" style="margin-bottom: 0px;">
										<a href="#" onclick="reduce('personNO');"><i class="icon-minus"></i></a>
										份
			    					</td>
			    				</tr>
							</table>
			    		</div>
			    		<div class="plate_bottom">
			    			合计    21元
			    		</div>
			    	</div>
			    	<div class="plate">
			    		<div class="plate_title notActive">
			    			餐盘二
			    		</div>
			    		<div class="plate_content">
			    			<table class="table table-condensed table-hover" style="margin-bottom: 0px;">
			    				<tr>
			    					<td>宫保鸡丁</td>
			    					<td>
			    						7元X
							    		<a href="#" onclick="plus('personNO');"><i class="icon-plus"></i></a>
							    		<input id="personNO" class="input_num" type="text" value="1" style="margin-bottom: 0px;">
										<a href="#" onclick="reduce('personNO');"><i class="icon-minus"></i></a>
										份
			    					</td>
			    				</tr>
			    				<tr>
			    					<td>米饭</td>
			    					<td>
			    						7元X
							    		<a href="#" onclick="plus('personNO');"><i class="icon-plus"></i></a>
							    		<input id="personNO" class="input_num" type="text" value="1" style="margin-bottom: 0px;">
										<a href="#" onclick="reduce('personNO');"><i class="icon-minus"></i></a>
										份
			    					</td>
			    				</tr>
			    				<tr>
			    					<td>酸辣排骨</td>
			    					<td>
			    						7元X
							    		<a href="#" onclick="plus('personNO');"><i class="icon-plus"></i></a>
							    		<input id="personNO" class="input_num" type="text" value="1" style="margin-bottom: 0px;">
										<a href="#" onclick="reduce('personNO');"><i class="icon-minus"></i></a>
										份
			    					</td>
			    				</tr>
							</table>
			    		</div>
			    		<div class="plate_bottom">
			    			合计    21元
			    		</div>
			    	</div>
			    	<div class="plate">
			    		<div class="plate_title notActive">
			    			餐盘三
			    		</div>
			    		<div class="plate_content">
			    			<table class="table table-condensed table-hover" style="margin-bottom: 0px;">
			    				<tr>
			    					<td>宫保鸡丁</td>
			    					<td>
			    						7元X
							    		<a href="#" onclick="plus('personNO');"><i class="icon-plus"></i></a>
							    		<input id="personNO" class="input_num" type="text" value="1" style="margin-bottom: 0px;">
										<a href="#" onclick="reduce('personNO');"><i class="icon-minus"></i></a>
										份
			    					</td>
			    				</tr>
			    				<tr>
			    					<td>米饭</td>
			    					<td>
			    						7元X
							    		<a href="#" onclick="plus('personNO');"><i class="icon-plus"></i></a>
							    		<input id="personNO" class="input_num" type="text" value="1" style="margin-bottom: 0px;">
										<a href="#" onclick="reduce('personNO');"><i class="icon-minus"></i></a>
										份
			    					</td>
			    				</tr>
			    				<tr>
			    					<td>酸辣排骨</td>
			    					<td>
			    						7元X
							    		<a href="#" onclick="plus('personNO');"><i class="icon-plus"></i></a>
							    		<input id="personNO" class="input_num" type="text" value="1" style="margin-bottom: 0px;">
										<a href="#" onclick="reduce('personNO');"><i class="icon-minus"></i></a>
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
			</div>
		</div>
	</body>
</html>
