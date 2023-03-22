package com.boot.boardbootproject.comment.dto;

import com.boot.boardbootproject.Util.DateFormat;
import lombok.Getter;

import java.util.Date;

@Getter
public class CommentGetForm {
    private Long id;
    private String createDate;
    private Long userId;
    private String userName;
    private Long boardId;
    private String text;

    public CommentGetForm(Long id, Long boardId, Long userId, String userName, String text, Date createDate) {
        this.id = id;
        this.createDate = DateFormat.getYYYYMMdd(createDate);
        this.userId = userId;
        this.userName = userName;
        this.boardId = boardId;
        this.text = text;
    }

    public CommentGetForm() {
    }
}
