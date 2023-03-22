package com.boot.boardbootproject.likes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LikeUserIdListOnBoardForm {
    private Long boardId;
    private List<Long> userIdList;

    public LikeUserIdListOnBoardForm(Long boardId, List<Long> userIdList) {
        this.boardId = boardId;
        this.userIdList = userIdList;
    }

    public LikeUserIdListOnBoardForm() {
    }
}
