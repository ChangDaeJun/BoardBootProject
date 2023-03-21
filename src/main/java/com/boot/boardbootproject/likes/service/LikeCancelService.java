package com.boot.boardbootproject.likes.service;

import com.boot.boardbootproject.likes.dto.LikeForm;

public interface LikeCancelService {
    void cancel(LikeForm form) throws Exception;

    void cancelByUserId(Long userId) throws Exception;

    void cancelByBoardId(Long boardId) throws Exception;
}
