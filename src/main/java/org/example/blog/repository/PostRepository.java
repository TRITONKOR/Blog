package org.example.blog.repository;

import java.util.List;
import org.example.blog.entity.Post;

public interface PostRepository {

    List<Post> findAll(int page, int size);
    Post findById(Long id);
    Post findBySlug(String slug);
    Post save(Post post);
    Post update(Post post);
    void deleteById(Long id);
}
