package com.xcaleconsulting.cartchallenge.controller;

import com.xcaleconsulting.cartchallenge.entity.Cart;
import com.xcaleconsulting.cartchallenge.exeption.CustomExeption;
import com.xcaleconsulting.cartchallenge.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Cart createCart() {
        return cartService.createCart();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cart> getCarts() {
        return cartService.getCarts();
    }

    @GetMapping("/{cartId}")
    @ResponseStatus(HttpStatus.OK)
    public Cart getCartById(@PathVariable String cartId) {
        return cartService.getCart(cartId);
    }

    @DeleteMapping("/{cartId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeCart(@PathVariable String cartId) {
        cartService.removeCart(cartId);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> addProductCart(@RequestBody Map<String, Object> payload) {
        String cartId= payload.get("cartId").toString();
        int productId=Integer.parseInt(payload.get("productId").toString());
        int quantity= Integer.parseInt(payload.get("quantity").toString());
        try {
            Cart cart = cartService.updateCart(cartId, productId, quantity, true);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
        catch(CustomExeption e) {
            return new ResponseEntity<CustomExeption>(e, e.getStatus());
        }
    }
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> updateCart(@RequestBody Map<String, Object> payload) {
        String cartId= payload.get("cartId").toString();
        int productId=Integer.parseInt(payload.get("productId").toString());
        int quantity= Integer.parseInt(payload.get("quantity").toString());
        try {
            Cart cart = cartService.updateCart(cartId, productId, quantity, false);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
        catch(CustomExeption e) {
            return new ResponseEntity<CustomExeption>(e, e.getStatus());
        }
    }
}
