package com.boot.boardbootproject.comment.service;

import com.boot.boardbootproject.comment.dto.CommentWriteForm;

public interface CommentWriteService {
    Long write(CommentWriteForm form) throws Exception;
}
