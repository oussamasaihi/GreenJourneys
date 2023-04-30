package com.greenjourneys.controller;

import com.greenjourneys.entities.Comment;
import com.greenjourneys.services.IComment;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Comment")
@Tag(name = "Comment", description = "Gestion des commentaires")
public class CommentCont {
    @Autowired
    public IComment iComment;
    @Autowired
    private CommentCont(IComment iComment){this.iComment = iComment;}

   @PostMapping("Add")
    public Comment AddComment(@RequestBody Comment comment) {
        return iComment.AddComment(comment);
    }

    @DeleteMapping("Delete/{id}")
    public void removeComment(@PathVariable("id") Long id) {
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
    public Comment GetComment(@PathVariable Long id) {
        return iComment.GetComment(id);
    }
}
