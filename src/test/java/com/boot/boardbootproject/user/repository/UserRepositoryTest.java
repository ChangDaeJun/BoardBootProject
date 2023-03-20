package com.boot.boardbootproject.user.repository;

import com.boot.boardbootproject.Util.DateFormat;
import com.boot.boardbootproject.user.dto.UserGetForm;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.service.UserJoinService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserJoinService userJoinService;
    @Test
    void findGetFormById() throws Exception{
        UserJoinForm form = new UserJoinForm();
        form.setEmail("aaaaaa");
        form.setName("testnaaaa");
        form.setPassword("testpasaaaword");

        Long id = userJoinService.join(form);

        UserGetForm form1 = userRepository.findGetFormById(id);

        assertThat(form1.getId(), is(id));
        assertThat(form1.getName(), is(form.getName()));
        assertThat(form1.getCreateDate(), is(DateFormat.getYYYYMMdd(new Date(System.currentTimeMillis()))));
    }
}