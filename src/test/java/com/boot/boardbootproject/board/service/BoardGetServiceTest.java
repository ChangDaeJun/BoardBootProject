package com.boot.boardbootproject.board.service;

import com.boot.boardbootproject.Util.DateFormat;
import com.boot.boardbootproject.board.dto.BoardGetForm;
import com.boot.boardbootproject.board.dto.BoardWriteForm;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.service.UserJoinService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.boot.boardbootproject.Util.DateFormat.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class BoardGetServiceTest {
    @Autowired
    private BoardGetService boardGetService;
    @Autowired
    private BoardWriteService boardWriteService;
    @Autowired
    private UserJoinService userJoinService;

    private Long userId;
    @BeforeAll
    void before() throws Exception{
        UserJoinForm userJoinForm = new UserJoinForm();
        userJoinForm.setName("test");
        userJoinForm.setEmail("test");
        userJoinForm.setPassword("test");
        this.userId = userJoinService.join(userJoinForm);
    }

    @Test
    void getById() throws Exception{
        BoardWriteForm boardWriteForm = new BoardWriteForm();
        boardWriteForm.setUserId(this.userId);
        boardWriteForm.setText("test text");
        boardWriteForm.setTitle("test title");
        Long id = boardWriteService.write(boardWriteForm);

        BoardGetForm boardGetForm = boardGetService.getById(id);
        assertThat(boardGetForm.getId(), is(id));
        assertThat(boardGetForm.getText(), is(boardWriteForm.getText()));
        assertThat(boardGetForm.getTitle(), is(boardWriteForm.getTitle()));
        assertThat(boardGetForm.getCreateDate(), is(getYYYYMMdd(now())));
        assertThat(boardGetForm.getUserId(), is(this.userId));
    }

    @Test
    void getListAll() throws Exception{
        BoardWriteForm boardWriteForm = new BoardWriteForm();
        boardWriteForm.setUserId(this.userId);
        boardWriteForm.setText("test text");
        boardWriteForm.setTitle("test title");
        boardWriteService.write(boardWriteForm);
        boardWriteService.write(boardWriteForm);
        boardWriteService.write(boardWriteForm);

        List<BoardGetForm> list = boardGetService.getListAll();
        assertThat(list, is(notNullValue()));
    }
}