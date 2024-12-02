package com.leek.gk_2_12.ControllAPI;


import com.leek.gk_2_12.Entity.Category;
import com.leek.gk_2_12.Service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryAPIController {
    private final CategoryService categoryService;

    public CategoryAPIController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

}
