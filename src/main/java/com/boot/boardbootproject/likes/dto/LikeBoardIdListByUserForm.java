package com.boot.boardbootproject.likes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LikeBoardIdListByUserForm {
    private Long userId;
    private List<Long> boardIdList;

    public LikeBoardIdListByUserForm(Long userId, List<Long> boardIdList) {
        this.userId = userId;
        this.boardIdList = boardIdList;
    }

    public LikeBoardIdListByUserForm() {
    }
}
