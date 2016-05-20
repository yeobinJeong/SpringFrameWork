<?xml version="1.0" encoding="EUC-KR" ?>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" />
	<title>�α���</title>
	<link rel="Stylesheet" href="/mvcdemoweb-withmaven/styles/default.css" />
	<link rel="Stylesheet" href="/mvcdemoweb-withmaven/styles/input.css" />	
	<script type="text/javascript">
		//window.onload : javascript event (������ �ε��� ������ ȣ��)
		window.onload = function() {
			<% if (request.getAttribute("loginid") != null) { %>
				alert('�α��� ����');
				document.getElementById("memberId").value = 
					'<%= request.getAttribute("loginid") %>';
			<% } %>
		}
	</script>
</head>
<body>
	
	<div id="pageContainer">
	
		<% pageContext.include("/include/header.jsp"); %>
		
		<div id="inputcontent">
			<br /><br />
		    <div id="inputmain">
		        <div class="inputsubtitle">�α�������</div>
		        
		        <form action="login.action" method="post">
		        
		        <% String returnUrl = request.getParameter("returnurl"); %>
		        <!-- input type="hidden" : ����ڿ��� ������ ������ ������ ���۵Ǵ� �Է� ��� -->
		        <input type="hidden" name="returnurl" 
		       		value='<%= (returnUrl == null) ?  "" : returnUrl %>' />
		        <table>
		            <tr>
		                <th>���̵�(ID)</th>
		                <td>
		                    <input type="text" id="memberId" name="memberId" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>��й�ȣ</th>
		                <td>
		                	<input type="password" name="passwd" style="width:280px" />
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	<input type="submit" value="�α���" style="height:25px" />
		        	<input type="button" value="���" style="height:25px" />
		        </div>
		        </form>
		        
		    </div>
		</div>   	
	
	</div>

</body>
</html>