<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<title>The Test Of DWR</title>
		<script type="text/javascript" src="/1000funs/dwr/engine.js"></script>
		<script type="text/javascript" src="/1000funs/dwr/util.js"></script>
		<script type="text/javascript" src="/1000funs/dwr/interface/DWRTestAction.js"></script>
		<script type="text/javascript">

			function sessionTest(){
				var param = document.getElementById("sessiontest_text").value;
				DWRTestAction.testSession(param,function(result){
					document.getElementById("sessiontest_result").innerHTML="succuess:"+result;
				});
			}

		</script>
	</head>
	<body>
		<div>The Test Of DWR</div>
		<hr/>
		<input type="text" id="sessiontest_text" value="" />
		<input type="button" id="sessiontest_button" value="query an user by name" onclick="sessionTest();"/>
		<span id="sessiontest_result"> sessionTest result </span>
	</body>
</html>