package com.webapp.elephant.model.dao;
import javax.transaction.Transactional;

import com.webapp.elephant.model.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


@Transactional
public interface ProductDao extends CrudRepository<Product, Long> {
    Optional<Product> findById(long id);
    Product findByName(String name);
    List<Product> findAll();

    @Query(value = "SELECT p.*, i.path AS image " +
            "FROM product p " +
            "LEFT JOIN image i ON i.type='product' AND i.eid=p.id " +
            "LIMIT 2", nativeQuery = true
    )
    List<Product> listProducts();

    @Query(value = "SELECT p.*, i.path AS image " +
            "FROM product p " +
            "LEFT JOIN image i ON i.type='product' AND i.eid=p.id " +
            "WHERE p.id=?1", nativeQuery = true
    )
    Product findOne(long id);
}
