package com.freecoder.wx.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_info")
public class OrderInfo {
    @Id
    @Column(name = "orderID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restid", nullable = false)
    private Restaurant restID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "tableid", nullable = false)
    private TableInfo tableID;

    @Size(max = 10)
    @NotNull
    @Column(name = "costumerid", nullable = false)
    private String costumerid;

    @NotNull
    @Column(name = "ordertime", nullable = false)
    private Instant orderTime;

    @NotNull
    @Column(name = "orderuse", nullable = false)
    private Integer orderUse;

    @Column(name = "orderprice", precision = 10, scale = 2)
    private BigDecimal orderPrice;

    @NotNull
    @Column(name = "isvip", nullable = false)
    private Boolean isVIP = false;

    @NotNull
    @Column(name = "orderstatus", nullable = false)
    private Byte orderStatus;

    @Size(max = 255)
    @Column(name = "orderremark")
    private String orderRemark;
}