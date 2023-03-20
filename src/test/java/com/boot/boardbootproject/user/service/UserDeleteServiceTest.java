package com.boot.boardbootproject.user.service;

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
        while (!userRepository.existsUserById(id)){
            id++;
        }

        try {
            userDeleteService.delete(id);
            fail();
        }catch (Exception e){
        }
    }
}