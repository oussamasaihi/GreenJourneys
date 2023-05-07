package com.greenjourneys.controller;

import com.greenjourneys.entities.Comment;
import com.greenjourneys.services.IComment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Comment")
@Tag(name = "Comment", description = "Gestion des commentaires")
public class CommentCont {
    @Autowired
    private final IComment iComment;

    public CommentCont(IComment iComment){
        this.iComment = iComment;
    }

    @DeleteMapping("Delete/{id}")
    @Operation(summary = "Supprimer un commentaire", description = "Supprime un commentaire avec l'ID spécifié.")
    public void removeComment(@Parameter(description = "ID du commentaire à supprimer.") @PathVariable("id") Long id) {
        iComment.removeComment(id);
    }

    @PostMapping("/comments/update")
    @ResponseBody
    @Operation(summary = "Mettre à jour un commentaire", description = "Met à jour le contenu d'un commentaire avec le contenu fourni.")
    @ApiResponse(responseCode = "200", description = "Commentaire mis à jour avec succès.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Comment.class)))
    public Comment updateComment(@RequestBody Comment comment) {
        return iComment.updateComment(comment);
    }

    @GetMapping("/comments")
    @ResponseBody
    @Operation(summary = "Obtenir tous les commentaires", description = "Retourne une liste de tous les commentaires dans la base de données.")
    @ApiResponse(responseCode = "200", description = "Liste de tous les commentaires.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Comment.class)))
    public List<Comment> GetAllComment() {
        return iComment.GetAllComment();
    }

    @GetMapping("/comments/{id}")
    @ResponseBody
    @Operation(summary = "Obtenir un commentaire", description = "Retourne le commentaire avec l'ID spécifié.")
    @ApiResponse(responseCode = "200", description = "Commentaire trouvé avec succès.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Comment.class)))
    public Comment GetComment(@Parameter(description = "ID du commentaire à récupérer.") @PathVariable Long id) {
        return iComment.GetComment(id);
    }

    @PostMapping("/publications/{publicationId}/comments")
    @Operation(summary = "Ajouter un commentaire à une publication", description = "Ajoute un commentaire à la publication avec l'ID spécifié.")
    @ApiResponse(responseCode = "200", description = "Commentaire ajouté avec succès.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Comment.class)))
    public Comment addCommentToPublication(@Parameter(description = "ID de la publication à laquelle ajouter le commentaire.") @PathVariable Long publicationId, @RequestBody Comment comment) {
        return iComment.AddComment(publicationId, comment);
    }
}
