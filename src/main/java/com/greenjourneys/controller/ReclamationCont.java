package com.greenjourneys.controller;

import com.greenjourneys.entities.Reclamation;
import com.greenjourneys.repositories.IReclamation;
import com.greenjourneys.services.ReclamationService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("Reclamation")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Reclamation", description = "Gestion des reclamations")
public class ReclamationCont {

    @Autowired
    ReclamationService reclamationService;
    /****************************ajout mta3 reclamation wa7da ***********************/
    @Operation(summary = "Add Reclamation", description = "Ajouter une nouvelle reclamation ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add successfully",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Reclamation.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Add failed",content = @Content)
    })
    @PostMapping("addRec")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation){
        return reclamationService.saveReclamation(reclamation);
    }

    /************Ajout mta3 lista mta3 reclamationet***********************/
    @Operation(summary = "Add Reclamation", description = "Ajouter une liste de reclamations ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add successfully",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Reclamation.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Add failed",content = @Content)
    })
    @PostMapping("addListRec")
    public List<Reclamation> addReclamations(@RequestBody List<Reclamation> listReclamations){
        return reclamationService.saveReclamations(listReclamations);
    }
}
