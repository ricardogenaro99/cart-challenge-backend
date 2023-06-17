package com.xcaleconsulting.cartchallenge.application.service;

import com.xcaleconsulting.cartchallenge.domain.Cart;
import com.xcaleconsulting.cartchallenge.domain.Order;
import com.xcaleconsulting.cartchallenge.domain.Product;
import com.xcaleconsulting.cartchallenge.exeption.CustomExeption;
import com.xcaleconsulting.cartchallenge.infra.inputport.CartInputPort;
import com.xcaleconsulting.cartchallenge.infra.outputport.CartOutputPort;
import com.xcaleconsulting.cartchallenge.infra.outputport.ProductOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CartService implements CartInputPort {

    @Autowired
    CartOutputPort cartRepository;
    @Autowired
    ProductOutputPort productRepository;


    @Override
    public void updateCart(Cart cart) {
        cart.getOrderList().removeIf(e -> e.getQuantity() == 0);
        cart.setUpdateTime(LocalDateTime.now());
    }

    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        cartRepository.put(cart.getId(), cart);
        return cart;
    }

    @Override
    public void removeCart(String cartId) {
        cartRepository.remove(cartId);
    }

    @Override
    public Cart getCart(String cartId) {
        Cart cart = cartRepository.get(cartId);
        if (Objects.isNull(cart)) {
            cart = createCart();
        }
        if (cart.isExpired()) {
            removeCart(cartId);
            cart = createCart();
        }
        return cart;
    }

    @Override
    public List<Cart> getCarts() {
        cartRepository.values().removeIf(Cart::isExpired);
        return new ArrayList<>(cartRepository.values());
    }

    @Override
    public Cart updateCart(Map<String, Object> payload, boolean isAdd) throws CustomExeption {
        String cartId = payload.get("cartId").toString();
        int productId = parseNumber(payload.get("productId"));
        int quantity = parseNumber(payload.get("quantity"));

        Product product = productRepository.get(productId);
        if (Objects.isNull(product)) {
            throw new CustomExeption("400", HttpStatus.BAD_REQUEST, "Producto no encontrado");
        }
        Cart cart = cartRepository.get(cartId);
        if (Objects.isNull(cart)) {
            cart = createCart();
        }
        List<Order> orderList = cart.getOrderList().stream().filter(e -> e.getProduct().getId() == productId).collect(Collectors.toList());
        if (orderList.size() == 0) {
            cart.getOrderList().add(new Order(product, quantity));
        } else {
            Order orderTmp = orderList.get(0);
            orderTmp.setQuantity(isAdd ? orderTmp.getQuantity() + quantity : quantity);
        }
        updateCart(cart);
        return cart;
    }

    private int parseNumber(Object o){
        try {
            return Integer.parseInt(o.toString());
        } catch (NumberFormatException e) {
            throw new CustomExeption("400", HttpStatus.BAD_REQUEST, "Valores incorrectos");
        }
    }
}

