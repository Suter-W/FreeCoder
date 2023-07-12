package com.freecoder.wx.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * @ClassName Customer
 * @Description 餐厅顾客 -- 微信小程序端
 * @DATE 2023/7/7 10:15
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {
    /**
     * 自定义id,用于数据查询
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    /**
     * 微信小程序openid
     */
    @Column(unique = true, nullable = false)
    @NonNull
    private String openId;

    private String sessionKey;

    private String nickName;

    private String avatarUrl;

    @Column(unique = true)
    private String phoneNum;

    private EmployeeType type;

    @ManyToOne
    @JoinColumn(name = "rest_id")
    private Restaurant restaurant;
}



