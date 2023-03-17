package com.boot.boardbootproject.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
public class Comment {
    @Id
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
