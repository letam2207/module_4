package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.CategoryService;
import com.example.blog.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {

    private final IBlogService blogService;
    private final CategoryService categoryService;

    public BlogRestController(IBlogService blogService, CategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<List<Blog>> getBlogs() {
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Blog> createBlog(@Validated @RequestBody Blog blog) {
        Blog newBlog = new Blog();
        BeanUtils.copyProperties(blog, newBlog);
        blogService.save(newBlog);
        return new ResponseEntity<>(newBlog, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Integer id,
                                           @Validated @RequestBody Blog blog) {
        Blog existingBlog = blogService.findById(id);
        if (existingBlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(blog, existingBlog, "id_blog");
        blogService.save(existingBlog);
        return new ResponseEntity<>(existingBlog, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Integer id) {
        Blog existingBlog = blogService.findById(id);
        if (existingBlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
