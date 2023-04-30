package com.greenjourneys.controller;

import com.greenjourneys.entities.Publication;
import com.greenjourneys.entities.Reaction;
import com.greenjourneys.services.IComment;
import com.greenjourneys.services.IReactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reactionCont")
@Tag(name = "ReactionCont", description = "Gestion des ReactionCont")

public class ReactionCont {
    @Autowired
    public IReactionService iReactionService;
    @Autowired
    private ReactionCont (IReactionService iReactionService){this.iReactionService = iReactionService;}
    @DeleteMapping("Reaction/{id}")
    public void removeReaction(@PathVariable("id") Long id) {
        iReactionService.removeReaction(id);
    }

    @PostMapping("/Reaction/update")
    @ResponseBody
    public Reaction updateReaction(@RequestBody Reaction reaction) {
        return iReactionService.updateReaction(reaction);
    }

    @GetMapping("/Reaction")
    @ResponseBody
    public List<Reaction> GetAllReaction() {
        return iReactionService.GetAllReaction();
    }

    @GetMapping("/Reaction/{id}")
    @ResponseBody
    public Reaction GetReaction (@PathVariable Long id) {
        return iReactionService.GetReaction(id);
    }

}
