package com.example.blog.service;

import com.example.blog.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save (Category category);


    Category findById(Integer id);

    void update(Category category);

    void delete(int id);

}
