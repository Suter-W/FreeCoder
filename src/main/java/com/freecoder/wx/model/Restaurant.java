package com.freecoder.wx.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="restaurants")
public class Restaurant {
    public Restaurant(String restID) {
        this.restID = restID;
    }

    @Id
    private String restID;

    @Column(name = "password")
    private String password;

    @Column(name = "restname")
    private String RestName;

    @Column(name = "restaddr")
    private String RestAddr;

    @Column(name = "restphonenum")
    private String RestPhoneNum;
}
