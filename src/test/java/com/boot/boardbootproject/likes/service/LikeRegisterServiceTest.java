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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LikeRegisterServiceTest {
    @Autowired
    private UserJoinService userJoinService;
    @Autowired
    private UserDeleteService userDeleteService;
    @Autowired
    private BoardWriteService boardWriteService;
    @Autowired
    private LikeRegisterService likeRegisterService;
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
    void register() throws Exception{
        LikeForm likeForm = new LikeForm();
        likeForm.setUserId(this.userId);
        likeForm.setBoardId(this.boardId);
        likeRegisterService.register(likeForm);

        boolean exist = likeRepository.existsByUserIdAndBoardId(this.userId, this.boardId);
        assertThat(exist, is(true));
    }

    @Test
    void register_fail_because_NotFoundUser(){
        LikeForm likeForm = new LikeForm();
        likeForm.setUserId(this.userId+ 1000);
        likeForm.setBoardId(this.boardId);
        try {
            likeRegisterService.register(likeForm);
            fail();
        }catch (Exception e){

        }
    }

    @Test
    void register_fail_because_NotFoundBoard(){
        LikeForm likeForm = new LikeForm();
        likeForm.setUserId(this.userId);
        likeForm.setBoardId(this.boardId + 10000);
        try {
            likeRegisterService.register(likeForm);
            fail();
        }catch (Exception e){

        }
    }
}