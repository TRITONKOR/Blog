package org.example.blog.repository.impl;

import java.util.ArrayList;
import java.util.List;
import org.example.blog.entity.Post;
import org.example.blog.repository.PostRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final List<Post> posts = new ArrayList<>();

    public PostRepositoryImpl() {
        Post post1 = new Post();
        post1.setId(1L);
        post1.setTitle("First Post");
        post1.setContent("Content of the first post");
        post1.setSlug("first-post");

        Post post2 = new Post();
        post2.setId(2L);
        post2.setTitle("Second Post");
        post2.setContent("Content of the second post");
        post2.setSlug("second-post");

        posts.add(post1);
        posts.add(post2);
    }
    @Override
    public List<Post> findAll(int page, int size) {
        int start = page * size;
        int end = Math.min(start + size, posts.size());
        return posts.subList(start, end);
    }

    @Override
    public Post findById(Long id) {
        return posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post findBySlug(String slug) {
        return posts.stream()
                .filter(post -> post.getSlug().equals(slug))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post save(Post post) {
        post.setId((long) (posts.size() + 1));
        posts.add(post);
        return post;
    }

    @Override
    public Post update(Post post) {
        Post existingPost = findById(post.getId());
        if (existingPost != null) {
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
            existingPost.setSlug(post.getSlug());
        }
        return existingPost;
    }

    @Override
    public void deleteById(Long id) {
        posts.removeIf(post -> post.getId().equals(id));
    }
}
