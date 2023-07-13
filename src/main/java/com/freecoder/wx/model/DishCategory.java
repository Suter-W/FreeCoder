package com.freecoder.wx.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dish_category")
public class DishCategory {
    @Id
    @Column(name = "dcID", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "restID", nullable = false)
    private String restID;

    @Size(max = 255)
    @NotNull
    @Column(name = "dcname", nullable = false)
    private String dcName;

    @NotNull
    @Column(name = "dcorder", nullable = false)
    private Integer dcOrder;

    @NotNull
    @Column(name = "dishnumber", nullable = false)
    private Integer dishNumber;

}