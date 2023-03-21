package com.boot.boardbootproject.user.service;

import com.boot.boardbootproject.board.dto.BoardWriteForm;
import com.boot.boardbootproject.board.repository.BoardRepository;
import com.boot.boardbootproject.board.service.BoardWriteService;
import com.boot.boardbootproject.likes.dto.LikeForm;
import com.boot.boardbootproject.likes.repository.LikeRepository;
import com.boot.boardbootproject.likes.service.LikeRegisterService;
import com.boot.boardbootproject.user.dto.UserGetForm;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class UserDeleteServiceTest {

    @Autowired
    private UserDeleteService userDeleteService;
    @Autowired
    private UserJoinService userJoinService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BoardWriteService boardWriteService;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private LikeRegisterService likeRegisterService;

    @Test
    void delete() throws Exception{
        UserJoinForm form = new UserJoinForm();
        form.setEmail("testemailqq");
        form.setName("testnameqq");
        form.setPassword("testpasswordqq");

        Long id = userJoinService.join(form);

        boolean beforeDelete = userRepository.existsUserById(id);
        userDeleteService.delete(id);
        boolean afterDelete = userRepository.existsUserById(id);

        assertThat(beforeDelete, is(true));
        assertThat(afterDelete, is(false));
    }

    @Test
    void delete_fail_because_NotFoundId(){
        Long id = 1L;
        while (userRepository.existsUserById(id)){
            id++;
        }

        try {
            userDeleteService.delete(id);
            fail();
        }catch (Exception e){
        }
    }

    @Test
    void delete_with_board() throws Exception{
        UserJoinForm form = new UserJoinForm();
        form.setEmail("testemailqqaa");
        form.setName("testnameqqaa");
        form.setPassword("testpasswoaaardqq");
        Long id = userJoinService.join(form);

        BoardWriteForm boardWriteForm = new BoardWriteForm();
        boardWriteForm.setUserId(id);
        boardWriteForm.setText("test text");
        boardWriteForm.setTitle("test title");
        Long boardId = boardWriteService.write(boardWriteForm);

        boolean beforeUser = userRepository.existsUserById(id);
        boolean beforeBoard = boardRepository.existsById(boardId);
        userDeleteService.delete(id);
        boolean afterUser = userRepository.existsUserById(id);
        boolean afterBoard = boardRepository.existsById(boardId);

        assertThat(beforeUser, is(true));
        assertThat(afterUser, is(false));
        assertThat(beforeBoard, is(true));
        assertThat(afterBoard, is(false));
    }

   @Test
    void delete_with_like() throws Exception{
        UserJoinForm form = new UserJoinForm();
        form.setEmail("testemailqqaa");
        form.setName("testnameqqaa");
        form.setPassword("testpasswoaaardqq");
        Long id = userJoinService.join(form);

        UserJoinForm form1 = new UserJoinForm();
        form1.setEmail("testemailqqaa");
        form1.setName("testnameqqaa");
        form1.setPassword("testpasswoaaardqq");
        Long id1 = userJoinService.join(form1);

        BoardWriteForm boardWriteForm = new BoardWriteForm();
        boardWriteForm.setUserId(id1);
        boardWriteForm.setText("test text");
        boardWriteForm.setTitle("test title");
        Long boardId = boardWriteService.write(boardWriteForm);

        LikeForm likeForm = new LikeForm();
        likeForm.setBoardId(boardId);
        likeForm.setUserId(id);
        likeRegisterService.register(likeForm);

       boolean beforeUser = userRepository.existsUserById(id);
       boolean beforeLike = likeRepository.existsByUserIdAndBoardId(id, boardId);
       userDeleteService.delete(id);
       boolean afterUser = userRepository.existsUserById(id);
       boolean afterLike = likeRepository.existsByUserIdAndBoardId(id, boardId);

       assertThat(beforeUser, is(true));
       assertThat(afterUser, is(false));
       assertThat(beforeLike, is(true));
       assertThat(afterLike, is(false));
    }
}