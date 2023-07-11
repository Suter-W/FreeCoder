package com.freecoder.web.model;

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
public class DishCategory {
    private Integer dcID;

    private String restID;

    private String dcName;

    private Integer dcOrder;

    private Integer dishNumber;

}
