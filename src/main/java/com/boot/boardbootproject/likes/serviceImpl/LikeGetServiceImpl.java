package com.boot.boardbootproject.likes.serviceImpl;

import com.boot.boardbootproject.likes.dto.LikeBoardIdListByUserForm;
import com.boot.boardbootproject.likes.dto.LikeForm;
import com.boot.boardbootproject.likes.dto.LikeUserIdListOnBoardForm;
import com.boot.boardbootproject.likes.repository.LikeRepository;
import com.boot.boardbootproject.likes.service.LikeGetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LikeGetServiceImpl implements LikeGetService {
    private final LikeRepository likeRepository;
    @Override
    public LikeBoardIdListByUserForm getByUserId(Long userId) {
        List<Long> likeBoardIdList = likeRepository.findIdByUserId(userId);
        return new LikeBoardIdListByUserForm(userId, likeBoardIdList);
    }

    @Override
    public LikeUserIdListOnBoardForm getByBoardId(Long boardId) {
        List<Long> likeUserIdList = likeRepository.findIdByBoardId(boardId);
        return new LikeUserIdListOnBoardForm(boardId, likeUserIdList);
    }

    @Override
    public boolean isLike(LikeForm form) {
        return likeRepository.existsByUserIdAndBoardId(form.getUserId(), form.getBoardId());
    }
}
