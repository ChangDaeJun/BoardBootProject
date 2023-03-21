package com.boot.boardbootproject.board.service;

import com.boot.boardbootproject.board.dto.BoardWriteForm;
import com.boot.boardbootproject.board.repository.BoardRepository;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.service.UserDeleteService;
import com.boot.boardbootproject.user.service.UserJoinService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.boot.boardbootproject.Util.DateFormat.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class BoardDeleteServiceTest {

    @Autowired
    BoardDeleteService boardDeleteService;
    @Autowired
    BoardWriteService boardWriteService;
    @Autowired
    UserJoinService userJoinService;
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    UserDeleteService userDeleteService;

    private Long userId;

    @BeforeEach
    void before() throws Exception{
        UserJoinForm userJoinForm = new UserJoinForm();
        userJoinForm.setName("test");
        userJoinForm.setEmail("test");
        userJoinForm.setPassword("test");
        this.userId = userJoinService.join(userJoinForm);
    }

    @AfterEach
    void after() throws Exception{
        userDeleteService.delete(this.userId);
    }
    @Test
    void deleteById() throws Exception{
        BoardWriteForm boardWriteForm = new BoardWriteForm();
        boardWriteForm.setUserId(this.userId);
        boardWriteForm.setText("test text");
        boardWriteForm.setTitle("test title");
        Long id = boardWriteService.write(boardWriteForm);

        boardDeleteService.deleteById(id);
        boolean exist = boardRepository.existsById(id);

        assertThat(exist, is(false));
    }

    @Test
    void deleteByUserId() throws Exception{
        BoardWriteForm boardWriteForm = new BoardWriteForm();
        boardWriteForm.setUserId(this.userId);
        boardWriteForm.setText("test text");
        boardWriteForm.setTitle("test title");
        boardWriteService.write(boardWriteForm);
        boardWriteService.write(boardWriteForm);
        boardWriteService.write(boardWriteForm);
        boardWriteService.write(boardWriteForm);
        boardWriteService.write(boardWriteForm);
        boardWriteService.write(boardWriteForm);

        boardDeleteService.deleteByUserId(this.userId);
        List<Long> ids = boardRepository.findIdByUserId(this.userId);

        assertThat(ids.size(), is(0));
    }
}