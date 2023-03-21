package com.boot.boardbootproject.board;

import com.boot.boardbootproject.Util.DateFormat;
import com.boot.boardbootproject.board.dto.BoardWriteForm;
import com.boot.boardbootproject.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Getter
@Setter
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

    public Board(BoardWriteForm form, User user) {
        this.user = user;
        this.title = form.getTitle();
        this.text = form.getText();
        this.createDate = DateFormat.now();
    }

    public Board(){}
}
