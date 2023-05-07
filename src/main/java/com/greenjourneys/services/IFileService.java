package com.greenjourneys.services;

import org.springframework.web.multipart.MultipartFile;

import com.greenjourneys.entities.File;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Stream;

public interface IFileService {
    public File store(MultipartFile file ) throws IOException;

    public File getFile(Long id);

    public Stream<File> getAllFiles();
    public Set<File> getAllFilesByAccomodation(Long id);
    public File storeToAcc(MultipartFile file, Long id )throws  IOException;
}
