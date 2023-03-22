package com.boot.boardbootproject.comment.service;

import com.boot.boardbootproject.comment.dto.CommentGetForm;
import com.boot.boardbootproject.comment.dto.CommentListByUserForm;
import com.boot.boardbootproject.comment.dto.CommentListOnBoardFrom;

public interface CommentGetService {
    CommentListOnBoardFrom getCommentByBoardId(Long boardId);
    CommentListByUserForm getCommentByUserId(Long userId);
}
