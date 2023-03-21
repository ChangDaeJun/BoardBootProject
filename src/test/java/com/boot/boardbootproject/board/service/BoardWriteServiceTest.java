package com.boot.boardbootproject.board.service;

import com.boot.boardbootproject.board.dto.BoardWriteForm;
import com.boot.boardbootproject.board.repository.BoardRepository;
import com.boot.boardbootproject.user.User;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.repository.UserRepository;
import com.boot.boardbootproject.user.service.UserJoinService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class BoardWriteServiceTest {

    @Autowired
    private UserJoinService userJoinService;
    @Autowired
    private BoardWriteService boardWriteService;
    @Autowired
    private BoardRepository boardRepository;


    private Long userId;
    @BeforeAll
    void before() throws Exception{
        UserJoinForm userJoinForm = new UserJoinForm();
        userJoinForm.setName("test");
        userJoinForm.setEmail("test");
        userJoinForm.setPassword("test");
        userId = userJoinService.join(userJoinForm);
    }

    @Test
    void write() throws Exception{
        BoardWriteForm boardWriteForm = new BoardWriteForm();
        boardWriteForm.setUserId(this.userId);
        boardWriteForm.setText("test text");
        boardWriteForm.setTitle("test title");
        Long id = boardWriteService.write(boardWriteForm);

        boolean exist = boardRepository.existsById(id);
        assertThat(exist, is(nullValue()));
    }

    @Test
    void write_fail_because_UserNotFound() throws Exception{
        BoardWriteForm boardWriteForm = new BoardWriteForm();
        boardWriteForm.setUserId(this.userId + 10000);
        boardWriteForm.setText("test text");
        boardWriteForm.setTitle("test title");
        Long id = boardWriteService.write(boardWriteForm);

        boolean exist = boardRepository.existsById(id);
        assertThat(exist, is(nullValue()));
    }
}