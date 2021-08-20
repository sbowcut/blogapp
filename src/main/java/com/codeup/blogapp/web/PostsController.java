package com.codeup.blogapp.web;

        import com.codeup.blogapp.data.post.Post;
        import com.codeup.blogapp.data.user.User;
        import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
        import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
class PostController {

    @GetMapping
    private List<Post> getPosts() {

        User user = new User( "testy");

        return new ArrayList<>() {
            {
                add(new Post(1L, "A new Post", "This is a brilliant posts. 10/10", null));
                add(new Post(2L, "A new Post", "This is a brilliant posts. 11/10", null));
                add(new Post(3L, "A new Post", "This is a brilliant posts. 12/10", null));

            }
        };
    }

    @GetMapping("/{id}")
    private Post getPostById(@PathVariable Long id) {

        User user = new User(1L, "testy", "testy@test.com", "test123", null, null);

        if (id == 1) {
            return new Post(1L, "A new Post", "This is a brilliant posts. 13/10", user);
        } else {
            return null;
        }
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost) {
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        System.out.println(id);
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id){
        System.out.println("The Id Deleted was " + id);
    }

}
