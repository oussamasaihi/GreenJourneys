package com.greenjourneys.generic;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class IGenericServiceImp<T,ID> implements IGenericService<T,ID> {


    JpaRepository<T, ID> baseRepository;

    public IGenericServiceImp() {
    }

    public T add(T entity) {
        return this.baseRepository.save(entity);
    }

    public T update(T entity) {
        return this.baseRepository.save(entity);
    }

    public T retrieveById(ID id) {
        return this.baseRepository.findById(id).orElse((T) null);
    }

    public List<T> retrieveAll() {
        return this.baseRepository.findAll();
    }

    public Boolean delete(ID id) {
        if (this.baseRepository.existsById(id)) {
            this.baseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
