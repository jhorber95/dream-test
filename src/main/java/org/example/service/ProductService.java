package org.example.service;

import org.example.model.Category;
import org.example.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductService {
    public List<String> getKeyWord(String category, List<Product> products) {
        List<String> keyWords = new ArrayList<>();

        products.forEach(p -> {
            if(p.getCategory().getName().equals(category)) {
                keyWords.addAll(p.getCategory().getKeyWords());
                keyWords.addAll(getCategory(p.getCategory().getCategories()));
            }
        });

        return keyWords;
    }

    public List<String> getCategory(Set<Category> categories) {
        List<String> list = new ArrayList<>();

        for (Category category: categories) {
            list.addAll(category.getKeyWords());
            if (category.getCategories()!= null && !category.getCategories().isEmpty()) {
                getCategory(category.getCategories());
            }
        }
        return list;
    }

    public int getLevel(String categoryName, Category category, int cont) {

        if (category.getCategories() == null || category.getCategories().isEmpty()) return cont;

        for (Category c : category.getCategories()) {
            if (!c.getName().equals(categoryName)) {
                cont += 1;
                getLevel(categoryName, c, cont);
            }
        }
        return cont;
    }
}
