package com.webapp.elephant.controller.manage;

import com.google.gson.Gson;
import com.webapp.elephant.exception.ErrorCode;
import com.webapp.elephant.exception.ObjectNotFoundException;
import com.webapp.elephant.model.entities.ProductItem;
import com.webapp.elephant.model.dao.ProductItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@RestController
@RequestMapping("/manage/product-item")
public class ProductItemController {
    @RequestMapping(value = "/add", produces = "application/json")
    public @ResponseBody String add() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            ProductItem productItem = new ProductItem();
            productItemDao.save(productItem);
            result.put("product_item_id", productItem.getId());
            result.put("message", "Product item is successfully added");
        } catch (Exception ex) {
            result.put("error", 1);
            result.put("messsage", ex.toString());
        }
        Gson gson = new Gson();
        return gson.toJson(result);
    }

    @RequestMapping(value = "/save/{id}", produces = "application/json")
    public @ResponseBody String save(@PathVariable long id, ProductItem productItem)
            throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        try {
            ProductItem existsItem = productItemDao.findById(id);
            if(existsItem == null) {
                throw new ObjectNotFoundException(
                    "Product item with id " + id + " is not exist",
                    ErrorCode.PRODUCT_ITEM_ID_NOT_FOUND
                );
            }
            productItem.setId(id);
            productItemDao.save(productItem);
            result.put("message", "Product item is successfully updated");
        } catch (Exception ex) {
            result.put("error", 1);
            result.put("message", ex.toString());
        }
        Gson gson = new Gson();
        return gson.toJson(result);
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable long id) throws Exception {
        ProductItem productItem = productItemDao.findById(id);
        if(productItem == null) {
            throw new ObjectNotFoundException(
                "Product item with id " + id + " is not exist",
                ErrorCode.PRODUCT_ITEM_ID_NOT_FOUND
            );
        }
        ModelAndView model = new ModelAndView();
        model.addObject("product_item", productItem);
        model.setViewName("manage/product_item/edit");
        return model;
    }

    @Autowired
    private ProductItemDao productItemDao;
}
