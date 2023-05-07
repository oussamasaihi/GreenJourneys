package com.greenjourneys.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GenericController <T,ID> {
    @Autowired
    IGenericService<T,ID> genericService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping()
    public T add(@RequestBody T entity) {
        return genericService.add(entity);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping()
    public T update(@RequestBody T entity) {
        return	genericService.update(entity);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public T retrieveById(@PathVariable ID id ) {
        return	genericService.retrieveById(id);
    }
    @GetMapping()
    public List<T> retrieveAll() {
        return	genericService.retrieveAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable ID id) {
        return	genericService.delete(id);
    }
}
