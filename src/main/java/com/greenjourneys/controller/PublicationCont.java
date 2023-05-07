package com.greenjourneys.controller;

import com.greenjourneys.entities.Comment;
import com.greenjourneys.entities.Publication;
import com.greenjourneys.entities.React;
import com.greenjourneys.services.IComment;
import com.greenjourneys.services.IPublicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publication")
public class PublicationCont {

    @Autowired
    public IPublicationService iPublicationService;
    @Autowired
    public IComment iComment;

    @PostMapping("Add")
    public Publication AddPublication(@RequestBody Publication publication) {
        return iPublicationService.AddPublication(publication);
    }

    @DeleteMapping("Delete/{id}")
    public void removePublication( @PathVariable("id") Long id) {
        iPublicationService.removePublication(id);
    }

    @PostMapping("/Publication/update")
    public Publication updatePublication(@RequestBody Publication publication) {
        return iPublicationService.updatePublication(publication);

    }

    @GetMapping("/Publication/{id}/comments")
    public List<Comment> getCommentsByPublicationId(@PathVariable Long id) {
        return iComment.getCommentsByPublicationId(id);
    }

    @GetMapping("/Publication")
    public List<Publication> GetAllPublication() {
        return iPublicationService.GetAllPublication();
    }

    @GetMapping("/Publication/{id}")
    public Publication GetPublication(@PathVariable Long id) {
        return iPublicationService.GetPublication(id);
    }
    @PostMapping("/Publication/{id}/addReaction")
    @ResponseBody
    public Publication addReactionToPublication(@PathVariable Long id, @RequestBody React react) {
        Publication publication = iPublicationService.GetPublication(id);
        publication.addReaction(react);
        return iPublicationService.updatePublication(publication);
    }

}
