package com.leek.gk_2_12.ControllAPI;


import com.leek.gk_2_12.Entity.Category;
import com.leek.gk_2_12.Entity.User;
import com.leek.gk_2_12.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAPIController {
    private final UserService userService;

    public UserAPIController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/categories/{userId}")
    public List<Category> getAllCategoriesByUserID(@PathVariable Long userId) {
        return userService.getCategoriesByUserId(userId);
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @PostMapping("/update/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user) {
        return userService.updateUser(id, user);
    }
    @GetMapping("/delete/{id}")
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }
}
