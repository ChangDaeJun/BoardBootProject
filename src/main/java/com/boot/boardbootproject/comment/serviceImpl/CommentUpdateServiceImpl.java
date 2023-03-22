package com.boot.boardbootproject.comment.serviceImpl;

import com.boot.boardbootproject.comment.Comment;
import com.boot.boardbootproject.comment.dto.CommentUpdateForm;
import com.boot.boardbootproject.comment.repository.CommentRepository;
import com.boot.boardbootproject.comment.service.CommentUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CommentUpdateServiceImpl implements CommentUpdateService {
    private CommentRepository commentRepository;

    @Override
    @Transactional
    public void update(CommentUpdateForm form) throws Exception {
        Comment comment = commentRepository.findById(form.getId()).get();
        comment.update(form);
    }
}
