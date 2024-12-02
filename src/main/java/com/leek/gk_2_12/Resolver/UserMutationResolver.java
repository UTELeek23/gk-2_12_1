package com.leek.gk_2_12.Resolver;

import com.leek.gk_2_12.Entity.User;
import com.leek.gk_2_12.Service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserMutationResolver {
    private final UserService userService;

    public UserMutationResolver(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping
    public User createUser(@Argument String fullName, @Argument String email, @Argument String password, @Argument String phone) {
        System.out.println("fullName = " + fullName);
        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        return userService.createUser(user);
    }

    @MutationMapping
    public User updateUser(@Argument Long id, @Argument String fullName, @Argument String email, @Argument String password, @Argument String phone) {
        User user = userService.getUserById(id); // Kiểm tra User tồn tại
        if (fullName != null) user.setFullName(fullName);
        if (email != null) user.setEmail(email);
        if (password != null) user.setPassword(password);
        if (phone != null) user.setPhone(phone);
        return userService.updateUser(id, user);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument Long id) {
        userService.deleteUser(id);
        return true;
    }
}
