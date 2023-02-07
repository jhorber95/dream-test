package org.example.service;

import junit.framework.TestCase;
import org.example.model.Category;
import org.example.model.Product;
import org.junit.Test;

import java.util.*;

import static org.mockito.Mockito.verify;

public class ProductServiceTest {
    private List<Product> products = new ArrayList<>();

    public Product init() {
        products.clear();
        Category majorAppliances = Category.builder()
                .name("majorAppliances")
                .keyWords(new HashSet<>(Arrays.asList("major_some", "major_other", "major_common")))
                .build();
        Category minorAppliances = Category.builder()
                .name("minorAppliances")
                .keyWords(new HashSet<>(Arrays.asList("minor_fork", "minor_other", "minor_common")))
                .build();

        Set<Category> homeSubcategory = new HashSet<>(Arrays.asList(majorAppliances, minorAppliances));


        Category home = Category.builder()
                .name("home")
                .categories(homeSubcategory)
                .keyWords(new HashSet<>(Arrays.asList("h_other", "h_some", "h_common")))
                .build();

        Product fork = Product.builder()
                .category(home)
                .build();

       return fork;
    }

    @Test
    public void givenAValidCategoryShouldReturnKeyWordList() {
        products.add(init());
        ProductService service = new ProductService();
        List<String>kw =  service.getKeyWord("home", products);

        verify(kw);
    }
}
