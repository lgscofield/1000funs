<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>选择食物</title>
		<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
		<script type="text/javascript" src="../js/jquery-1.8.0.js"></script>
		<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
		<style type="text/css">
			.tab{
				height: 80px; 
				text-align: center;
				font-size: 30px;
				padding-top: 25px;
			}
			
			.active{
				background-color: #bbd8e9;
				color: white;
			}
			
			.notActive{
				background-color: #f7f7f9;
				color: black;
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
			    		<input class="span1" id="personNO" type="text" value="1">
						<a href="#" onclick="reduce('personNO');"><i class="icon-minus"></i></a>
			    		人用餐
			    	</label>
			    </div>
			</div>
		</div>
	</body>
</html>
