package com.example.ss10_ung_dung_gio_hang.service;

import com.example.ss10_ung_dung_gio_hang.entity.Product;
import com.example.ss10_ung_dung_gio_hang.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

}
