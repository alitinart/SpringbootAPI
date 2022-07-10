package com.alitinart.BlogAPI.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void createPost(@RequestBody String title, @RequestBody String description) {
        Post post = new Post(title, description);
        postService.createPost(post);
    }

    @PutMapping(path = "{postId}")
    public void updatePost(@PathVariable("postId") Long id, @RequestParam(required = false) String title, @RequestParam(required = false) String description) {
        postService.updatePost(id, title, description);
    }

    @DeleteMapping(path = "{postId}")
    public void updatePost(@PathVariable("postId") Long id) {
        postService.deletePost(id);
    }
}
