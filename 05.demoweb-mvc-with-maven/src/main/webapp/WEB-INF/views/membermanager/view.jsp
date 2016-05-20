<%@page import="com.demoweb.model.dto.Member"%>
<%@page import="com.demoweb.model.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR" />
	<title>����� ����</title>
	<link rel="Stylesheet" href="/mvcdemoweb-withmaven/styles/default.css" />
	<link rel="Stylesheet" href="/mvcdemoweb-withmaven/styles/input.css" />		
</head>
<body>

	<div id="pageContainer">
		
		<% pageContext.include("/include/header.jsp"); %>
		
		<div id="inputcontent">
			<br /><br />
		    <div id="inputmain">
		        <div class="inputsubtitle">ȸ���⺻����</div>



		        <table>
		            <tr>
		                <th>���̵�(ID)</th>
		                <td>${ member.memberId }</td>
		            </tr>
		            <tr>
		                <th>�̸���</th>
		                <td>${ member.email }</td>
		            </tr>
		            <tr>
		                <th>�����</th>
		                <td>${ member.regDate }</td>
		            </tr>		            
		            <tr>
		                <th>����ڱ���</th>
		                <td>${ member.userType }</td>
		            </tr>
		            <tr>
		                <th>Ȱ��ȭ����</th>
		                <td>${ member.active }</td>
		            </tr>		            		            
		        </table>
		        <div class="buttons">
		        	<a href="memberlist.action">���</a>
		        </div>
		    </div>
		</div>   		
		
	</div>

</body>
</html>