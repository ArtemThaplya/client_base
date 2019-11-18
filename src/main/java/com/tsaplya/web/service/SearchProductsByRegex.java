package com.tsaplya.web.service;

import com.tsaplya.web.model.Product;

import java.util.List;

public interface SearchProductsByRegex {
    List<Product> searchForTableProductsByRegex(String regex);
}
