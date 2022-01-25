package com.st.academy.pomanager.models.services;

import java.util.List;

public interface CrudService<T, ID> {
    
    List<T> findAll();
    T save(T t);
    void delete(ID id);
    T findById(ID id);
    T update(T t, ID id);

}
