package com.freecoder.wx.model;

import com.freecoder.web.model.Restaurant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
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
    @Column(name = "costumerid", nullable = false, length = 10)
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