package com.freecoder.wx.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @Column(name = "orderitemid", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "orderid", nullable = false)
    private Integer orderID;

    @Size(max = 255)
    @NotNull
    @Column(name = "dishname", nullable = false)
    private String dishName;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "unitprice", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "orderitemprice", precision = 10, scale = 2)
    private BigDecimal orderItemPrice;

    @Size(max = 7)
    @Column(name = "restid", length = 7)
    private String restID;

    @NotNull
    @Column(name = "dishid", nullable = false)
    private Integer dishID;

}