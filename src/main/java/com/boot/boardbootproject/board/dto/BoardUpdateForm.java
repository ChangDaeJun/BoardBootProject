package com.boot.boardbootproject.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardUpdateForm {
    private Long id;
    private Long userId;
    private String title;

    private String text;
}
