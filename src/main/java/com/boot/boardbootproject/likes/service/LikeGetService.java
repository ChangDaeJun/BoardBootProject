package com.boot.boardbootproject.likes.service;

import com.boot.boardbootproject.likes.dto.LikeBoardListForm;
import com.boot.boardbootproject.likes.dto.LikeUserListForm;

public interface LikeGetService {
    LikeBoardListForm getByUserId(Long userId);
    LikeUserListForm getByBoardId(Long boardId);
}
