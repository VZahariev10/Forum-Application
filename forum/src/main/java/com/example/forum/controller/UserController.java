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
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        this.userDao.createUser(user);
    }
    @GetMapping("/users/getAll")
        public List<User> getAllUsers(){
        return userDao.getAllUser();
    }
    @GetMapping("/users/getUserByID/{id}")
    public User getUserBydID(@PathVariable int id){
        return userDao.getUserById(id);
    }
    @DeleteMapping("/users/deleteUserByID/{id}")
        public void deleteUserByID(@PathVariable int id){
        userDao.deleteUserById(id);
    }
}
