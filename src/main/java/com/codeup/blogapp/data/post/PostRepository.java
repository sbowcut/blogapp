package com.codeup.blogapp.data.post;

import org.springframework.data.jpa.repository.JpaRepository;

public class PostRepository {

    public interface PostsRepository extends JpaRepository<Post, Long> {

    }

}