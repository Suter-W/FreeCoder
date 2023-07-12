package com.freecoder.web.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName DishCategory
 * @Description TODO
 * @DATE 2023/7/4 10:55
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dish_category")
public class DishCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dcID;

    private String restID;

    private String dcName;

    private Integer dcOrder;

    private Integer dishNumber;

}
