package com.xcaleconsulting.cartchallenge.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    private int id;
    private String description;
    private double amount;

    public Product(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }
}
