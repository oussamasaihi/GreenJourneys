package com.greenjourneys.services;

import com.greenjourneys.entities.Comment;

import java.io.Serializable;
import java.util.List;
public interface IComment extends Serializable {

    public void removeComment(Long id);
    public Comment updateComment(Comment comment);
    public List<Comment> GetAllComment();
    public Comment GetComment(Long id);

    abstract List<Comment> getCommentsByPublicationId(Long publicationId);
    public Comment AddComment(Long publicationId, Comment comment);
    public String filterBadWords(String content);



}
