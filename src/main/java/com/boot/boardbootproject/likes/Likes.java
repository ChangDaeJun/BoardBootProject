package com.boot.boardbootproject.likes;

import com.boot.boardbootproject.board.Board;
import com.boot.boardbootproject.user.User;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
public class Likes {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @OneToOne
    private Board board;

    @JoinColumn
    @OneToOne
    private User user;

    @Column
    @CreatedDate
    private Date createDate;
}
