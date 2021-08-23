package com.codeup.blogapp.web;

        import com.codeup.blogapp.data.post.Post;
        import com.codeup.blogapp.data.post.PostRepository;
        import com.codeup.blogapp.data.user.User;
        import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
        import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    private final PostRepository postRepository;

    public PostsController(PostRepository postRepository){
        this.postRepository = postRepository;
    }


    @GetMapping
    private List<Post> getPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    private Post getPostById(@PathVariable Long id) {
            return postRepository.getById(id);
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost) {
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        postRepository.save(newPost);
    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post postToUpdate){
        System.out.println(postToUpdate.getTitle());
        System.out.println(postToUpdate.getContent());
        System.out.println(id);
        postRepository.save(postToUpdate);
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id){
        System.out.println("The Id Deleted was " + id);
        postRepository.deleteById(id);
    }

}
