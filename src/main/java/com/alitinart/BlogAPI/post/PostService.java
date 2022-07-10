package com.alitinart.BlogAPI.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    public void createPost(Post post) {
        postRepository.save(post);
    }

    @Transactional
    public void updatePost(Long id, String title, String description) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + "was not found"));

        if(title != null && !Objects.equals(post.getTitle(), title)) {
            post.setTitle(title);
        }

        if(description != null && !Objects.equals(post.getDescription(), description)) {
            post.setDescription(description);
        }
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
