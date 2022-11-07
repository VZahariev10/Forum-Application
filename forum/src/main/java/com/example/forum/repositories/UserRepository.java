package com.example.forum.repositories;

import com.example.forum.model.User;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements UserDao {
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1, "Petyr", "123", "pepi@yahoo.com", true));
        users.add(new User(2, "Ani", "456", "ani@yahoo.com", true));
        users.add(new User(3, "Asen", "789", "asen@yahoo.com", true));
        users.add(new User(4, "Ivan", "000", "ivan@yahoo.com", true));
    }

    @Override
    public void createUser(User user) {
        this.users.add(new User(this.users.size() + 1,
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.isEnabled()));
    }

    @Override
    public List<User> getAllUser() {
        return this.users;
    }

    @Override
    public User getUserById(int id) {
        User userToReturn = null;
        for (User user : users) {
            if (user.getId() == id) {
                userToReturn = user;
            }
        }
        return userToReturn;
    }

    @Override
    public void updateUserById(int id, User userToUpdate) {
        userToUpdate.setId(id);
        for (User user : users) {
            if (user.getId() == userToUpdate.getId()) {
                user.setUsername(userToUpdate.getUsername());
                user.setEmail(userToUpdate.getEmail());
                user.setPassword(userToUpdate.getPassword());
                user.setEnabled(userToUpdate.isEnabled());
            }
        }
    }

    @Override
    public void deleteUserById(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
