package com.webapp.elephant.controller.manage;

import com.google.gson.Gson;
import com.webapp.elephant.exception.ErrorCode;
import com.webapp.elephant.exception.ObjectNotFoundException;
import com.webapp.elephant.model.entities.Product;
import com.webapp.elephant.model.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/manage/product")
public class ProductController {
    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "/add", produces = "application/json")
    public @ResponseBody String add() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            Product product = new Product();
            productDao.save(product);
            result.put("product_id", product.getId());
            result.put("message", "Product is successfully added");
        } catch (Exception ex) {
            result.put("message", ex.toString());
            result.put("error", 1);
        }
        Gson gson = new Gson();
        return gson.toJson(result);
    }

    @RequestMapping(value = "/save/{id}", produces = "application/json")
    public @ResponseBody String save(@PathVariable long id, @ModelAttribute Product product)
        throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            Product existsProduct = productDao.findOne(id);
            if(existsProduct == null) {
                throw new ObjectNotFoundException(
                    "Product with id " + id + " is not exist",
                    ErrorCode.PRODUCT_ID_NOT_FOUND
                );
            }
            product.setId(id);
            productDao.save(product);
            result.put("message", "Product is successfully updated");
        } catch (Exception ex) {
            result.put("message", ex.toString());
            result.put("error", 1);
        }
        Gson gson = new Gson();
        return gson.toJson(result);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) throws Exception {
        Product product = productDao.findOne(id);
        if(product == null) {
            throw new ObjectNotFoundException(
                "Product with id " + id + " is not exist",
                ErrorCode.PRODUCT_ID_NOT_FOUND
            );
        }
        System.out.println(product);
        ModelAndView model = new ModelAndView();
        model.addObject("product", product);
        model.setViewName("manage/product/edit");
        return model;
    }

}
