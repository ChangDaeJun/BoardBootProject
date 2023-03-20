package com.boot.boardbootproject.user.service;

import com.boot.boardbootproject.Util.DateFormat;
import com.boot.boardbootproject.user.dto.UserGetForm;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class UserGetServiceTest {

    @Autowired
    private UserGetService userGetService;
    @Autowired
    private UserJoinService userJoinService;
    @Autowired
    private UserRepository userRepository;

    @Test
    void getById_one() throws Exception{
        UserJoinForm form = new UserJoinForm();
        form.setEmail("testemail12");
        form.setName("testname12");
        form.setPassword("testpassword12");

        Long id = userJoinService.join(form);

        UserGetForm userForm = userGetService.getById(id);
        assertThat(userForm.getId(), is(id));
        assertThat(userForm.getName(), is(form.getName()));
        assertThat(userForm.getCreateDate(), is(notNullValue()));
    }

    @Test
    void getById_compare_another() throws Exception{
        UserJoinForm form1 = new UserJoinForm();
        form1.setEmail("testemkkail123");
        form1.setName("testnkkame123");
        form1.setPassword("testpakkssword123");
        Long id1 = userJoinService.join(form1);

        UserJoinForm form2 = new UserJoinForm();
        form2.setEmail("testellllmail124");
        form2.setName("testjjjjname124");
        form2.setPassword("testpkjkjkassword124");
        Long id2 = userJoinService.join(form2);

        UserGetForm userForm1 = userGetService.getById(id1);
        UserGetForm userForm2 = userGetService.getById(id2);

        assertThat(userForm1.getId(), is(not(userForm2.getId())));
        assertThat(userForm1.getName(), is(not(userForm2.getName())));
        assertThat(userForm1.getCreateDate(), is(userForm2.getCreateDate()));//생성일은 동일해야 함.
    }

    @Test
    void check_createDateForm() throws Exception{
        UserJoinForm form1 = new UserJoinForm();
        form1.setEmail("testedfdmkkailaa");
        form1.setName("tesdddtnkkameaa");
        form1.setPassword("testpddakksswordaa");
        Long id1 = userJoinService.join(form1);

        UserGetForm userForm1 = userGetService.getById(id1);

        String now = DateFormat.getYYYYMMdd(new Date(System.currentTimeMillis()));

        assertThat(userForm1.getCreateDate(), is(now));
    }

    @Test
    void notFound(){
        Long id = 1L;
        while (userRepository.existsUserById(id)){
            id++;
        }

        UserGetForm userGetForm = userGetService.getById(id);

        assertThat(userGetForm, is(nullValue()));
    }
}