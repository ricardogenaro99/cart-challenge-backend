package com.xcaleconsulting.cartchallenge.service;

import com.xcaleconsulting.cartchallenge.entity.Cart;
import com.xcaleconsulting.cartchallenge.entity.Order;
import com.xcaleconsulting.cartchallenge.entity.Product;
import com.xcaleconsulting.cartchallenge.exeption.CustomExeption;
import com.xcaleconsulting.cartchallenge.repository.EntityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class CartService {
    private Map<String, Cart> repository = EntityRepository.carts;
    private Map<Integer, Product> productRepository = EntityRepository.products;

    private void updateCart (Cart cart) {
        cart.getOrderList().removeIf(e -> e.getQuantity() == 0 );
        cart.setUpdateTime(LocalDateTime.now());
    }

    public Cart createCart() {
        Cart cart = new Cart();
        repository.put(cart.getId(), cart);
        return cart;
    }

    public void removeCart(String cartId) {
        repository.remove(cartId);
    }

    public Cart getCart(String cartId) {
        Cart cart = repository.get(cartId);
        if (cart == null) {
            cart = createCart();
        }
        if (cart.isExpired()) {
            removeCart(cartId);
            cart = createCart();
        }
        return cart;
    }

    public List<Cart> getCarts() {
        repository.values().removeIf(cart -> cart.isExpired());
        return new ArrayList<>(repository.values());
    }

    public Cart updateCart(String cartId, int productId, int quantity, boolean isAdd) throws CustomExeption {
        Product product = productRepository.get(productId);
        if(product == null) {
            throw new CustomExeption("400", HttpStatus.BAD_REQUEST,"Producto no encontrado");
        }
        Cart cart = repository.get(cartId);
        if (cart == null) {
            cart = createCart();
        }
        List <Order> orderList = cart.getOrderList().stream().filter(e -> e.getProduct().getId() == productId ).collect(Collectors.toList());
        if (orderList.size() == 0) {
            cart.getOrderList().add(new Order(product,quantity));
        } else {
            Order orderTmp = orderList.get(0);
            orderTmp.setQuantity(isAdd ? orderTmp.getQuantity() + quantity : quantity);
        }
        updateCart(cart);
        return cart;
    }
}

