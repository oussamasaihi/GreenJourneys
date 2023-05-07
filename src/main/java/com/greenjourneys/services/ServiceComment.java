package com.greenjourneys.services;

import com.greenjourneys.entities.Comment;
import com.greenjourneys.entities.Publication;
import com.greenjourneys.repositories.CommentRepository;
import com.greenjourneys.repositories.IPublication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ServiceComment implements IComment{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private IPublication publicationRepository;




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

    @Override
    public List<Comment> getCommentsByPublicationId(Long publicationId) {
        return commentRepository.findByPublicationId(publicationId);
    }
    @Override
    public Comment AddComment(Long publicationId, Comment comment) {
        if (comment == null || comment.getContent() == null) {
            return null;
        }

        String content = comment.getContent();
        // replace bad words with stars
        String filteredContent = filterBadWords(content);
        comment.setContent(filteredContent);

        Publication publication = publicationRepository.findById(publicationId).orElse(null);
        if (publication == null) {
            return null; // or throw a custom exception or return some default value
        }
        comment.setPublication(publication);

        return commentRepository.save(comment);
    }

    public String filterBadWords(String content) {
        List<String> badWords = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\houssem\\Documents\\badwords.txt"))) {
            badWords = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filteredContent = content;
        for (String word : badWords) {
            if (word != null && !word.isEmpty()) {
                filteredContent = filteredContent.replaceAll(word, "*".repeat(word.length()));
            }
        }
        return filteredContent;
    }


}
