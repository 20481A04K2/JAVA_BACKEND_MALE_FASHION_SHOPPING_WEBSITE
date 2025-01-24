package com.springbootproject.Controller;

import com.springbootproject.Entity.User;
import com.springbootproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500") // Allow requests from frontend
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // Sign Up API
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        String result = userService.signUp(user);
        if ("Registration successful!".equals(result)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    // Sign In API
    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestParam String email, @RequestParam String password) {
        String result = userService.signIn(email, password);
        if ("Sign In Successful!".equals(result)) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        }
    }

    // Check if User Exists API
    @GetMapping("/check-user")
    public ResponseEntity<Boolean> checkUserExists(@RequestParam String email) {
        boolean exists = userService.checkIfUserExists(email);
        return ResponseEntity.ok(exists);
    }
}
