package com.example.ss5_bai_1.repository;

import com.example.ss5_bai_1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

//    Trong  trường hợp có sự thay đổi dữ liệu
//    @Transactional
//    @Modifying <=> executeUpdate
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query("select s from products s where s.name like %:name%")
    List<Product> findByName(@Param("name") String name);

}
