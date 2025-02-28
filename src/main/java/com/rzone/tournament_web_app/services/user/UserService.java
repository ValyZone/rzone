package com.rzone.tournament_web_app.services.user;

import com.rzone.tournament_web_app.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int theId);

    void save(User theUser);

    void deleteById(int theId);

    User findByUsername(String username);
}
