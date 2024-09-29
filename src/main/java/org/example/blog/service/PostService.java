package org.example.blog.service;

import java.util.List;
import org.example.blog.entity.Post;
import org.example.blog.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(int page, int size) {
        return postRepository.findAll(page, size);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post getPostBySlug(String slug) {
        return postRepository.findBySlug(slug);
    }

    public Post createOrUpdatePost(Post post) {
        if (post.getId() == null) {
            return postRepository.save(post);
        } else {
            return postRepository.update(post);
        }
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
