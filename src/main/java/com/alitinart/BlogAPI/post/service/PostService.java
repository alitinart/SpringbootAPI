package com.alitinart.BlogAPI.post.service;

import com.alitinart.BlogAPI.post.model.Post;
import com.alitinart.BlogAPI.post.repository.PostRepository;
import org.apache.catalina.webresources.EmptyResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

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
        if(post.getTitle() == null || post.getDescription() == null) {
            throw new IllegalStateException();
        }
        postRepository.save(post);
    }

    @Transactional
    public void updatePost(Long id, String title, String description) {
        Post post = postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Post with id " + id + " was not found"));

        if(title != null && !Objects.equals(post.getTitle(), title)) {
            post.setTitle(title);
        }

        if(description != null && !Objects.equals(post.getDescription(), description)) {
            post.setDescription(description);
        }
    }

    public void deletePost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if(!post.isPresent()){
            throw new NoSuchElementException("Post with id " + id + " doesn't exist");
        }
        postRepository.deleteById(id);
    }

    public Optional<Post> getPostByTitle(String title) {
        return postRepository.findPostByTitle(title);
    }
}
