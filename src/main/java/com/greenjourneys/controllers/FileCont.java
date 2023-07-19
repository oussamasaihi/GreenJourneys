package com.greenjourneys.controllers;

import com.greenjourneys.entities.File;
import com.greenjourneys.message.ResponseFile;
import com.greenjourneys.message.ResponseMessage;
import com.greenjourneys.services.IAccomodationService;
import com.greenjourneys.services.IFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/File")
@RequiredArgsConstructor
public class FileCont {
    private final IFileService iFileService;
    private final IAccomodationService iAccomodationService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file)
    {
        String message = "";
        try {
            iFileService.store(file);

            message = "Uploaded File successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }catch (Exception e)
        {
            message = "Could not upload file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/upload/{id}")
    public ResponseEntity<ResponseMessage> uploadFileToAcc(@RequestParam("file")MultipartFile file,@PathVariable("id")Long id)
    {
        String message = "";
        try{
            iFileService.storeToAcc(file,id);

            message = "Uploaded File successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));}
        catch (Exception e)
        {
            message = "Could not upload file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }


    }
    @CrossOrigin(origins = "*")
    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles(){
        List<ResponseFile> files = iFileService.getAllFiles().map(projectFile ->
        {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files")
                    .path(projectFile.getId().toString())
                    .toUriString();
            return new ResponseFile(projectFile.getName(),fileDownloadUri,projectFile.getType(),projectFile.getData().length);

        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFileById(@PathVariable Long id)
    {
        File projectFile = iFileService.getFile(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + projectFile.getName() + "\"")
                .body(projectFile.getData());
    }
    /*@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/accomodation/{id}")
    public ResponseEntity<List<ResponseFile>> getFilesByAccomodationId(@PathVariable Long id)
    {
        List<ResponseFile> files = iAccomodationService.retrieveById(id).getFiles().stream().map(File1 ->
        {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files")
                    .path(File1.getId().toString())
                    .toUriString();
            return new ResponseFile(File1.getName(),fileDownloadUri,File1.getType(),File1.getData().length);

        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }*/
}
