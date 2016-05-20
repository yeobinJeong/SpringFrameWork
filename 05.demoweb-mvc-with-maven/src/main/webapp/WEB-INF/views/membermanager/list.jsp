<%@page import="com.demoweb.model.dto.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.demoweb.model.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="euc-kr" />
    <title></title>
    <link rel="Stylesheet" href="/mvcdemoweb-withmaven/styles/default.css" />
</head>
<body>

    <div id="pageContainer">
    
    	<% pageContext.include("/include/header.jsp"); %>
        
        <div id="content">
        	<br /><br />
        	<div style='text-align:center'>
        		[&nbsp;<a href="memberregisterform.action">����� ���</a>&nbsp;]
        	</div>
        	<br /><br />        	
        	<table border="1" align="center" width="700px">
        		<tr style="height:30px;background-color:orange">
        			<td>���̵�</td>
        			<td>�̸���</td>
        			<td>����ڱ���</td>
        			<td>Ȱ��ȭ����</td>
        			<td>�������</td>
        		</tr>
        	<% ArrayList<Member> members = 
        		(ArrayList<Member>)request.getAttribute("members"); %>
        	<% for (int i = 0; i < members.size(); i++) { %>
        		<tr style="height:30px">
        			<td>
        				<a href="memberview.action?memberid=<%= members.get(i).getMemberId() %>">
        					<%= members.get(i).getMemberId() %>
        				</a>
        			</td>
        			<td><%= members.get(i).getEmail() %></td>
        			<td><%= members.get(i).getUserType() %></td>
        			<td><%= members.get(i).isActive() %></td>
        			<td><%= members.get(i).getRegDate() %></td>
        		</tr>
        	<% } %>
        	</table>
        	
        </div>
    </div>
    
</body>
</html>









