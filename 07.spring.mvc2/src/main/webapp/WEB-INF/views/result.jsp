<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>result page</title>
</head>
<body>
	<h3>This is result page</h3>
	<c:if test="${ not empty person }">
		<table>
			<tr>
				<th>Name</th>
				<td>${ person.name }</td>
			</tr>
			<tr>
				<th>Phone</th>
				<td>${ person.phone }</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${ person.email }</td>
			</tr>
		</table>
	</c:if>
	
</body>
</html>