package com.cloudproject.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    @Autowired
    private UserRepository userrepo;

    public Map<String, Object> login(String username, String password) {
        Map<String, Object> response = new HashMap<>();
        Optional<User> optUser = userrepo.findByUsername(username);

        if (optUser.isEmpty()) {
            response.put("status", "failure");
            response.put("message", "User not found");
            return response;
        }

        User user = optUser.get();

        if (!user.getPassword().equals(password)) {
            response.put("status", "failure");
            response.put("message", "Invalid credentials");
            return response;
        }

        response.put("status", "success");
        response.put("role", user.getRole());
        response.put("token", "token-" + username + "-" + System.currentTimeMillis());
        return response;
    }
}
