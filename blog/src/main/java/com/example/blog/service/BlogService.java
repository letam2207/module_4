package com.example.blog.service;

import com.example.blog.entity.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {


    private final IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        if (blogRepository.existsById(blog.getId_blog())){
            blogRepository.save(blog);
        }
    }

    @Override
    public void delete(int id) {
       if (blogRepository.existsById(id)){
           blogRepository.deleteById(id);
       }
    }

    @Override
    public Page<Blog> findAllPageable(int page) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Blog> blogs = blogRepository.findAll(pageable);
        return blogs;
    }
}
