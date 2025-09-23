package com.example.ss5_bai_1.service;

import com.example.ss5_bai_1.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save (Product product);


    Product findById(int id);


    List<Product> findByName(String name);

    void update(Product product);

    void delete(int id);
}
