<%@page import="com.demoweb.model.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

		<div id="header">
            <div class="title">
                <a href="/demoweb-mvc-with-maven/home.action">DEMO WEBSITE</a>
            </div>
            <div class="links">
            <% if (session.getAttribute("loginuser") == null) { %>
                <a href="/demoweb-mvc-with-maven/loginform.action">�α���</a>
                <a href="#">���</a>
            <% } else { %>
            	<% Member member = (Member)session.getAttribute("loginuser"); %>
                <%= member.getMemberId() %>�� ȯ���մϴ�.
                <a href="/demoweb-mvc-with-maven/logout.action">�α׾ƿ�</a>
            <% } %>
            </div>
        </div>        
        <div id="menu">
            <div>
                <ul>
                	<!-- a : ������ �̵��� ó���ϴ� ��ũ�� -->
                    <li><a href="/demoweb-mvc-with-maven/memberlist.action">����ڰ���</a></li>
					<li><a href="#">���Ϻ�����</a></li>
					<li><a href="#">�ڷ��</a></li>
					<li><a href="#">�Խ���</a></li>
                </ul>
            </div>
        </div>
        <div style="text-align:right;margin-top:1px;
        	border:solid 1px;padding:5px">
        	[ TOTAL : <%= application.getAttribute("total") %>�� ]
        	[ CURRENT : <%= application.getAttribute("current") %>�� ]
        </div>
        
        
        
        
        
        
        
        
        
        
        
        