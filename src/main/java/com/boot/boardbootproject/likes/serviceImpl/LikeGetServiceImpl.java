package com.boot.boardbootproject.likes.serviceImpl;

import com.boot.boardbootproject.board.dto.BoardGetForm;
import com.boot.boardbootproject.board.service.BoardGetService;
import com.boot.boardbootproject.likes.dto.LikeBoardListByUserForm;
import com.boot.boardbootproject.likes.dto.LikeForm;
import com.boot.boardbootproject.likes.dto.LikeUserIdListOnBoardForm;
import com.boot.boardbootproject.likes.repository.LikeRepository;
import com.boot.boardbootproject.likes.service.LikeGetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LikeGetServiceImpl implements LikeGetService {
    private final LikeRepository likeRepository;
    private final BoardGetService boardGetService;
    @Override
    public LikeBoardListByUserForm getByUserId(Long userId) {
        List<Long> likeBoardIdList = likeRepository.findIdByUserId(userId);
        List<BoardGetForm> list = new ArrayList<>();
        for(Long id : likeBoardIdList) list.add(boardGetService.getById(id));
        return new LikeBoardListByUserForm(userId, list);
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
