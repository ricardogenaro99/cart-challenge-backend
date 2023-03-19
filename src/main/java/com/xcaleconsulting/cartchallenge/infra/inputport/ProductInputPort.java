package com.xcaleconsulting.cartchallenge.infra.inputport;

import com.xcaleconsulting.cartchallenge.domain.Product;

import java.util.List;

public interface ProductInputPort {
    public Product createProduct(Product product);

    public void removeProduct(Integer productId);

    public Product getProduct(Integer productId);

    public List<Product> getProducts();
}
