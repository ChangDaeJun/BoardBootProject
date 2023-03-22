package com.boot.boardbootproject.comment.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CommentListOnBoardFrom {
    private Long boardId;
    private List<CommentGetForm> commentList;

    public CommentListOnBoardFrom(Long boardId, List<CommentGetForm> commentList) {
        this.boardId = boardId;
        this.commentList = commentList;
    }

    public CommentListOnBoardFrom() {
    }
}
