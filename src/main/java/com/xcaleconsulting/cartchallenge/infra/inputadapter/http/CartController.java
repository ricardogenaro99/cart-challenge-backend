package com.xcaleconsulting.cartchallenge.infra.inputadapter.http;

import com.xcaleconsulting.cartchallenge.domain.Cart;
import com.xcaleconsulting.cartchallenge.exeption.CustomExeption;
import com.xcaleconsulting.cartchallenge.infra.inputport.CartInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    CartInputPort cartInputPort;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Cart createCart() {
        return cartInputPort.createCart();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cart> getCarts() {
        return cartInputPort.getCarts();
    }

    @GetMapping("/{cartId}")
    @ResponseStatus(HttpStatus.OK)
    public Cart getCartById(@PathVariable String cartId) {
        return cartInputPort.getCart(cartId);
    }

    @DeleteMapping("/{cartId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeCart(@PathVariable String cartId) {
        cartInputPort.removeCart(cartId);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addProductCart(@RequestBody Map<String, Object> payload) {
        try {
            Cart cart = cartInputPort.updateCart(payload, true);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } catch (CustomExeption e) {
            return new ResponseEntity<CustomExeption>(e, e.getStatus());
        }
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCart(@RequestBody Map<String, Object> payload) {
        try {
            Cart cart = cartInputPort.updateCart(payload, false);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } catch (CustomExeption e) {
            return new ResponseEntity<CustomExeption>(e, e.getStatus());
        }
    }
}
