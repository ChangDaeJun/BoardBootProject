package com.boot.boardbootproject.board;

import com.boot.boardbootproject.user.User;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition ="LONGTEXT")
    private String text;

    @Column
    private Long view;

    @Column
    @CreatedDate
    private Date createDate;
}
