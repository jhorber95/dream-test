package org.example.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Category {
    private String name;
    private Set<Category> categories;
    private Set<String> keyWords;

}
