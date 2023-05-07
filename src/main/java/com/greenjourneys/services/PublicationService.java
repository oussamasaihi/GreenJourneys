package com.greenjourneys.services;

import com.greenjourneys.entities.Publication;
import com.greenjourneys.repositories.IPublication;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PublicationService implements IPublicationService {
    private final IPublication publicationRepository;
    @Override
    public Publication AddPublication(Publication publication) {
        return publicationRepository.save(publication);
    }

    @Override
    public void removePublication(Long id) {
        publicationRepository.deleteById(id);

    }

    @Override
    public Publication updatePublication(Publication publication) {
        return publicationRepository.save(publication);
    }

    @Override
    public List<Publication> GetAllPublication() {
        return publicationRepository.findAll();
    }

    @Override
    public Publication GetPublication(Long id) {
        return publicationRepository.findById(id).get();
    }

}
