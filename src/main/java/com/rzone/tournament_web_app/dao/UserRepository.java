package com.rzone.tournament_web_app.dao;

import com.rzone.tournament_web_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
