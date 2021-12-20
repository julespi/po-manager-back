package com.st.academy.pomanager.models.services;

import java.util.List;

public interface CrudService<T> {
    
    public List<T> findAll();
    public T save(T t);
    public void delete(Long id);
    public T findById(Long id);

}
