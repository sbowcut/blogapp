package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    @GetMapping
    private List<Post> getPosts(){
        return new ArrayList<Post>(){{
            User user = null;
            add(new Post(1L, "A new Post", "This is a brilliant posts. 10/10", null));
            add(new Post(2L, "A new Post", "This is a brilliant posts. 11/10", null));
            add(new Post(3L, "A new Post", "This is a brilliant posts. 12/10", null));

        }};
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id){
        // api/posts/1
        if(id == 1){
            User user = null;
            return new Post(1L, "A new Post", "This is a brilliant posts. 10/10", null);
        }else{
            return null;
        }
    }

    @PostMapping
    private void createPost(@RequestBody Post post){

        System.out.println(post.getTitle());
        System.out.println(post.getContent());

    }

    @PutMapping({"/{id}"})
    private void updatePost(@PathVariable Long id, @RequestBody Post post){

        System.out.println(post.getTitle());
        System.out.println(post.getContent());
    }

    @DeleteMapping({"{id}"})
    private void deletePost(@PathVariable Long id){
        System.out.println("The id deleted was: " + id);
    }

}