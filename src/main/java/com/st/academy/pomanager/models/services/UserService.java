package com.st.academy.pomanager.models.services;

import com.st.academy.pomanager.models.entities.Category;
import com.st.academy.pomanager.models.entities.User;
import com.st.academy.pomanager.models.repositories.ICategoryDao;
import com.st.academy.pomanager.models.repositories.IUserDao;
import com.st.academy.pomanager.utils.DBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements CrudService<User, Long> {

    @Autowired
    private IUserDao iUserDao;

    @Override
    public List<User> findAll() {
        return iUserDao.findAll();
    }

    @Override
    public User save(User user) {
        return iUserDao.save(user);
    }

    @Override
    public void delete(Long id) {
        iUserDao.deleteById(id);

    }

    @Override
    public User findById(Long id) throws DBException {
        return iUserDao.findById(id).orElseThrow(() -> new DBException("No user found with id: " + id));
    }

    @Override
    public User update(User category, Long id) {
        return null;
    }

    public User login(User userToLogin) {
        return iUserDao.findByEmailAndPassword(
                userToLogin.getEmail(),
                userToLogin.getPassword()
        ).orElseThrow(() -> new DBException("Wrong credentials"));
    }
}
