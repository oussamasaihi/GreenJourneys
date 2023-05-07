package com.greenjourneys.controller;

import com.greenjourneys.entities.Comment;
import com.greenjourneys.entities.Publication;
import com.greenjourneys.entities.React;
import com.greenjourneys.services.IComment;
import com.greenjourneys.services.IPublicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publication")
@Tag(name = "Publication", description = "Operations related to Publication")
public class PublicationCont {

    @Autowired
    public IPublicationService iPublicationService;
    @Autowired
    public IComment iComment;

    @PostMapping("Add")
    @Operation(summary = "Add a new publication")
    public Publication AddPublication(@RequestBody Publication publication) {
        return iPublicationService.AddPublication(publication);
    }

    @DeleteMapping("Delete/{id}")
    @Operation(summary = "Delete a publication by ID")
    public void removePublication(@Parameter(description = "ID of the publication to delete") @PathVariable("id") Long id) {
        iPublicationService.removePublication(id);
    }

    @PostMapping("/Publication/update")
    @Operation(summary = "Update a publication")
    public Publication updatePublication(@RequestBody Publication publication) {
        return iPublicationService.updatePublication(publication);

    }

    @GetMapping("/Publication/{id}/comments")
    @Operation(summary = "Get all comments for a publication")
    public List<Comment> getCommentsByPublicationId(@Parameter(description = "ID of the publication to retrieve comments for") @PathVariable Long id) {
        return iComment.getCommentsByPublicationId(id);
    }

    @GetMapping("/Publication")
    @Operation(summary = "Get all publications")
    public List<Publication> GetAllPublication() {
        return iPublicationService.GetAllPublication();
    }

    @GetMapping("/Publication/{id}")
    @Operation(summary = "Get a publication by ID")
    public Publication GetPublication(@Parameter(description = "ID of the publication to retrieve") @PathVariable Long id) {
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
