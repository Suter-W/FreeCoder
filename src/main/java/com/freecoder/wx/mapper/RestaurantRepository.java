package com.freecoder.wx.mapper;

import com.freecoder.wx.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    Restaurant findByRestID(String restID);
}