package com.boot.boardbootproject.board.serviceImpl;

import com.boot.boardbootproject.board.Board;
import com.boot.boardbootproject.board.repository.BoardRepository;
import com.boot.boardbootproject.board.service.BoardDeleteService;
import com.boot.boardbootproject.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardDeleteServiceImpl implements BoardDeleteService {
    private final BoardRepository boardRepository;
    @Override
    public void deleteById(Long id) throws Exception {
        boardRepository.deleteById(id);
    }

    @Override
    public void deleteByUserId(Long userId) throws Exception {
        List<Long> boardIdList = boardRepository.findIdByUserId(userId);
        for(Long boardId : boardIdList){
            deleteById(boardId);
        }
    }
}
