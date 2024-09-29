package org.example.blog.repository;

import java.util.List;
import org.example.blog.entity.User;

public interface UserRepository {
    User findById(Long id);
    List<User> findAll();
}
