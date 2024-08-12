package com.Bookstore.Bookstore.Controller;


import com.Bookstore.Bookstore.Enitity.User;
import com.Bookstore.Bookstore.Enitity.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {


    @Autowired
    private UserRepo userRepo;

    @PostMapping(path ="/Register")
    public User registerUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @GetMapping(path ="/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping
    public @ResponseBody List<User> getUserByUsername() {
        return (List<User>) userRepo.findAll();
    }

}
