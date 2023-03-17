package com.boot.boardbootproject.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
public class Likes {
    @Id
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
