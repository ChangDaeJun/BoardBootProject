package com.boot.boardbootproject.comment.service;

public interface CommentDeleteService {
    void deleteById(Long id);
    void deleteByUserId(Long userId);
    void deleteByBoardId(Long boardId);
}
