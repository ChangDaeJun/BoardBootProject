package com.boot.boardbootproject.comment.service;

import com.boot.boardbootproject.board.dto.BoardWriteForm;
import com.boot.boardbootproject.board.service.BoardWriteService;
import com.boot.boardbootproject.comment.Comment;
import com.boot.boardbootproject.comment.dto.CommentWriteForm;
import com.boot.boardbootproject.comment.repository.CommentRepository;
import com.boot.boardbootproject.likes.dto.LikeForm;
import com.boot.boardbootproject.likes.service.LikeGetService;
import com.boot.boardbootproject.likes.service.LikeRegisterService;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.service.UserDeleteService;
import com.boot.boardbootproject.user.service.UserJoinService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentWriteServiceTest {
    @Autowired
    private UserJoinService userJoinService;
    @Autowired
    private UserDeleteService userDeleteService;
    @Autowired
    private BoardWriteService boardWriteService;
    @Autowired
    private CommentWriteService commentWriteService;
    @Autowired
    private CommentRepository commentRepository;

    private Long userId;
    private Long boardId;

    @BeforeEach
    void before() throws Exception{
        UserJoinForm userJoinForm = new UserJoinForm();
        userJoinForm.setName("test");
        userJoinForm.setEmail("test");
        userJoinForm.setPassword("ttt");
        this.userId = userJoinService.join(userJoinForm);

        BoardWriteForm boardWriteForm = new BoardWriteForm();
        boardWriteForm.setUserId(this.userId);
        boardWriteForm.setText("test");
        boardWriteForm.setTitle("gfdfdfd");
        this.boardId = boardWriteService.write(boardWriteForm);
    }

    @AfterEach
    void after() throws Exception{
        userDeleteService.delete(userId);
    }

    @Test
    void write() throws Exception{
        CommentWriteForm commentWriteForm = new CommentWriteForm();
        commentWriteForm.setUserId(this.userId);
        commentWriteForm.setBoardId(this.boardId);
        commentWriteForm.setText("test");
        Long id = commentWriteService.write(commentWriteForm);

        boolean exist = commentRepository.existsById(id);

        assertThat(exist, is(true));
    }
}