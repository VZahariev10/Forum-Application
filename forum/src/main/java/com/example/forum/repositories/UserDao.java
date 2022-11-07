package com.example.forum.repositories;

import com.example.forum.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);

    List<User> getAllUser();

    User getUserById(int id);

    void updateUserById(int id, User user);

    void deleteUserById(int id);
}
