<%@ page import="com.boot.boardbootproject.user.dto.UserGetForm" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Board Project</title>
</head>
<body>
<hr>
<a href="/">Home</a> &nbsp;&nbsp;&nbsp;
<% UserGetForm user = (UserGetForm) session.getAttribute("user");%>
<% if(user == null) {%>
    <a href="/user/join">회원 가입</a> &nbsp;&nbsp;&nbsp;
    <a href="/user/login">로그인</a> &nbsp;&nbsp;&nbsp;
<%} else {%>
    <a href="/board/write">글 작성</a> &nbsp;&nbsp;&nbsp;
    <a href="/board/list">글 목록</a> &nbsp;&nbsp;&nbsp;
    <a href="myPage.do">마이 페이지</a> &nbsp;&nbsp;&nbsp;
    <a href="/user/logout">로그아웃</a> &nbsp;&nbsp;&nbsp;
<%}%>

<hr>
<br>