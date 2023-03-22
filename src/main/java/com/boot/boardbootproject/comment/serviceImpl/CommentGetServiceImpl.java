package com.boot.boardbootproject.comment.serviceImpl;

import com.boot.boardbootproject.comment.dto.CommentGetForm;
import com.boot.boardbootproject.comment.dto.CommentListByUserForm;
import com.boot.boardbootproject.comment.dto.CommentListOnBoardFrom;
import com.boot.boardbootproject.comment.repository.CommentRepository;
import com.boot.boardbootproject.comment.service.CommentGetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentGetServiceImpl implements CommentGetService {
    private final CommentRepository commentRepository;
    @Override
    public CommentListOnBoardFrom getCommentByBoardId(Long boardId) {
        List<CommentGetForm> list = commentRepository.findGetFormByBoardId(boardId);
        return new CommentListOnBoardFrom(boardId, list);
    }

    @Override
    public CommentListByUserForm getCommentByUserId(Long userId) {
        List<CommentGetForm> list = commentRepository.findGetFormByUserId(userId);
        return new CommentListByUserForm(userId, list);
    }
}
