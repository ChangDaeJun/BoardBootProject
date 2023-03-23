package com.boot.boardbootproject.user.serviceImpl;

import com.boot.boardbootproject.user.dto.UserGetForm;
import com.boot.boardbootproject.user.dto.UserLoginForm;
import com.boot.boardbootproject.user.repository.UserRepository;
import com.boot.boardbootproject.user.service.UserGetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserGetServiceImpl implements UserGetService {

    private final UserRepository userRepository;

    @Override
    public UserGetForm getById(Long id){
        return userRepository.findGetFormById(id);
    }

    @Override
    public UserGetForm getByLogin(UserLoginForm form) {
        UserGetForm user = userRepository.findGetFormByEmailAndPassword(form.getEmail(), form.getPassword());
        return user;
    }
}
