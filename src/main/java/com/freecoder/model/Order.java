package com.freecoder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer orderID;
    private String restID;
    private Integer tableID;
    private String costumerID;
    private LocalDateTime orderTime;
    private Integer orderUse;
    private double orderPrice;
    private boolean isVIP;
    private Integer orderStatus;
}
