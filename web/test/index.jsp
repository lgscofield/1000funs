<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<title>The Template Of Jsp</title>
		<script type="text/javascript" src="/1000funs/web/dwr/engine.js"></script>
		<script type="text/javascript" src="/1000funs/web/dwr/util.js"></script>
		<script type="text/javascript" src="/1000funs/web/dwr/interface/UserTest.js"></script>
		<script type="text/javascript">
			function doInsert () {
				UserTest.doInsert(function(result){
					if (result.length > 2) {
						document.getElementById("insert_result").innerHTML="succuess:"+result;
					}else{
						document.getElementById("insert_result").innerHTML="error, code:"+result;
					}
				});
			}

			function doQuery () {
				var param = document.getElementById("query_text").value;
				UserTest.doQuery(param,function(result){
					if (result.length > 2) {
						document.getElementById("query_result").innerHTML="succuess:"+result;
					}else{
						document.getElementById("query_result").innerHTML="error, code:"+result;
					}
				});
			}

		</script>
	</head>
	<body>
		<div>The Test Of 1000funs - User</div>
		<hr/>
		<input type="text" id="insert_text" value="" />
		<input type="button" id="insert_button" value="insert a random user" onclick="doInsert();"/>
		<span id="insert_result"> doInsert result </span>
		<hr/>
		<input type="text" id="query_text" value="" />
		<input type="button" id="query_button" value="query an user by name" onclick="doQuery();"/>
		<span id="query_result"> doQuery result </span>


	</body>
</html>