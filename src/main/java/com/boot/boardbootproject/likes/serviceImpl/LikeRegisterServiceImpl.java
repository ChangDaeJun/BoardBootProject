package com.boot.boardbootproject.likes.serviceImpl;

import com.boot.boardbootproject.board.Board;
import com.boot.boardbootproject.board.repository.BoardRepository;
import com.boot.boardbootproject.likes.Likes;
import com.boot.boardbootproject.likes.dto.LikeForm;
import com.boot.boardbootproject.likes.repository.LikeRepository;
import com.boot.boardbootproject.likes.service.LikeRegisterService;
import com.boot.boardbootproject.user.User;
import com.boot.boardbootproject.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class LikeRegisterServiceImpl implements LikeRegisterService {
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public void register(LikeForm form) throws Exception {
        User user = userRepository.findById(form.getUserId()).get();
        Board board = boardRepository.findById(form.getBoardId()).get();
        Likes likes = new Likes(user, board);
        likeRepository.save(likes);
    }
}
