package com.boot.boardbootproject.likes.dto;

import com.boot.boardbootproject.board.dto.BoardGetForm;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LikeBoardListByUserForm {
    private Long userId;
    private List<BoardGetForm> boardIdList;

    public LikeBoardListByUserForm(Long userId, List<BoardGetForm> boardIdList) {
        this.userId = userId;
        this.boardIdList = boardIdList;
    }

}
