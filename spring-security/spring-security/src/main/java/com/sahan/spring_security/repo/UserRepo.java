package com.sahan.spring_security.repo;

import com.sahan.spring_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {

    User findByUsername(String username);

}
