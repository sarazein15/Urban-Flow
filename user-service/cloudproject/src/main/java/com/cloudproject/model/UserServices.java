package com.cloudproject.model;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository userrepo;

    public List<User> getUsers() {
        return userrepo.findAll();
    }

    public User addUser(User auser) {
        return userrepo.save(auser);
    }

    public User getUser(int id) {
        return userrepo.findById(id).orElse(null);
    }

    public User updateUser(User auser) {
        if (!userrepo.existsById(auser.getId())) return null;
        return userrepo.save(auser);
    }

    public boolean removeUser(int id) {
        if (!userrepo.existsById(id)) return false;
        userrepo.deleteById(id);
        return true;
    }
}