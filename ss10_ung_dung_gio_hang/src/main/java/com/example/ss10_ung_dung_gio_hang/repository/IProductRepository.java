package com.example.ss10_ung_dung_gio_hang.repository;

import com.example.ss10_ung_dung_gio_hang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Integer> {
}
