package org.example.blog;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.example.blog.repository.impl", "org.example.blog.service"})
public class AppConfiguration {

}
