package com.codeup.blogapp.web;


import com.codeup.blogapp.data.post.Post;
import com.codeup.blogapp.data.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")

public class UsersController {

    User user = new User(1L, "testy", "testy@test.com", "test123", null, null);

    List<Post> post = new ArrayList<>(){{
        add(new Post(1L, "testy1", "Testy1", null));
        add(new Post(2L, "testy2", "Testy2", null));
        add(new Post(3L, "testy3", "Testy3", null));
    }};


    @GetMapping
    private List<User> getUsers() {
        return new ArrayList<>() {
            {
                add(new User(1L, "billy.bob", "billybob@email.com", "mericagreatagain", null, null));
                add(new User(2L, "Deborah.Joe", "biznizbitch@email.com", "password1234", null, null));
                add(new User(3L, "John.Smith", "jsmith@email.com", "happydays4432", null, null));
            }};
    }

    @GetMapping("/{id}")
    private User getUserById(@PathVariable Long id){

        if (id == 1){
            return new User(1L, "billy.bob", "billybob@email.com", "mericagreatagain", null, null);
        }else{
            return null;
        }
    }

    @GetMapping("{username}")
    private void getUserByUsername(@PathVariable String username){
        System.out.println(username);
    }

    @GetMapping("{email}")
    private void getUserByEmail(@PathVariable String email){
        System.out.println(email);
    }

    @PostMapping
    private void createUser(@RequestBody User newUser) {
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getPassword());
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User User){
        System.out.println(User.getUsername());
        System.out.println(User.getEmail());
        System.out.println(User.getPassword());
        System.out.println(id);
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id){
        System.out.println("Deleting user with ID: " + id);

    }
}

