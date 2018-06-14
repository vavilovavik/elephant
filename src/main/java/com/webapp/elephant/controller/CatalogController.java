package com.webapp.elephant.controller;

import com.webapp.elephant.model.dao.ProductDao;
import com.webapp.elephant.model.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CatalogController {
    final ProductDao productDao;

    public CatalogController(ProductDao productDao) {
        this.productDao = productDao;
    }
    @GetMapping("/catalog")
    public ModelAndView index() throws Exception {
        Map<String, Object> model = new HashMap<>();
        List<Product> products = productDao.listProducts();

        for (Product product :products
             ) {
            System.out.println(product.getName());
        }

        model.put("products", products);
        return new ModelAndView("/catalog/index", model);
    }

}
