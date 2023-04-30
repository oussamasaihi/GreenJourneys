package com.greenjourneys.services;

import com.greenjourneys.entities.Comment;
import com.greenjourneys.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceComment implements IComment{
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Comment AddComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void removeComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> GetAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public Comment GetComment(Long id) {
        return commentRepository.findById(id).get();
    }
}
