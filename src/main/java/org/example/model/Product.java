package org.example.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Product {

    private Set<String> keyWords;
    private Category category;
}
