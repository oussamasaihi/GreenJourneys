package com.greenjourneys.services;

import com.greenjourneys.entities.Comment;

import java.io.Serializable;
import java.util.List;
public interface IComment extends Serializable {
    public Comment AddComment(Comment comment);
    public void removeComment(Long id);
    public Comment updateComment(Comment comment);
    public List<Comment> GetAllComment();
    public Comment GetComment(Long id);
}
