package com.xcaleconsulting.cartchallenge.service;

import com.xcaleconsulting.cartchallenge.entity.Product;
import com.xcaleconsulting.cartchallenge.repository.EntityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProductService {
    private Map<Integer, Product> repository = EntityRepository.products;
    private static AtomicInteger idGenerator = new AtomicInteger(1);

    public ProductService(){
        this.createProduct(new Product("Producto1", 10.5));
        this.createProduct(new Product("Producto2", 10.5));
    }

    public Product createProduct(Product product) {
        product.setId(idGenerator.getAndIncrement());
        repository.put(product.getId(), product);
        return product;
    }

    public void removeProduct(Integer productId) {
        repository.remove(productId);
    }

    public Product getProduct(Integer productId) {
        return repository.get(productId);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(repository.values());
    }

}

