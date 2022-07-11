package com.alitinart.BlogAPI.post;

import org.hibernate.type.StringNVarcharType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
            this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @PostMapping
    public String createPost(@RequestBody Post post) {
        postService.createPost(post);
        return "Post Added";
    }

    @PutMapping(path = "{postId}")
    public void updatePost(@PathVariable("postId") Long id, @RequestParam(required = false) String title, @RequestParam(required = false) String description) {
        postService.updatePost(id, title, description);
    }

    @DeleteMapping(path = "{postId}")
    public void updatePost(@PathVariable("postId") Long id) {
        postService.deletePost(id);
    }

    // Get Post By Title
    @GetMapping(path="title")
    public Optional<Post> getPostByTitle(@RequestParam(required = true) String title) {
       return postService.getPostByTitle(title);
    }
}
