package com.example.ss10_ung_dung_gio_hang.service;

import com.example.ss10_ung_dung_gio_hang.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Integer id);
}
