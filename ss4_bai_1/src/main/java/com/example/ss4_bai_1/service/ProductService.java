package com.example.ss4_bai_1.service;

import com.example.ss4_bai_1.entity.Product;
import com.example.ss4_bai_1.exception.ProductNotFoundException;
import com.example.ss4_bai_1.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> findAll() {

        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public Product searchById(int id) {
        Product product = productRepository.searchById(id);
        if (product == null) {
            throw new ProductNotFoundException("Không tìm thấy sản phẩm với ID = " + id);
        }
        return product;
    }


    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }

    @Override
    public Product viewDetail(int id) {
        return productRepository.viewDetail(id);
    }
}
