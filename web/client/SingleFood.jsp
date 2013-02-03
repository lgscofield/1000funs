<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>选择单品</title>
		<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
		<script type="text/javascript" src="../js/jquery-1.8.0.js"></script>
		<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
		<style type="text/css">
			.active{
				background-color: #0088cc;
				color: white;
			}
			
			.notActive{
				background-color: #f7f7f9;
				color: black;
			}
			
			
body {
  font-family: "Microsoft Yahei", SimSun, Tahoma, Helvetica, Arial, sans-serif;
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
.btn.btn-login {
  width: 120px;
  font-family: "Microsoft Yahei", SimSun, Tahoma, Helvetica, Arial, sans-serif;
}
.checkbox.checkbox-remember {
  padding-top: 28px;
}
.user-info {
  padding: 10px 19px;
  width: 350px;
}
.user-info .user-avatar {
  display: inline-block;
  *display: inline;
  *zoom: 1;
  margin-right: 19px;
  vertical-align: top;
}
.user-info .user-text-info {
  display: inline-block;
  *display: inline;
  *zoom: 1;
  vertical-align: top;
  width: 200px;
  margin-right: 30px;
}
.sidebar {
  background: #f5f5f5;
  border: 1px solid #E3E3E3;
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  border-radius: 4px;
  -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05) inset;
  -moz-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05) inset;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05) inset;
}
.sidebar .nav-list {
  padding: 0px;
}
.sidebar li.nav-header {
  font-size: 14px;
  margin-top: 0px;
}
.sidebar > ul > li > a,
.sidebar .nav-header {
  border-top: 1px solid #e5e5e5;
  margin: 0 0 -1px;
}
.sidebar > ul > li:first-child {
  border: 0px;
}
.sidebar > ul > li > a {
  padding-left: 25px;
}
.container-fixed {
  margin-left: 0px;
}
.querybar {
  height: 42px;
}
.querybar form {
  margin-bottom: 0px;
}
.table-list {
  border: 1px solid #E5E5E5;
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  border-radius: 4px;
  -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05) inset;
  -moz-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05) inset;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05) inset;
}
.table-list .table-item {
  padding: 5px 10px;
}
.table-list .table-item.expand .body {
  color: #333;
}
.table-list .table-item.abnormal .order-address,
.table-list .table-item.abnormal .order-tel {
  color: #B94A48;
}
.table-list .row {
  margin-left: 0px;
}
.table-list > ul {
  padding: 0px;
  margin: 0px;
  list-style: none outside none;
}
.table-list > ul > li {
  padding: 10px 10px;
  border-bottom: 1px solid #E5E5E5;
}
.table-list > ul > li:hover .order-btn-abnormal {
  visibility: visible;
}
.table-list .head {
  font-weight: bold;
  height: 30px;
  line-height: 30px;
  color: #000;
}
.table-list .order-number {
  margin-right: 20px;
}
.table-list .order-address-tel:hover {
  text-decoration: underline;
  cursor: pointer;
}
.table-list .order-address {
  margin-right: 20px;
}
.table-list .order-tel {
  color: #468847;
}
.table-list .order-price {
  color: #B94A48;
}
.table-list .order-btn-out,
.table-list .order-btn-abnormal {
  margin-left: 10px;
}
.table-list .order-btn-abnormal {
  visibility: hidden;
}
.table-list .body {
  color: #999;
}
.table-list .body .food-collapse ul.food-list li {
  float: left;
  width: 180px;
}
.table-list .body .food-expand {
  display: none;
  background-color: #F2F2F2;
}
.table-list .body ul.food-list {
  padding: 0px;
  margin: 0px;
  list-style: none inside none;
}
.table-list .body ul.food-list li {
  margin: 5px 0px;
}
.table-list-comment {
  padding: 5px 20px;
}
.category > ul {
  padding: 0px;
  margin: 0px;
  list-style: none outside none;
  display: inline-block;
  *display: inline;
  *zoom: 1;
  font-size: 0px;
  -webkit-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
  -moz-box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
  box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
}
.category > ul > li {
  display: inline-block;
  *display: inline;
  *zoom: 1;
  margin: 0px 0px 0px;
  padding: 0px 10px 0px 5px;
  border: 1px solid rgba(0, 0, 0, 0.15);
}
.category > ul > li label {
  margin-top: 3px;
}
.foods-area {
  margin: 15px 0px 0px 0px;
  padding: 0px;
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
ul.food-area-list > li .food-add {
  cursor: pointer;
}
.controls-addfood .control-group:after {
  clear: right;
}
.addfood-form {
  padding: 10px 25px;
}
.addfood-form .addfood-photo {
  width: 160px;
  height: 160px;
  cursor: pointer;
}
.addfood-form .img-tips {
  font-size: 17px;
  font-weight: bold;
  text-align: center;
  position: absolute;
  margin: -90px 30px 0px;
  cursor: pointer;
}
.addfood-form .addfood-describe textarea {
  width: 415px;
}
.control-group.control-group-small .control-label {
  width: 60px;
}
.control-group.control-group-small .controls {
  margin-left: 80px;
}
.control-group.control-group-mini .control-label {
  width: 30px;
}
.control-group.control-group-mini .controls {
  margin-left: 50px;
}
.control-group.control-group-left .control-label {
  text-align: left;
}
#dialog-add-package.modal {
  margin-top: -300px;
}
#dialog-add-package .modal-body {
  max-height: 480px;
}
#dialog-add-package .food-to-add {
  border: 1px solid rgba(0, 0, 0, 0.15);
  overflow: auto;
}
.red {
  color: red;
}
.left {
  float: left;
}
.right {
  float: right;
}

		</style>
		<script type="text/javascript">
		</script>
	</head>
	<body>
		<div>
			<table class="foods-area">
				<tr>
					<td class="food-area-head">10元区</td>
					<td>
						<ul class="food-area-list">
							<li><img src="assert/img/paigu.jpg" alt=""></li>
							<li><img src="assert/img/paigu.jpg" alt=""></li>
							<li><img src="assert/img/paigu.jpg" alt=""></li>
							<li><img src="assert/img/paigu.jpg" alt=""></li>
							<li><img src="assert/img/paigu.jpg" alt=""></li>
							<li><img src="assert/img/paigu.jpg" alt=""></li>
							<li><img src="assert/img/paigu.jpg" alt=""></li>
							<li><img src="assert/img/plus.png" class="food-add" alt=""></li>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="food-area-head">9元区</td>
					<td>
						<ul class="food-area-list">
							<li><img src="assert/img/chaixin.jpg" alt=""></li>
							<li><img src="assert/img/chaixin.jpg" alt=""></li>
							<li><img src="assert/img/chaixin.jpg" alt=""></li>
							<li><img src="assert/img/chaixin.jpg" alt=""></li>
							<li><img src="assert/img/plus.png" class="food-add" alt=""></li>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="food-area-head">8元区</td>
					<td>
						<ul class="food-area-list">
							<li><img src="assert/img/kuguachaodang.jpg" alt=""></li>
							<li><img src="assert/img/kuguachaodang.jpg" alt=""></li>
							<li><img src="assert/img/kuguachaodang.jpg" alt=""></li>
							<li><img src="assert/img/plus.png" class="food-add" alt=""></li>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="food-area-head">7元区</td>
					<td>
						<ul class="food-area-list">
							<li><img src="assert/img/plus.png" alt="" class="food-add"></li>
						</ul>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
