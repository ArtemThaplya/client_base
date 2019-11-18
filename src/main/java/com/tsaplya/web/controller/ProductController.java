package com.tsaplya.web.controller;

import com.tsaplya.web.model.Product;
import com.tsaplya.web.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ProductController {
    private SearchService searchService;

    @Autowired
    public ProductController(SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value = "/shop/product", method = GET)
    public List<Product> get(@RequestParam(value = "nameFilter") String nameFilter) {
        return searchService.getProductByRegex(nameFilter);
    }
}