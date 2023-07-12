package com.freecoder.wx.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTypeTest {
    @Test
    void intToEnum(){
        System.out.println(EmployeeType.COOK);
        System.out.println(EmployeeType.valueOf(String.valueOf("COOK")));
    }
}