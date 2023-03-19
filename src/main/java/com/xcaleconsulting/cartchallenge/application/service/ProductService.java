package com.xcaleconsulting.cartchallenge.application.service;

import com.xcaleconsulting.cartchallenge.domain.Product;
import com.xcaleconsulting.cartchallenge.infra.inputport.ProductInputPort;
import com.xcaleconsulting.cartchallenge.infra.outputport.ProductOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ProductService implements ProductInputPort {
    @Autowired
    ProductOutputPort productRepository;
    AtomicInteger idGenerator = new AtomicInteger(1);

    @Override
    public Product createProduct(Product product) {
        product.setId(idGenerator.getAndIncrement());
        productRepository.put(product.getId(), product);
        return product;
    }

    @Override
    public void removeProduct(Integer productId) {
        productRepository.remove(productId);
    }

    @Override
    public Product getProduct(Integer productId) {
        return productRepository.get(productId);
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(productRepository.values());
    }

}

