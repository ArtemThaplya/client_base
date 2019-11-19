package com.tsaplya.web.service;

import com.tsaplya.web.dao.ProductDao;
import com.tsaplya.web.model.Product;
import com.tsaplya.web.model.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class SearchProductsByRegexImp implements SearchProductsByRegex {
    private final ProductDao productDao;

    @Autowired
    public SearchProductsByRegexImp(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> searchForTableProductsByRegex(String regex) {
        List<Product> result = new ArrayList<>();
        if (productDao.findAll() == null) {
            throw new ProductNotFoundException("The table is empty!");
        }
        Iterable<Product> all = productDao.findAll();
        Pattern pattern = Pattern.compile(regex);

        for (Product product : all) {
            if (!pattern.matcher(product.getName()).matches()) {
                result.add(product);
            }
        }
        return result;
    }
}
