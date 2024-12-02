package com.leek.gk_2_12.Service;
import com.leek.gk_2_12.Entity.Category;
import com.leek.gk_2_12.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    List<Category> getCategoriesByUserId(Long userId);
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
