package com.boot.boardbootproject.board.serviceImpl;

import com.boot.boardbootproject.board.Board;
import com.boot.boardbootproject.board.repository.BoardRepository;
import com.boot.boardbootproject.board.service.BoardDeleteService;
import com.boot.boardbootproject.likes.repository.LikeRepository;
import com.boot.boardbootproject.likes.service.LikeCancelService;
import com.boot.boardbootproject.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardDeleteServiceImpl implements BoardDeleteService {
    private final BoardRepository boardRepository;
    private final LikeCancelService likeCancelService;
    @Override
    @Transactional
    public void deleteById(Long id) throws Exception {
        likeCancelService.cancelByBoardId(id);
        boardRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByUserId(Long userId) throws Exception {
        List<Long> boardIdList = boardRepository.findIdByUserId(userId);
        for(Long boardId : boardIdList){
            deleteById(boardId);
        }
    }
}
