package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
