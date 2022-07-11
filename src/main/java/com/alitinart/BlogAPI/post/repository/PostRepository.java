package com.alitinart.BlogAPI.post.repository;

import com.alitinart.BlogAPI.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT s FROM Post s WHERE s.title = ?1")
    Optional<Post> findPostByTitle(String title);
}
