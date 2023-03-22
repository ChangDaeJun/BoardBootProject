package com.boot.boardbootproject.likes.serviceImpl;

import com.boot.boardbootproject.board.Board;
import com.boot.boardbootproject.board.repository.BoardRepository;
import com.boot.boardbootproject.likes.Likes;
import com.boot.boardbootproject.likes.dto.LikeForm;
import com.boot.boardbootproject.likes.repository.LikeRepository;
import com.boot.boardbootproject.likes.service.LikeCancelService;
import com.boot.boardbootproject.user.User;
import com.boot.boardbootproject.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class LikeCancelServiceImpl implements LikeCancelService {
    private final LikeRepository likeRepository;

    @Override
    @Transactional
    public void cancel(LikeForm form) throws Exception {
        Likes likes = likeRepository.findByUserIdAndBoardId(form.getUserId(), form.getBoardId());
        delete(likes);
    }

    private void delete(Likes likes){
        likeRepository.delete(likes);
    }

    private void cancel(Long id){
        Likes likes = likeRepository.findById(id).get();
        delete(likes);
    }

    @Override
    @Transactional
    public void cancelByUserId(Long userId) throws Exception {
        List<Long> ids = likeRepository.findIdByUserId(userId);
        for(Long id : ids){
            cancel(id);
        }
    }

    @Override
    @Transactional
    public void cancelByBoardId(Long boardId) throws Exception {
        List<Long> ids = likeRepository.findIdByBoardId(boardId);
        for(Long id : ids){
            cancel(id);
        }
    }
}
