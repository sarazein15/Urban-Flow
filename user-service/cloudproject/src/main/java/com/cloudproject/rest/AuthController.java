package com.cloudproject.rest;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cloudproject.model.AuthServices;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthServices authservice;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> credentials) {
        return authservice.login(
            credentials.get("username"),
            credentials.get("password")
        );
    }
}
