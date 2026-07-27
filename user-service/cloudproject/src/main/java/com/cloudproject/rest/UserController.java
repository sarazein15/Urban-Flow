package com.cloudproject.rest;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cloudproject.model.User;
import com.cloudproject.model.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userservice;

    @GetMapping
    public List<User> getAllUsers() {
        return userservice.getUsers();
    }

    @GetMapping(path = "{userId}")
    public User getUser(@PathVariable("userId") int id) {
        return userservice.getUser(id);
    }

    @PostMapping
    public User addUser(@RequestBody User auser) {
        return userservice.addUser(auser);
    }

    @PutMapping(path = "{userId}")
    public User updateUser(@PathVariable("userId") int id, @RequestBody User auser) {
        auser.setId(id);
        return userservice.updateUser(auser);
    }

    @DeleteMapping(path = "{userId}")
    public boolean removeUser(@PathVariable("userId") int id) {
        return userservice.removeUser(id);
    }
}