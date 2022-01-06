package com.codeup.springblog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

//    Post findByTitle(String title);
//    List<Post> findAllByTitle(String title);
//
//    Post deleteAllById(Long id);
//    void deleteById(Long id);
}
