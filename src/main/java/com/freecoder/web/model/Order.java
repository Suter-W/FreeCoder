package com.freecoder.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {
    @Id
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
