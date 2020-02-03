package com.bykowski.spring;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private List<Product> listOfProducts;

    public CartServiceImpl() {
        Product prod1 = new Product("Komp", new BigDecimal(200));
        Product prod2 = new Product("Proc", new BigDecimal(100));
        Product prod3 = new Product("MotherB", new BigDecimal(150));

        listOfProducts = new ArrayList<>();

        listOfProducts.add(prod1);
        listOfProducts.add(prod2);
        listOfProducts.add(prod3);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showProducts() {
        this.listOfProducts.forEach(System.out::println);
    }
}
