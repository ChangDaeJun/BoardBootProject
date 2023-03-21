package com.boot.boardbootproject.board.service;

import com.boot.boardbootproject.board.Board;
import com.boot.boardbootproject.board.dto.BoardUpdateForm;
import com.boot.boardbootproject.board.dto.BoardWriteForm;
import com.boot.boardbootproject.board.repository.BoardRepository;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.service.UserJoinService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.fail;
@SpringBootTest
class BoardUpdateServiceTest {
    @Autowired
    private UserJoinService userJoinService;
    @Autowired
    private BoardUpdateService boardUpdateService;
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
    void update() throws Exception{
        BoardWriteForm boardWriteForm = new BoardWriteForm();
        boardWriteForm.setUserId(this.userId);
        boardWriteForm.setText("test text");
        boardWriteForm.setTitle("test title");
        Long id = boardWriteService.write(boardWriteForm);

        BoardUpdateForm boardUpdateForm = new BoardUpdateForm();
        boardUpdateForm.setUserId(this.userId);
        boardUpdateForm.setId(id);
        boardUpdateForm.setText("update text");
        boardUpdateForm.setTitle("update title");
        boardUpdateService.update(boardUpdateForm);

        Board board = boardRepository.findById(id).get();
        assertThat(board.getText(), is(boardUpdateForm.getText()));
        assertThat(board.getTitle(), is(boardUpdateForm.getTitle()));
    }

    @Test
    void update_fail_because_UserNotEqual() throws Exception{
        BoardWriteForm boardWriteForm = new BoardWriteForm();
        boardWriteForm.setUserId(this.userId);
        boardWriteForm.setText("test text");
        boardWriteForm.setTitle("test title");
        Long id = boardWriteService.write(boardWriteForm);

        BoardUpdateForm boardUpdateForm = new BoardUpdateForm();
        boardUpdateForm.setUserId(this.userId + 1);
        boardUpdateForm.setId(id);
        boardUpdateForm.setText("update text");
        boardUpdateForm.setTitle("update title");

        try {
            boardUpdateService.update(boardUpdateForm);
            fail();
        }catch (Exception e){

        }
    }

    @Test
    void update_fail_because_BoardNotEqual() throws Exception{
        BoardWriteForm boardWriteForm = new BoardWriteForm();
        boardWriteForm.setUserId(this.userId);
        boardWriteForm.setText("test text");
        boardWriteForm.setTitle("test title");
        Long id = boardWriteService.write(boardWriteForm);

        BoardUpdateForm boardUpdateForm = new BoardUpdateForm();
        boardUpdateForm.setUserId(this.userId);
        boardUpdateForm.setId(id + 1);
        boardUpdateForm.setText("update text");
        boardUpdateForm.setTitle("update title");

        try {
            boardUpdateService.update(boardUpdateForm);
            fail();
        }catch (Exception e){

        }
    }
}