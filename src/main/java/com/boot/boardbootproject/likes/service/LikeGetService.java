package com.boot.boardbootproject.likes.service;

import com.boot.boardbootproject.likes.dto.LikeBoardIdListByUserForm;
import com.boot.boardbootproject.likes.dto.LikeUserIdListOnBoardForm;

public interface LikeGetService {
    LikeBoardIdListByUserForm getByUserId(Long userId);
    LikeUserIdListOnBoardForm getByBoardId(Long boardId);
}
