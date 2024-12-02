package com.leek.gk_2_12.Resolver;

import com.leek.gk_2_12.Entity.Category;
import com.leek.gk_2_12.Entity.User;
import com.leek.gk_2_12.Service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserQueryResolver {

    private final UserService userService;

    public UserQueryResolver(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public User getUserById(@Argument Long id) {
        System.out.println("id = " + id);
        return userService.getUserById(id);
    }

    @QueryMapping
    public List<Category> getAllCategoriesByUserID(@Argument Long userId) {
        return userService.getCategoriesByUserId(userId);
    }
}
