package com.tsaplya.web.config;

import com.tsaplya.web.dao.ProductDao;
import com.tsaplya.web.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {
    private final static String NAME_ONE = "eva";
    private final static String NAME_TWO = "EVA";
    private final static String NAME_THREE = "evaaaaa";
    private final static String NAME_FOUR = "artem";
    private final static String DESCRIPTION = "description";
    private ProductDao productDao;

    @Autowired
    public DataInit(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void run(ApplicationArguments args) {
        long countProduct = productDao.count();
        if (countProduct == 0) {
            Product productFirst = new Product();
            productFirst.setName(NAME_ONE);
            productFirst.setDescription(DESCRIPTION);

            Product productSecond = new Product();
            productSecond.setName(NAME_TWO);
            productSecond.setDescription(DESCRIPTION);

            Product productThree = new Product();
            productThree.setName(NAME_THREE);
            productThree.setDescription(DESCRIPTION);

            Product productFour = new Product();
            productFour.setName(NAME_FOUR);
            productFour.setDescription(DESCRIPTION);

            productDao.save(productFirst);
            productDao.save(productSecond);
            productDao.save(productThree);
            productDao.save(productFour);
        }
    }
}
