package com.example.bai_mau_2_tb.service;

import com.example.bai_mau_2_tb.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save (Product product);

    Product findById(int id);

    List<Product> findByName(String name);

    void update(Product product);

    void delete(int id);
}
