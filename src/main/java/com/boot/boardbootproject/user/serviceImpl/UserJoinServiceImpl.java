package com.boot.boardbootproject.user.serviceImpl;

import com.boot.boardbootproject.user.User;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.repository.UserRepository;
import com.boot.boardbootproject.user.service.UserJoinService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserJoinServiceImpl implements UserJoinService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Long join(UserJoinForm form) throws Exception{
        validateDuplication(form);
        User user = new User(form);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplication(UserJoinForm form) throws Exception{
        String email = form.getEmail();
        String name = form.getName();
        if(userRepository.existsUserByName(name)) throw new Exception();
        else if(userRepository.existsUserByEmail(email)) throw new Exception();
    }
}
