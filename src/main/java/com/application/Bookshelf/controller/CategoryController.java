package com.application.Bookshelf.controller;

import com.application.Bookshelf.objects.Category;
import com.application.Bookshelf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")

    public String showCategory(Model model)
    { model.addAttribute("categories",categoryService.findAllCategories());
        return "categories";
    }

    @GetMapping("/update-category/{id}")
    public String updateCatagory(@PathVariable Long id, Model model)
    { Category category = categoryService.findCategoryById(id);
        model.addAttribute("category" , categoryService.findAllCategories());
        return "update-category";
    }
}