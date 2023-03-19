package com.xcaleconsulting.cartchallenge.infra.inputport;

import com.xcaleconsulting.cartchallenge.domain.Cart;
import com.xcaleconsulting.cartchallenge.exeption.CustomExeption;

import java.util.List;
import java.util.Map;

public interface CartInputPort {
    public void updateCart(Cart cart);

    public Cart createCart();

    public void removeCart(String cartId);

    public Cart getCart(String cartId);

    public List<Cart> getCarts();

    public Cart updateCart(Map<String, Object> payload, boolean isAdd) throws CustomExeption;
}
