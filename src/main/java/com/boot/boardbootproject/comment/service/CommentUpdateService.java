package com.boot.boardbootproject.comment.service;

import com.boot.boardbootproject.comment.dto.CommentUpdateForm;

public interface CommentUpdateService {
    void update(CommentUpdateForm form) throws Exception;
}
