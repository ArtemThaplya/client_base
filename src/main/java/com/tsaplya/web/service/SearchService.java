package com.tsaplya.web.service;

import com.tsaplya.web.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchService {
    private SearchProductsByRegex searchProductsByRegex;

    @Autowired
    public SearchService(SearchProductsByRegex searchProductsByRegex) {
        this.searchProductsByRegex = searchProductsByRegex;
    }
    public List<Product> getProductByRegex(String regex){
        return searchProductsByRegex.searchForTableProductsByRegex(regex);
    }
}
