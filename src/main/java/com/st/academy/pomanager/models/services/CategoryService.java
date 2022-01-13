package com.st.academy.pomanager.models.services;

import com.st.academy.pomanager.models.entities.Category;
import com.st.academy.pomanager.models.repositories.ICategoryDao;
import com.st.academy.pomanager.utils.DBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CrudService<Category, Long> {

    @Autowired
    private ICategoryDao iCategoryDao;

    @Override
    public List<Category> findAll() {
        return iCategoryDao.findAll();
    }

    @Override
    public Category save(Category category) {
        return iCategoryDao.save(category);
    }

    @Override
    public void delete(Long id) {
        iCategoryDao.deleteById(id);

    }

    @Override
    public Category findById(Long id) throws DBException {
        return iCategoryDao.findById(id).orElseThrow(() -> new DBException("No category found with id: " + id));
    }

    @Override
    public Category update(Category category, Long id) {
        return null;
    }

}
