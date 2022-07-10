package com.alitinart.BlogAPI.post;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class PostConfig {

    @Bean
    CommandLineRunner commandLineRunner(PostRepository postRepository) {
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

            postRepository.saveAll(List.of(javaPost, bunPost));
        };
    }
}
