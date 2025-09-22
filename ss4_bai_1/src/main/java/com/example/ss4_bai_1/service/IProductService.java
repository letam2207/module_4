package com.example.ss4_bai_1.service;

import com.example.ss4_bai_1.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void add (Product product);


    void update(Product product);


    void delete(int id);


    Product searchById(int id);


    List<Product> searchByName(String name);

    Product viewDetail(int id);
}
