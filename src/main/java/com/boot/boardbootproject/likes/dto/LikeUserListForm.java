package com.boot.boardbootproject.likes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LikeUserListForm {
    private Long boardId;
    private List<Long> userIdList;

    public LikeUserListForm(Long boardId, List<Long> userIdList) {
        this.boardId = boardId;
        this.userIdList = userIdList;
    }

    public LikeUserListForm() {
    }
}
