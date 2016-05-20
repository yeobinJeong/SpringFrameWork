<%@ page session="false" pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" 
	uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Home</title>
	<style type="text/css">
	.error { color : red; font-size: 11pt; font-weight: bold }
	</style>
</head>
<body>
	<div style="padding-left:20px">
		<h2 style="text-align:center">Spring MVC Demo</h2>		
		<div style="width:500px;margin:0 auto;padding-top:20px">
		
			MESSAGE 1 : <spring:message code="msg.one" /><br /><br />
			MESSAGE 2 : <spring:message code="msg.two" /><br /><br />
			MESSAGE 3 : <spring:message code="msg.withdata" 
				arguments="John Doe,Jane Doe"
				argumentSeparator="," /><br /><br />
			MESSAGE 4 :<br /><br />
			MESSAGE 5 : <br /><br />
		
		</div>
	</div>
</body>
</html>
