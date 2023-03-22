package com.boot.boardbootproject.comment.repository;

import com.boot.boardbootproject.comment.Comment;
import com.boot.boardbootproject.comment.dto.CommentGetForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select new java.lang.Long(c.id) from Comment c where c.user.id =:userId")
    List<Long> findIdByUserId(Long userId);
    @Query("select new java.lang.Long(c.id) from Comment c where c.board.id =:boardId")
    List<Long> findIdByBoardId(Long boardId);
    @Query("select new com.boot.boardbootproject.comment.dto.CommentGetForm(c.id, c.board.id, c.user.id, c.user.name, c.text, c.createDate) from Comment c where c.user.id =:userId")
    List<CommentGetForm> findGetFormByUserId(Long userId);
    @Query("select new com.boot.boardbootproject.comment.dto.CommentGetForm(c.id, c.board.id, c.user.id, c.user.name, c.text, c.createDate) from Comment c where c.board.id =:boardId")
    List<CommentGetForm> findGetFormByBoardId(Long boardId);
}
