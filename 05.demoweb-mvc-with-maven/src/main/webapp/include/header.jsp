<%@page import="com.demoweb.model.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

		<div id="header">
            <div class="title">
                <a href="/demoweb-mvc-with-maven/home.action">DEMO WEBSITE</a>
            </div>
            <div class="links">
            <% if (session.getAttribute("loginuser") == null) { %>
                <a href="/demoweb-mvc-with-maven/loginform.action">로그인</a>
                <a href="#">등록</a>
            <% } else { %>
            	<% Member member = (Member)session.getAttribute("loginuser"); %>
                <%= member.getMemberId() %>님 환영합니다.
                <a href="/demoweb-mvc-with-maven/logout.action">로그아웃</a>
            <% } %>
            </div>
        </div>        
        <div id="menu">
            <div>
                <ul>
                	<!-- a : 페이지 이동을 처리하는 마크업 -->
                    <li><a href="/demoweb-mvc-with-maven/memberlist.action">사용자관리</a></li>
					<li><a href="#">메일보내기</a></li>
					<li><a href="#">자료실</a></li>
					<li><a href="#">게시판</a></li>
                </ul>
            </div>
        </div>
        <div style="text-align:right;margin-top:1px;
        	border:solid 1px;padding:5px">
        	[ TOTAL : <%= application.getAttribute("total") %>명 ]
        	[ CURRENT : <%= application.getAttribute("current") %>명 ]
        </div>
        
        
        
        
        
        
        
        
        
        
        
        