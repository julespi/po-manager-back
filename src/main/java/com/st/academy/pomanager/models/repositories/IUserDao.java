package com.st.academy.pomanager.models.repositories;

import com.st.academy.pomanager.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserDao extends JpaRepository<User, Long>{

    Optional<User> findByEmailAndPassword(String email, String password);

}
