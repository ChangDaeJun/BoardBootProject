package com.boot.boardbootproject.comment.serviceImpl;

import com.boot.boardbootproject.comment.Comment;
import com.boot.boardbootproject.comment.repository.CommentRepository;
import com.boot.boardbootproject.comment.service.CommentDeleteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentDeleteServiceImpl implements CommentDeleteService {
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByUserId(Long userId) {
        List<Long> ids = commentRepository.findIdByUserId(userId);
        for(Long id : ids){
            deleteById(id);
        }
    }

    @Override
    @Transactional
    public void deleteByBoardId(Long boardId) {
        List<Long> ids = commentRepository.findIdByBoardId(boardId);
        for(Long id : ids){
            deleteById(id);
        }
    }
}
