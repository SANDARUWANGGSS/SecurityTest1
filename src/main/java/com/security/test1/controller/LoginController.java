package com.security.test1.controller;

import com.security.test1.model.User;
import com.security.test1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class LoginController
{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user)
    {
        ResponseEntity response=null;

        try{
            String hashPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
            User savedUser = userRepo.save(user);
            if (savedUser.getId()>0)
            {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given User Details Are Saved Successfully");
            }
        }catch (Exception ex)
        {
            response = ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("An Exception Occured Due To "+ex.getMessage());
        }
        return response;
    }
}
