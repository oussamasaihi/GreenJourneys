package com.greenjourneys.controller;

import com.greenjourneys.entities.Comment;
import com.greenjourneys.services.IComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Comment")
@CrossOrigin(origins = "*")
public class CommentCont {
    @Autowired
    private final IComment iComment;

    public CommentCont(IComment iComment){
        this.iComment = iComment;
    }

    @DeleteMapping("Delete/{id}")
    public void removeComment( @PathVariable("id") Long id) {
        iComment.removeComment(id);
    }

    @PostMapping("/comments/update")
    @ResponseBody
    public Comment updateComment(@RequestBody Comment comment) {
        return iComment.updateComment(comment);
    }

    @GetMapping("/comments")
    @ResponseBody
    public List<Comment> GetAllComment() {
        return iComment.GetAllComment();
    }

    @GetMapping("/comments/{id}")
    @ResponseBody
    public Comment GetComment( @PathVariable Long id) {
        return iComment.GetComment(id);
    }

    @PostMapping("/publications/{publicationId}/comments")
    public Comment addCommentToPublication( @PathVariable Long publicationId, @RequestBody Comment comment) {
        return iComment.AddComment(publicationId, comment);
    }
}
