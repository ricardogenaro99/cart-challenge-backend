package com.xcaleconsulting.cartchallenge.data;

import com.xcaleconsulting.cartchallenge.domain.Cart;
import com.xcaleconsulting.cartchallenge.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class Data {
    public static Map<String, Cart> cartsData = new HashMap<>();
    public static Map<Integer, Product> productsData = new HashMap<>();
}
