package com.xcaleconsulting.cartchallenge.infra.inputadapter.http;

import com.xcaleconsulting.cartchallenge.domain.Product;
import com.xcaleconsulting.cartchallenge.infra.inputport.ProductInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductInputPort productInputPort;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Product createProduct(@RequestBody Product product) {
        return productInputPort.createProduct(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts() {
        return productInputPort.getProducts();
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable Integer productId) {
        return productInputPort.getProduct(productId);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeProduct(@PathVariable Integer productId) {
        productInputPort.removeProduct(productId);
    }
}
