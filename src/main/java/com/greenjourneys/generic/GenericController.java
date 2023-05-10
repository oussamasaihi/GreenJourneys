package com.greenjourneys.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GenericController <T,ID> {
    @Autowired
    IGenericService<T,ID> genericService;

    @CrossOrigin(origins = "*")
    @PostMapping()
    public T add(@RequestBody T entity) {
        return genericService.add(entity);
    }
    @CrossOrigin(origins = "*")
    @PutMapping()
    public T update(@RequestBody T entity) {
        return	genericService.update(entity);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public T retrieveById(@PathVariable ID id ) {
        return	genericService.retrieveById(id);
    }
    @GetMapping()
    public List<T> retrieveAll() {
        return	genericService.retrieveAll();
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable ID id) {
        return	genericService.delete(id);
    }
}
