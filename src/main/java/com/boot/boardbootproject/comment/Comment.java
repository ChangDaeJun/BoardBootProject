package com.boot.boardbootproject.comment;

import com.boot.boardbootproject.board.Board;
import com.boot.boardbootproject.user.User;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
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
}
