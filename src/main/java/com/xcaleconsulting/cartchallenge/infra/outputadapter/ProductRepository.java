package com.xcaleconsulting.cartchallenge.infra.outputadapter;

import com.xcaleconsulting.cartchallenge.domain.Product;
import com.xcaleconsulting.cartchallenge.infra.outputport.ProductOutputPort;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.xcaleconsulting.cartchallenge.data.Data.productsData;

@Repository
public class ProductRepository implements ProductOutputPort {
    HashMap<Integer, Product> enty = (HashMap<Integer, Product>) productsData;

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
    public Product get(Object o) {
        return enty.get(o);
    }

    @Override
    public Product put(Integer s, Product cart) {
        return enty.put(s, cart);
    }

    @Override
    public Product remove(Object o) {
        return enty.remove(o);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Product> map) {
        enty.putAll(map);
    }

    @Override
    public void clear() {
        enty.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return enty.keySet();
    }

    @Override
    public Collection<Product> values() {
        return enty.values();
    }

    @Override
    public Set<Entry<Integer, Product>> entrySet() {
        return enty.entrySet();
    }

}
