package com.codeup.blogapp.web;


import com.codeup.blogapp.data.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/categories", headers = "application/json")
public class CategoriesController {

    @GetMapping
    private void getCategory(@RequestParam String categoryName){
        User user = new User("Jesse");
    }


}
