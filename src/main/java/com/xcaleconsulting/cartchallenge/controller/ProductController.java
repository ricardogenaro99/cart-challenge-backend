package com.xcaleconsulting.cartchallenge.controller;

import com.xcaleconsulting.cartchallenge.entity.Product;
import com.xcaleconsulting.cartchallenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService cartService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Product createProduct(@RequestBody Product product ) {
        return cartService.createProduct(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List <Product> getProducts() {
        return cartService.getProducts();
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable Integer productId) {
        return cartService.getProduct(productId);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeProduct(@PathVariable Integer productId) {
        cartService.removeProduct(productId);
    }
}
