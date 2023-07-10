package com.freecoder.wx.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

/**
 * @ClassName Customer
 * @Description 餐厅顾客 -- 微信小程序端
 * @DATE 2023/7/7 10:15
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {
    /**
     * 自定义id,用于数据查询
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;


    /**
     * 微信小程序openid
     */
    @Column(unique = true, nullable = false)
    @NonNull
    private String openId;

    private String sessionKey;

    private String nickName;

    @URL
    private String avatarUrl;

    private boolean isVip;
}

