package com.example.ss4_bai_1.repository;

import com.example.ss4_bai_1.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    private static List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        List<Product> products = BaseRepository.entityManager
                .createQuery("select p from products as p").getResultList();
        return products;
    }

    @Override
    public void add(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try {
            transaction.begin();
            BaseRepository.entityManager.persist(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }


    @Override
    public Product searchById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void update(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try {
            transaction.begin();
            BaseRepository.entityManager.merge(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public void delete(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try {
            transaction.begin();
            Product product = BaseRepository.entityManager.find(Product.class, id);
            if (product != null) {
                BaseRepository.entityManager.remove(product);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        TypedQuery<Product> query = BaseRepository.entityManager
                .createQuery("select p from products p where p.name like :name", Product.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    @Override
    public Product viewDetail(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

}
