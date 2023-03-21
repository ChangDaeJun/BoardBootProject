package com.boot.boardbootproject.board.dto;

import com.boot.boardbootproject.user.User;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardWriteForm {
    private Long userId;

    private String title;

    private String text;
}
