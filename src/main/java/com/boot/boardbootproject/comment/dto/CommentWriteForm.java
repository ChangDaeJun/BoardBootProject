package com.boot.boardbootproject.comment.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentWriteForm {
    private Long userId;
    private Long boardId;
    private String text;
}
