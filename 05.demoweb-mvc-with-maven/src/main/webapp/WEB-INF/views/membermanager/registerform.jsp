<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="EUC-KR" />
	<title>����ڵ��</title>
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
		        <form action="memberregister.action" method="post"><!-- �����ǥ�� -->
		        <table>
		            <tr>
		                <th>���̵�(ID)</th>
		                <td>
		                    <input type="text" name="memberId" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>��й�ȣ</th>
		                <td>
		                	<input type="password" name="passwd" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>��й�ȣ Ȯ��</th>
		                <td>
		                    <input type="password" name="confirm" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>�̸���</th>
		                <td>
		                	<input type="text" name="email" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>����ڱ���</th>
		                <td>
		                	<input type="radio" name="userType" value="u" checked="checked">�����</input>
		                	<input type="radio" name="userType" value="a">������</input>
		                </td>
		            </tr>
		            <tr>
		                <th>Ȱ��ȭ����</th>
		                <td>
		                	<input type="checkbox" name="active" value="y">Ȱ�������</input>
		                </td>
		            </tr>		            		            
		        </table>
		        <div class="buttons">
		        	<input type="submit" value="���" style="height:25px" />
		        	<input type="button" value="���" style="height:25px"
		        		onclick="location.href='memberlist.action';" />
		        	<!-- location.href='path' : path�� �̵��ϴ� javascript ��� -->
		        </div>
		        </form>
		    </div>
		</div>   	
	
	</div>

</body>
</html>