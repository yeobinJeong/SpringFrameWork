<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" 
	uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div style="padding-left:20px">
		<h2 style="text-align:center">Spring MVC Demo</h2>		
		<form action="demo-one.action" method="post">
		<table border="1" style="width:560px;margin:0 auto">
			<tr>
				<th style="width:150px">이름</th>
				<td><input type="text" name="name" style="width:400px"></td>
			</tr>			
			<tr>
				<th style="width:150px">이메일</th>
				<td><input type="text" name="email" style="width:400px"></td>
			</tr>
			<tr>
				<th style="width:150px">전화번호(집)</th>
				<td><input type="text" name="phone.home" style="width:400px"></td>
			</tr>
			<tr>
				<th style="width:150px">휴대전화</th>
				<td><input type="text" name="phone.mobile" style="width:400px"></td>
			</tr>
			<tr>
				<th style="width:150px">생년월일</th>
				<td><input type="date" name="birth" style="width:400px"></td>
			</tr>
			<tr>
				<th style="width:150px">관심키워드</th>
				<td>
					<input type="checkbox" name="tags[0]"/>
					<input type="checkbox" name="tags[1]"/>
					<input type="checkbox" name="tags[2]"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" style='text-align:center'>
					<input type="submit" value="등록">
				</td>
			</tr>
		</table>
		</form>		
	</div>
</body>
</html>
