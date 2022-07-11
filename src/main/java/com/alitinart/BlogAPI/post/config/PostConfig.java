package com.alitinart.BlogAPI.post.config;

import com.alitinart.BlogAPI.post.model.Post;
import com.alitinart.BlogAPI.post.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PostConfig {

    @Bean
    CommandLineRunner commandLineRunner(PostRepository repository) {
        return args ->{
            Post javaPost = new Post(
                    "Java is a great backend language",
                    "Java regardless if it's old it's one of the best backend languages out there."
            );

            Post bunPost = new Post(
                    "New Javascript runtime called Bun",
                    "This new runtime called Bun can run javascript 3x times faster than NodeJS or Deno, making \r" +
                            " it the fastest runtime out there."
            );

            repository.saveAll(List.of(javaPost, bunPost));
        };
    }
}
