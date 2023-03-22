package com.boot.boardbootproject.comment.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CommentListByUserForm {
    private Long userId;
    private List<CommentGetForm> commentList;

    public CommentListByUserForm(Long userId, List<CommentGetForm> commentList) {
        this.userId = userId;
        this.commentList = commentList;
    }

    public CommentListByUserForm() {
    }
}
