package com.codeup.blogapp.web;

import com.codeup.blogapp.EmailService;
import com.codeup.blogapp.data.post.Post;
import com.codeup.blogapp.data.post.PostRepository;
import com.codeup.blogapp.data.user.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json", produces = "application/json")
public class PostsController {


    private final PostRepository postRepository;

    private final EmailService emailService;

    public PostsController(PostRepository postrepository, EmailService emailService){

        this.postRepository = postrepository;
        this.emailService = emailService;

    }

    @GetMapping
    private List<Post> getPosts(){
        return postRepository.findAll();
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id){
        return postRepository.findById(id).get();
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost, OAuth2Authentication auth){
        String email = auth.getName();
        User user = userRepository.findByEmail(email).get();
        newPost.setUser(user);
        postRepository.save(newPost);
//        emailService.prepareAndSend(newPost, "subject: test email", "this is a test email");
    }

    @PutMapping({"/{id}"})
    private void updatePost(@PathVariable Long id, @RequestBody Post postToUpdate){

        System.out.println(postToUpdate.getTitle());
        System.out.println(postToUpdate.getContent());
        postRepository.save(postToUpdate);
    }

    @DeleteMapping({"{id}"})
    private void deletePost(@PathVariable Long id){
        System.out.println("The id deleted was: " + id);
        postRepository.deleteById(id);
    }

//fixing stuff
}