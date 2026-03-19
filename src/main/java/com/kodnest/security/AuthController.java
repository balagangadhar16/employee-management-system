package com.kodnest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){

        User dbUser = userRepository.findByUsername(user.getUsername());

        if(dbUser == null){
            return ResponseEntity.status(401).body("User not found");
        }

        if(!dbUser.getPassword().equals(user.getPassword())){
            return ResponseEntity.status(401).body("Invalid password");
        }

        String token = JwtUtil.generateToken(user.getUsername());

        return ResponseEntity.ok(token);
    }
}