package com.greenjourneys.controller;
import com.greenjourneys.entities.Comment;
import com.greenjourneys.entities.Publication;
import com.greenjourneys.services.IComment;
import com.greenjourneys.services.IPublicationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publication")
@Tag(name = "publication", description = "Gestion des Publication")

public class PublicationCont {
    @Autowired
    public IPublicationService iPublicationService;
    @Autowired
    private PublicationCont(IPublicationService iPublicationService){this.iPublicationService = iPublicationService;}
    @PostMapping("Add")
    public Publication AddPublication(@RequestBody Publication publication) {
        return iPublicationService.AddPublication(publication);
    }
    @DeleteMapping("Delete/{id}")
    public void removePublication(@PathVariable("id") Long id) {
        iPublicationService.removePublication(id);
    }

    @PostMapping("/Publication/update")
    @ResponseBody
    public Publication updatePublication(@RequestBody Publication comment) {
        return iPublicationService.updatePublication(comment);

    }


    @GetMapping("/Publication")
    @ResponseBody
    public List<Publication> GetAllPublication() {
        return iPublicationService.GetAllPublication();
    }

    @GetMapping("/Publication/{id}")
    @ResponseBody
    public Publication GetPublication(@PathVariable Long id) {
        return iPublicationService.GetPublication(id);
    }
}
