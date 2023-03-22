package com.boot.boardbootproject.likes.serviceImpl;

import com.boot.boardbootproject.likes.dto.LikeBoardListForm;
import com.boot.boardbootproject.likes.dto.LikeUserListForm;
import com.boot.boardbootproject.likes.repository.LikeRepository;
import com.boot.boardbootproject.likes.service.LikeGetService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LikeGetServiceImpl implements LikeGetService {
    private final LikeRepository likeRepository;
    @Override
    public LikeBoardListForm getByUserId(Long userId) {
        List<Long> likeBoardIdList = likeRepository.findIdByUserId(userId);
        return new LikeBoardListForm(userId, likeBoardIdList);
    }

    @Override
    public LikeUserListForm getByBoardId(Long boardId) {
        List<Long> likeUserIdList = likeRepository.findIdByBoardId(boardId);
        return new LikeUserListForm(boardId, likeUserIdList);
    }
}
