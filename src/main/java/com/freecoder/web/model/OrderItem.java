package com.freecoder.web.model;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    private Integer orderItemID;
    private Integer orderID;
    private String dishName;
    private Integer quantity;
    private double unitPrice;
    private double orderItemPrice;
}
