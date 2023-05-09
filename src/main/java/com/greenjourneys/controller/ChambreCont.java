package com.greenjourneys.controller;

import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.Chambre;
import com.greenjourneys.entities.File;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.repositories.IFile;
import com.greenjourneys.services.ChambreService;
import com.greenjourneys.services.IChambreService;
import com.greenjourneys.services.IFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/Chambre")
@RequiredArgsConstructor
public class ChambreCont extends GenericController<Chambre,Long> {

    private final IChambreService iChambreService;
    private final IFileService fileService;
    @Autowired
    IFile iFile;

    @CrossOrigin(origins = "*")
    @GetMapping("{AncienPrix}/{IdCh}/{Option}/{nbEnfants}")
    public Long CalculPrixTotal(@PathVariable Long AncienPrix,@PathVariable Long IdCh,@PathVariable String Option,@PathVariable int nbEnfants) {
        return iChambreService.CalculPrixTotal(AncienPrix,IdCh,Option,nbEnfants);
    }
    @PutMapping("/{IdCh}/{IdAcc}")
    public Chambre AssignChambreToAcco(@PathVariable Long IdCh, @PathVariable Long IdAcc) {
        return iChambreService.AssignChambreToAcco(IdCh, IdAcc);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/prix/{nbchilds}/{Option}")
    public Long PrixChambresTotale(@RequestBody List<Chambre> chs,@PathVariable List<Integer> nbchilds,@PathVariable String Option) {
        return iChambreService.PrixChambresTotale(chs,nbchilds,Option);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public Chambre add(@RequestParam MultipartFile file, Chambre chambre) {
        String message = "";
        try {
            fileService.store(file);
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            File file1 = new File(filename, file.getContentType(), file.getBytes());
            iFile.save(file1);
            chambre.setFileid(file1.getId());
            message = "Upload file successfully" + file.getOriginalFilename();
            iChambreService.add(chambre);
        }
        catch (IOException e) {
        }
        return chambre;
    }
}
