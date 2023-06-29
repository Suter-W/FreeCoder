package com.freecoder.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private Integer orderItemID;
    private Integer orderID;
    private String dishName;
    private Integer quantity;
    private double unitPrice;
    private double orderItemPrice;
}
