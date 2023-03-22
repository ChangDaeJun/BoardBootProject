package com.boot.boardbootproject.user.serviceImpl;

import com.boot.boardbootproject.board.service.BoardDeleteService;
import com.boot.boardbootproject.likes.service.LikeCancelService;
import com.boot.boardbootproject.user.User;
import com.boot.boardbootproject.user.repository.UserRepository;
import com.boot.boardbootproject.user.service.UserDeleteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserDeleteServiceImpl implements UserDeleteService {
    private final UserRepository userRepository;
    private final BoardDeleteService boardDeleteService;
    private final LikeCancelService likeCancelService;
    @Override
    @Transactional
    public void delete(Long userId) throws Exception{
        User user = userRepository.findById(userId).get();
        boardDeleteService.deleteByUserId(userId);
        likeCancelService.cancelByUserId(userId);
        userRepository.delete(user);
    }
}
