<%@ page import="com.boot.boardbootproject.board.dto.BoardGetForm" %>
<%@ page import="com.boot.boardbootproject.comment.dto.CommentGetForm" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boot.boardbootproject.comment.dto.CommentListOnBoardFrom" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
  BoardGetForm board = (BoardGetForm) request.getAttribute("board");
  boolean like = (boolean) request.getAttribute("like");
  CommentListOnBoardFrom comments = (CommentListOnBoardFrom) request.getAttribute("comments");
%>

<%@ include file="../layout/header.jsp" %>

<center>
  <form action='updateBoard.do' method='post'>
    <input name='id' type='hidden' value="<%=board.getId()%>"/>
    <table border='1' cellpadding='0' cellspacing='0'>
      <tr>
        <td bgcolor='orange' width='70'>제목</td>
        <td align='left'><input name='title' type='text' value="<%=board.getTitle()%>"/></td>
      </tr>
      <tr>
        <td bgcolor='orange'>작성자</td>
        <td align='left'><%=board.getUserName()%></td>
      </tr>
      <tr>
        <td bgcolor='orange'>내용</td>
        <td align='left'><textarea name='text' cols='40' rows='10'><%=board.getText()%></textarea></td>
      </tr>
      <tr>
        <td bgcolor='orange'>등록일</td>
        <td align='left'><%=board.getCreateDate()%></td>
      </tr>
      <tr>
        <td bgcolor='orange' width='100'>조회수</td>
        <td align='left'><%=board.getView()%></td>
      </tr>
      <tr>
        <input type='submit' value='글 수정'>
      </tr>
    </table>
  </form>

  <hr>

  <% if(!like) {%>
  <form action='/board/<%=board.getId()%>/like/<%=user.getId()%>' method="POST">
    <input type="hidden" name="_method" value="POST">
    <input type="submit" value="좋아요">
  </form>
  <% } else {%>
  <form action='/board/<%=board.getId()%>/like/<%=user.getId()%>' method="POST">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="좋아요 취소">
  </form>
  <% }%>

  <% if(user.getId() == board.getUserId()) {%>
  <form action='/board/<%=board.getId()%>' method="POST">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="글 삭제">
  </form>
  <% } %>

  <form action="/board/<%=board.getId()%>/comment" method="post">
    <table border="1" cellpadding="0" cellspacing="0">
      <tr>
        <td bgcolor="orange">댓글 내용</td>
        <td align="left"><textarea name="text" clos ="200" rows="3"></textarea></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="댓글등록"/>
        </td>
      </tr>
    </table>
  </form>

  <table border='1' cellpadding='0' cellspacing='0' width='700'>
    <tr>
      <th bgcolor='orange' width='40'>번호</th>
      <th bgcolor='orange' width='60'>작성자</th>
      <th bgcolor='orange' width='200'>내용</th>
      <th bgcolor='orange' width='100'>등록일</th>
      <th width="100"></th>
    </tr>

    <% for(CommentGetForm comment : comments.getCommentList()){ %>
     <tr>
       <td> <%= comment.getId() %> </td>
      <td> <%= comment.getUserName() %> </td>
      <td><%= comment.getText()%></td>
      <td><%= comment.getCreateDate()%></td>
       <td>
       <% if(user.getId() == comment.getUserId()) {%>
       <form action='/board/<%=board.getId()%>/comment/<%=comment.getId()%>' method="POST">
         <input type="hidden" name="_method" value="DELETE">
         <input type="submit" value="댓글 삭제">
       </form>
       <% } %>
     </td>
    </tr>
    <%}%>

  </table>

</center>

<%@ include file="../layout/footer.jsp"%>