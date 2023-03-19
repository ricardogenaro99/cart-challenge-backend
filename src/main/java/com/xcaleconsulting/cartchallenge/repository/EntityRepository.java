package com.xcaleconsulting.cartchallenge.repository;

import com.xcaleconsulting.cartchallenge.entity.Cart;
import com.xcaleconsulting.cartchallenge.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EntityRepository {
    public static Map<String, Cart> carts = new HashMap<>();
    public static Map<Integer, Product> products = new HashMap<>();
}
