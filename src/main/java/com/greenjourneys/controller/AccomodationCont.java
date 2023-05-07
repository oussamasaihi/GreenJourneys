package com.greenjourneys.controller;

import com.greenjourneys.entities.*;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.message.ResponseMessage;
import com.greenjourneys.repositories.IFile;
import com.greenjourneys.services.IAccomodationService;
import com.greenjourneys.services.IFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/accomodation")
@RequiredArgsConstructor
public class AccomodationCont extends GenericController<Accomodation,Long> {
    private final IAccomodationService iAccomodationService;
    private final IFileService fileService;
    @Autowired
    IFile iFile;

    @GetMapping("/chambresvides/{IdAcc}/{DateDebRes}/{DateFinRes}")
    Set<Chambre> getAllChambresVides(@PathVariable Long IdAcc, @PathVariable LocalDate DateDebRes, @PathVariable LocalDate DateFinRes) {
        return iAccomodationService.getAllChambresVides(IdAcc, DateDebRes, DateFinRes);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/DispoAccomodations/{ville}/{DateDeb}/{DateFin}/{typeschambres}")
    public Set<Accomodation> getAllDispoAcc(@PathVariable String ville, @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable LocalDate DateDeb, @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable LocalDate DateFin, @PathVariable List<TypeCh> typeschambres) {
        return iAccomodationService.getAllDispoAcc(ville, DateDeb, DateFin, typeschambres);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/Disporooms/{ida}/{DateDeb}/{DateFin}/{typeschambres}")
    public Set<Chambre> verifierdiponibilitechambres(@PathVariable Long ida, @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable LocalDate DateDeb, @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable LocalDate DateFin, @PathVariable List<TypeCh> typeschambres) {
        return iAccomodationService.verifierdiponibilitechambres(ida, DateDeb, DateFin, typeschambres);
    }

    @GetMapping("/HotelsDisponibles/{typeAcc}/{ville}/{DateDeb}/{DateFin}/{nbpersonnes}")
    public Set<Accomodation> retrieveAccoByType(@PathVariable TypeAccomodation typeAcc, @PathVariable String ville, @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable LocalDate DateDeb, @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable LocalDate DateFin, @RequestBody List<TypeCh> typesChambres) {
        return iAccomodationService.retrieveAccoByType(typeAcc, ville, DateDeb, DateFin, typesChambres);
    }

    @GetMapping("/aaa/{IdAcc}")
    public Set<Chambre> getchambres(@PathVariable Long IdAcc) {
        return iAccomodationService.getchambres(IdAcc);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public Accomodation add(@RequestParam MultipartFile file,Accomodation accomodation) {
        String message = "";
        try {
            fileService.store(file);
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            File file1 = new File(filename, file.getContentType(), file.getBytes());
            iFile.save(file1);
            accomodation.setFileid(file1.getId());
            message = "Upload file successfully" + file.getOriginalFilename();
            iAccomodationService.add(accomodation);
        } catch (IOException e) {

        }
        return accomodation;
    }
}


