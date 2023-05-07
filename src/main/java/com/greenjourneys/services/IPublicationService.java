package com.greenjourneys.services;

import com.greenjourneys.entities.Publication;

import java.io.Serializable;
import java.util.List;

public interface IPublicationService extends Serializable {
    public Publication AddPublication(Publication publication);
    public void removePublication(Long id);
    public Publication updatePublication(Publication publication);
    public List<Publication> GetAllPublication();
    public Publication GetPublication(Long id);
}
