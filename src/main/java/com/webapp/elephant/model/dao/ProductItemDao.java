package com.webapp.elephant.model.dao;

import com.webapp.elephant.model.entities.ProductItem;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ProductItemDao extends CrudRepository<ProductItem, Long> {
    public ProductItem findById(long id);
}
