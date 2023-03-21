package com.boot.boardbootproject.board.dto;

import com.boot.boardbootproject.Util.DateFormat;
import lombok.Getter;

import java.util.Date;

@Getter
public class BoardGetForm {

    private Long id;

    private String userName;

    private Long userId;

    private String title;

    private String text;

    private Long view;

    private String createDate;

    public BoardGetForm(Long id, String userName, Long userId, String title, String text, Long view, Date createDate) {
        this.id = id;
        this.userName = userName;
        this.userId = userId;
        this.title = title;
        this.text = text;
        this.view = view;
        this.createDate = DateFormat.getYYYYMMdd(createDate);
    }
}
