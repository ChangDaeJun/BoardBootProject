package com.boot.boardbootproject.comment;

import com.boot.boardbootproject.Util.DateFormat;
import com.boot.boardbootproject.board.Board;
import com.boot.boardbootproject.comment.dto.CommentUpdateForm;
import com.boot.boardbootproject.comment.dto.CommentWriteForm;
import com.boot.boardbootproject.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Getter
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @OneToOne
    private Board board;

    @JoinColumn
    @OneToOne
    private User user;

    @Column(columnDefinition = "TEXT")
    private String text;

    @Column
    @CreatedDate
    private Date createDate;

    public Comment(CommentWriteForm form, Board board, User user) {
        this.board = board;
        this.user = user;
        this.text = form.getText();
        this.createDate = DateFormat.now();
    }

    public Comment() {
    }

    public void update(CommentUpdateForm form){
        this.text = form.getText();
    }
}
