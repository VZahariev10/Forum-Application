package com.example.forum.controller;

import com.example.forum.model.User;
import com.example.forum.repositories.UserDao;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/users/create")
    public void createUser(@RequestBody User user) {
        this.userDao.createUser(user);
    }

    @GetMapping("/users/getAll")
    public List<User> getAllUsers() {
        return userDao.getAllUser();
    }

    @GetMapping("/users/getByID/{id}")
    public User getUserBydID(@PathVariable int id) {
        return userDao.getUserById(id);
    }

    @DeleteMapping("/users/deleteByID/{id}")
    public void deleteUserByID(@PathVariable int id) {
        userDao.deleteUserById(id);
    }

    @PutMapping("/users/updateByID/{id}")
    public void updatePersonByID(@PathVariable int id, @RequestBody User user) {

        userDao.updateUserById(id, user);
    }
}
