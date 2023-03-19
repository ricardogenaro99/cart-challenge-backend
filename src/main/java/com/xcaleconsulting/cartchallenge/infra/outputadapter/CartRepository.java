package com.xcaleconsulting.cartchallenge.infra.outputadapter;

import com.xcaleconsulting.cartchallenge.domain.Cart;
import com.xcaleconsulting.cartchallenge.infra.outputport.CartOutputPort;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.xcaleconsulting.cartchallenge.data.Data.cartsData;

@Repository
public class CartRepository implements CartOutputPort {
    HashMap<String, Cart> enty = (HashMap<String, Cart>) cartsData;

    @Override
    public int size() {
        return enty.size();
    }

    @Override
    public boolean isEmpty() {
        return enty.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return enty.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return enty.containsValue(o);
    }

    @Override
    public Cart get(Object o) {
        return enty.get(o);
    }

    @Override
    public Cart put(String s, Cart cart) {
        return enty.put(s, cart);
    }

    @Override
    public Cart remove(Object o) {
        return enty.remove(o);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Cart> map) {
        enty.putAll(map);
    }

    @Override
    public void clear() {
        enty.clear();
    }

    @Override
    public Set<String> keySet() {
        return enty.keySet();
    }

    @Override
    public Collection<Cart> values() {
        return enty.values();
    }

    @Override
    public Set<Entry<String, Cart>> entrySet() {
        return enty.entrySet();
    }
}
