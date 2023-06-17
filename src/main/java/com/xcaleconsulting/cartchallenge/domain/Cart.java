package com.xcaleconsulting.cartchallenge.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Cart {
    private final String id;
    private final List<Order> orderList;
    private final LocalDateTime creationTime;
    private LocalDateTime updateTime;


    public Cart() {
        this.id = UUID.randomUUID().toString();
        this.orderList = new ArrayList<>();
        this.creationTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(this.updateTime.plusMinutes(10));
    }
}

