package com.greenjourneys.controller;

import com.greenjourneys.entities.Reaction;
import com.greenjourneys.services.IReactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    private ReactionCont (IReactionService iReactionService) {
        this.iReactionService = iReactionService;
    }

    @DeleteMapping("/Reaction/{id}")
    @Operation(summary = "Supprimer une réaction", description = "Supprimer une réaction en utilisant l'ID de la réaction.")
    public void removeReaction(@Parameter(description = "ID de la réaction à supprimer") @PathVariable("id") Long id) {
        iReactionService.removeReaction(id);
    }

    @PostMapping("/Reaction/update")
    @ResponseBody
    @Operation(summary = "Mettre à jour une réaction", description = "Mettre à jour une réaction en utilisant une requête HTTP POST.")
    public Reaction updateReaction(@RequestBody Reaction reaction) {
        return iReactionService.updateReaction(reaction);
    }

    @GetMapping("/Reaction")
    @ResponseBody
    @Operation(summary = "Récupérer toutes les réactions", description = "Récupérer une liste de toutes les réactions.")
    public List<Reaction> GetAllReaction() {
        return iReactionService.GetAllReaction();
    }

    @GetMapping("/Reaction/{id}")
    @ResponseBody
    @Operation(summary = "Récupérer une réaction", description = "Récupérer une réaction en utilisant l'ID de la réaction.")
    public Reaction GetReaction(@Parameter(description = "ID de la réaction à récupérer") @PathVariable Long id) {
        return iReactionService.GetReaction(id);
    }
}
