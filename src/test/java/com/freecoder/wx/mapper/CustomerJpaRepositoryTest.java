package com.freecoder.wx.mapper;

import com.freecoder.wx.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerJpaRepositoryTest {
    @Autowired
    CustomerJpaRepository repository;

    @Test
    void saveCustomerTest() {
        List<Customer> all = repository.findAll();
        System.out.println(all.size());
    }
}