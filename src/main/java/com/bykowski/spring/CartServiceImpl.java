package com.bykowski.spring;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CartServiceImpl implements CartService {

    private List<Product> listOfProducts;

    public CartServiceImpl() {
        Random r = new Random();

        Product prod1 = new Product("Komp", (r.nextInt(251)+50));
        Product prod2 = new Product("Proc", (r.nextInt(251)+50));
        Product prod3 = new Product("MotherB",(r.nextInt(251)+50));
        Product prod4 = new Product("RAM",(r.nextInt(251)+50));
        Product prod5 = new Product("HDD",(r.nextInt(251)+50));

        listOfProducts = new ArrayList<>();

        listOfProducts.add(prod1);
        listOfProducts.add(prod2);
        listOfProducts.add(prod3);
        listOfProducts.add(prod4);
        listOfProducts.add(prod5);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void showProducts() {
        this.listOfProducts.forEach(System.out::println);
    }
}
