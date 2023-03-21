package com.boot.boardbootproject.likes.service;

import com.boot.boardbootproject.board.dto.BoardWriteForm;
import com.boot.boardbootproject.board.service.BoardWriteService;
import com.boot.boardbootproject.likes.dto.LikeForm;
import com.boot.boardbootproject.likes.repository.LikeRepository;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.service.UserDeleteService;
import com.boot.boardbootproject.user.service.UserJoinService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LikeCancelServiceTest {

    @Autowired
    private UserJoinService userJoinService;
    @Autowired
    private UserDeleteService userDeleteService;
    @Autowired
    private BoardWriteService boardWriteService;
    @Autowired
    private LikeRegisterService likeRegisterService;
    @Autowired
    private LikeCancelService likeCancelService;
    @Autowired
    private LikeRepository likeRepository;

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
    void cancel() throws Exception {
        LikeForm likeForm = new LikeForm();
        likeForm.setUserId(this.userId);
        likeForm.setBoardId(this.boardId);
        likeRegisterService.register(likeForm);

        boolean before = likeRepository.existsByUserIdAndBoardId(this.userId, this.boardId);
        likeCancelService.cancel(likeForm);
        boolean after = likeRepository.existsByUserIdAndBoardId(this.userId, this.boardId);

        assertThat(before, is(true));
        assertThat(after, is(false));
    }

    @Test
    void cancelByUserId() throws Exception {
        LikeForm likeForm = new LikeForm();
        likeForm.setUserId(this.userId);
        likeForm.setBoardId(this.boardId);
        likeRegisterService.register(likeForm);

        boolean before = likeRepository.existsByUserIdAndBoardId(this.userId, this.boardId);
        likeCancelService.cancelByUserId(this.userId);
        boolean after = likeRepository.existsByUserIdAndBoardId(this.userId, this.boardId);

        assertThat(before, is(true));
        assertThat(after, is(false));
    }

    @Test
    void cancelByBoardId() throws Exception{
        LikeForm likeForm = new LikeForm();
        likeForm.setUserId(this.userId);
        likeForm.setBoardId(this.boardId);
        likeRegisterService.register(likeForm);

        boolean before = likeRepository.existsByUserIdAndBoardId(this.userId, this.boardId);
        likeCancelService.cancelByBoardId(this.boardId);
        boolean after = likeRepository.existsByUserIdAndBoardId(this.userId, this.boardId);

        assertThat(before, is(true));
        assertThat(after, is(false));
    }
}