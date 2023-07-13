package com.freecoder.wx.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dish_info")
public class DishInfo {
    @Id
    @Column(name = "dishid", nullable = false)
    private Integer id;

    @Size(max = 7)
    @NotNull
    @Column(name = "restid", nullable = false, length = 7)
    private String restid;

    @Size(max = 255)
    @Column(name = "dishimage")
    private String dishImage;

    @Size(max = 255)
    @NotNull
    @Column(name = "dishname", nullable = false)
    private String dishName;

    @Size(max = 255)
    @Column(name = "dishdescription")
    private String dishDescription;

    @NotNull
    @Column(name = "dishprice", nullable = false, precision = 10, scale = 2)
    private BigDecimal dishPrice;

    @Size(max = 255)
    @NotNull
    @Column(name = "dishcategory", nullable = false)
    private String dishCategory;

    @Column(name = "vipprice", precision = 10, scale = 2)
    private BigDecimal vipPrice;

    @Column(name = "salesvolume")
    private Integer salesVolume;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "dcid")
    private DishCategory dcID;

}