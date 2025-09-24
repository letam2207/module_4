package com.example.blog.service;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save (Blog blog);


    Blog findById(Integer id);

    void update(Blog blog);

    void delete(int id);

    Page<Blog> findAllPageable(int page);
}
