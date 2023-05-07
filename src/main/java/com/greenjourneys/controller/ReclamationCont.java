package com.greenjourneys.controller;

import com.greenjourneys.entities.Reclamation;
import com.greenjourneys.services.ReclamationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Reclamation")
@CrossOrigin(origins = {"*"})
public class ReclamationCont {


    private final ReclamationService reclamationService;
    /****************************ajout mta3 reclamation wa7da ***********************/


    @PostMapping("addRec")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation){
        return reclamationService.saveReclamation(reclamation);
    }

    /********************************Update Reclamation************************************/


    @PutMapping("updateRec/{id}")
    public Reclamation updateReclamation(@RequestBody Reclamation reclamation, @PathVariable("id") Long id){
        return reclamationService.updateReclamation(reclamation,id);
    }

    /********************************Delete Reclamation By Id************************************/




    @DeleteMapping("deleteByIdRec/{id}")
    public void deleteRecById(@PathVariable("id") Long id){
        reclamationService.deleteReclamationById(id);
    }


    /********************************Get Reclamations************************************/




    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("listeReclamations")
    public List<Reclamation> getRecalamations(){
        return reclamationService.getReclamations();
    }

    /********************************Get Reclamations Non Traitees************************************/




    @GetMapping("listeReclamationsNonTraitees")
    public List<Reclamation> listeReclamationsNonTraitees(){
        List<Reclamation> liste =reclamationService.listeReclamationsNonTratitees();
        return liste;
    }
    /********************************Get Reclamations Traitees************************************/

    @GetMapping("listeReclamationsTraitees")
    public List<Reclamation> listeReclamationsTraitees(){
        List<Reclamation> liste =reclamationService.listeReclamationsTratitees();
        return liste;
    }

    /********************************Traiter Reclamation************************************/






    @PutMapping("RecTrue/{id}")
    public  void TraiterRec(@PathVariable("id") Long id,@RequestBody Reclamation  reclamation){
        reclamationService.traiterRec(id, reclamation);
    }


}
