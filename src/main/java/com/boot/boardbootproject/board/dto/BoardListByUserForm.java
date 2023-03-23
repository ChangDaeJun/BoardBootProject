package com.boot.boardbootproject.board.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class BoardListByUserForm {
    private Long userId;
    private List<BoardGetForm> boards;

    public BoardListByUserForm(Long userId, List<BoardGetForm> boards) {
        this.userId = userId;
        this.boards = boards;
    }
}
