package com.freecoder.wx.mapper;

import com.freecoder.wx.model.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RestaurantRepositoryTest {
    @Autowired
    RestaurantRepository repository;

    @Test
    void FindRestaurantTest() {
        List<Restaurant> all = repository.findAll();
        System.out.println(all.get(0).toString());
    }
}