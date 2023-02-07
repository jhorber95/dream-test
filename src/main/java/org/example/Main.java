package org.example;

import org.example.model.Category;
import org.example.model.Product;
import org.example.service.ProductService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
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

        products.add(fork);
//        products.add(stove);

        ProductService service = new ProductService();


        System.out.println(service.getKeyWord("home", products));
        System.out.println(service.getLevel("minor_other", home, 0));

    }
}