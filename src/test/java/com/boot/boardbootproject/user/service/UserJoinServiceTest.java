package com.boot.boardbootproject.user.service;

import com.boot.boardbootproject.user.User;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class UserJoinServiceTest {

    @Autowired
    private UserJoinService userJoinService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void join() {
        UserJoinForm form = new UserJoinForm();
        form.setEmail("testemail");
        form.setName("testname");
        form.setPassword("testpassword");

        Long id = userJoinService.join(form);

        User user = null;
        try {
            user = userRepository.findById(id).get();
        }catch (NoSuchElementException e){
            fail("생성된 유저를 찾지 못했습니다.");
        }

        assertThat(form.getEmail(), is(user.getEmail()));
        assertThat(form.getName(), is(user.getName()));
        assertThat(form.getPassword(), is(user.getPassword()));
    }

    @Test
    void join_fail_because_duplicate_email(){
        UserJoinForm form = new UserJoinForm();
        form.setEmail("testemail1");
        form.setName("testname");
        form.setPassword("testpassword");

        Long id = userJoinService.join(form);

        UserJoinForm form1 = new UserJoinForm();
        form.setEmail("testemail1");
        form.setName("testnameuiuii");
        form.setPassword("testpassuiuiuiword");

        try {
            Long id1 = userJoinService.join(form1);
            fail();
        }catch (Exception e){
        }
    }

    @Test
    void join_fail_because_duplicate_name(){
        UserJoinForm form = new UserJoinForm();
        form.setEmail("testemail");
        form.setName("testname");
        form.setPassword("testpassword");

        Long id = userJoinService.join(form);

        UserJoinForm form1 = new UserJoinForm();
        form.setEmail("testemail1212");
        form.setName("testname");
        form.setPassword("testpassuiuiuiword");

        try {
            Long id1 = userJoinService.join(form1);
            fail();
        }catch (Exception e){
        }
    }
}