<%@page import="com.mvcdemoweb.model.dto.UploadFile"%>
<%@page import="com.mvcdemoweb.model.dto.Upload"%>
<%@page import="com.mvcdemoweb.model.dao.UploadDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>자료업로드</title>
	<link rel="Stylesheet" href="/demoweb-spring-compact/resources/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb-spring-compact/resources/styles/input.css" />
</head>
<body>

	<div id="pageContainer">
	
		<c:import url="/WEB-INF/views/include/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">업로드 자료 정보</div>
		        <table>
		            <tr>
		                <th>제목</th>
		                <td>${ upload.title }</td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td>${ upload.uploader }</td>
		            </tr>
		            <%--  
		            <tr>
		            	<th>조회수</th>
		            	<td>${ upload.readCount + 1 }</td>
		            </tr>
		            --%>
		            <tr>
		            	<th>등록일자</th>
		            	<td>${ upload.regDate }</td>
		            </tr>
		            <tr>
		                <th>첨부자료</th>
		                <td>
		                	
		                	<c:forEach var="file" items="${ upload.files }">
		                	<a href='download.action?uploadfileno=${ file.uploadFileNo }'>
		                		${ file.userFileName }
		                	</a>
		                	&nbsp;
		                	[${ file.downloadCount }]
		                	</c:forEach>
		                </td>
		            </tr>
		            <tr>
		                <th>자료설명</th>
		                <td>${ upload.content }</td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	<input type="button" value="편집" style="height:25px" />
		        	<input type="button" value="취소" style="height:25px" onclick="location.href='list.action';" />
		        </div>
		    </div>
		</div>   	
	
	</div>
	</div>

</body>
</html>