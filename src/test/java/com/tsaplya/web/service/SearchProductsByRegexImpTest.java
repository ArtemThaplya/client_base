package com.tsaplya.web.service;

import com.tsaplya.web.dao.ProductDao;
import com.tsaplya.web.model.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SearchProductsByRegexImpTest {
    private List<Product> expectedProducts = new ArrayList<>();
    private static final String condition = "^E.*$";
    private Product productWithNameStartFromE = new Product();
    private Product productWithNameStartFromA = new Product();
    private ProductDao productDaoMock = mock(ProductDao.class);
    private SearchProductsByRegexImp searchProductsByRegexImp = new SearchProductsByRegexImp(productDaoMock);

    @Before
    public void setUp() {
        when(productDaoMock.findAll()).thenReturn(Arrays.asList(productWithNameStartFromA, productWithNameStartFromE));
        productWithNameStartFromE.setName("EVA");
        productWithNameStartFromA.setName("artem");
        expectedProducts.add(productWithNameStartFromA);
    }

    @Test
    public void searchForTableProductsByRegex() {
        List<Product> products = searchProductsByRegexImp.searchForTableProductsByRegex(condition);
        assertEquals(expectedProducts, products);
    }
}