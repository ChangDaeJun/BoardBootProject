<%@ page import="java.util.List" %>
<%@ page import="com.boot.boardbootproject.comment.dto.CommentListByUserForm" %>
<%@ page import="com.boot.boardbootproject.likes.dto.LikeBoardListByUserForm" %>
<%@ page import="com.boot.boardbootproject.comment.dto.CommentGetForm" %>
<%@ page import="com.boot.boardbootproject.board.dto.BoardGetForm" %>
<%@ page import="com.boot.boardbootproject.board.dto.BoardListByUserForm" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../layout/header.jsp"%>

<%
    BoardListByUserForm createBoards = (BoardListByUserForm) request.getAttribute("createBoards");
    CommentListByUserForm createComments = (CommentListByUserForm) request.getAttribute("createComments");
    LikeBoardListByUserForm likeBoards = (LikeBoardListByUserForm) request.getAttribute("likeBoards");
%>

<center>
    <h1>내가 작성한 글 목록</h1>
    <table border='1' cellpadding='0' cellspacing='0' width='700'>
        <tr>
            <th bgcolor='orange' width='100'>번호</th>
            <th bgcolor='orange' width='200'>제목</th>
            <th bgcolor='orange' width='150'>등록일</th>
            <th bgcolor='orange' width='100'>조회수</th>
        </tr>

        <% for(BoardGetForm board: createBoards.getBoards()){ %>
        <tr>
            <td> <%= board.getId() %> </td>
            <td align ='left'><a href="getBoard.do?id=<%=board.getId()%>"><%= board.getTitle() %></a></td>
            <td><%= board.getCreateDate()%></td>
            <td><%= board.getView()%></td>
        </tr>
        <%}%>
    </table>

    <h1>내가 좋아요 누른 글 목록</h1>
    <table border='1' cellpadding='0' cellspacing='0' width='700'>
        <tr>
            <th bgcolor='orange' width='100'>번호</th>
            <th bgcolor='orange' width='200'>제목</th>
            <th bgcolor='orange' width='150'>등록일</th>
            <th bgcolor='orange' width='100'>조회수</th>
        </tr>

        <% for(BoardGetForm board: likeBoards.getBoardIdList()){ %>
        <tr>
            <td> <%= board.getId() %> </td>
            <td align ='left'><a href="getBoard.do?id=<%=board.getId()%>"><%= board.getTitle() %></a></td>
            <td><%= board.getCreateDate()%></td>
            <td><%= board.getView()%></td>
        </tr>
        <%}%>
    </table>

    <h1>내가 작성한 댓글</h1>
    <table border='1' cellpadding='0' cellspacing='0' width='700'>
        <tr>
            <th bgcolor='orange' width='100'>글 번호</th>
            <th bgcolor='orange' width='200'>댓글 내용</th>
            <th bgcolor='orange' width='100'>작성일</th>
        </tr>

        <% for(CommentGetForm comment : createComments.getCommentList()){ %>
        <tr>
            <td><a href="getBoard.do?id=<%=comment.getBoardId()%>"> <%= comment.getBoardId() %> </td>
            <td><%= comment.getText()%></td>
            <td><%= comment.getCreateDate()%></td>
        </tr>
        <%}%>
    </table>
</center>

<%@ include file="../layout/footer.jsp"%>
