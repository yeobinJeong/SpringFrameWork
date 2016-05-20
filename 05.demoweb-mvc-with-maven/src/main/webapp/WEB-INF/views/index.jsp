<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="euc-kr" />
    <title></title>
    <link rel="Stylesheet" href="/mvcdemoweb-withmaven/styles/default.css" />
</head>
<body>

    <div id="pageContainer">    
    	<%-- 
    	<%@ include file="/include/header.jsp" %>
    	<jsp:include page="/include/header.jsp"></jsp:include>
    	--%>
    	<% pageContext.include("/include/header.jsp"); %>
    	
        
        <div id="content">
        	<br /><br /><br /><br /><br />
        	<h2 style='text-aling:center'>
				Hello Demo Web Site Main Page !!!
			</h2>
        </div>
    </div>
    
</body>
</html>