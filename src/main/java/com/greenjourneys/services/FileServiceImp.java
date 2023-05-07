package com.greenjourneys.services;

import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.File;
import com.greenjourneys.repositories.IAccomodation;
import com.greenjourneys.repositories.IFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.greenjourneys.entities.File;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class FileServiceImp implements IFileService{
    @Autowired
    private IFile iFile;
    @Autowired
    private IAccomodation iAccomodation;

    public File store(MultipartFile file ) throws IOException
    {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        File projectFile = new File(filename,file.getContentType(), file.getBytes());

        return iFile.save(projectFile);
    }

    @Transactional
    public File storeToAcc(MultipartFile file, Long id ) throws  IOException
    {
        Accomodation a = iAccomodation.findById(id).orElse(null);
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        File file1 = new File(filename,file.getContentType(), file.getBytes());
       a.setFileid(file1.getId());
        return iFile.save(file1);
    }
    public File getFile(Long id)
    {
        return iFile.findById(id).get();
    }

    public Stream<File> getAllFiles()
    {
        return iFile.findAll().stream();
    }

    @Override
    public Set<File> getAllFilesByAccomodation(Long id) {
        return null;
    }

}
