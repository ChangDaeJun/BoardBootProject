package com.boot.boardbootproject.user.serviceImpl;

import com.boot.boardbootproject.user.User;
import com.boot.boardbootproject.user.dto.UserUpdateNameForm;
import com.boot.boardbootproject.user.dto.UserUpdatePasswordForm;
import com.boot.boardbootproject.user.repository.UserRepository;
import com.boot.boardbootproject.user.service.UserUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserUpdateServiceImpl implements UserUpdateService {
    private final UserRepository userRepository;
    @Override
    @Transactional
    public void updatePassword(UserUpdatePasswordForm form) throws Exception{
        validate(form);
        User user = userRepository.findById(form.getId()).get();
        user.setPassword(form.getPassword());
    }

    private void validate(UserUpdatePasswordForm form) throws Exception{
        if(!userRepository.existsUserById(form.getId())) throw new Exception();
    }

    @Override
    @Transactional
    public void updateName(UserUpdateNameForm form) throws Exception{
        validate(form);
        User user = userRepository.findById(form.getId()).get();
        user.setName(form.getName());
    }

    private void validate(UserUpdateNameForm form) throws Exception{
        if(!userRepository.existsUserById(form.getId())) throw new Exception();
        else if(userRepository.existsUserByName(form.getName())) throw new Exception();
    }
}
