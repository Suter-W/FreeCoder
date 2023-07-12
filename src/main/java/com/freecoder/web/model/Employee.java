package com.freecoder.web.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String avatar_url;
    private boolean is_vip;
    private String nick_name;
    private String open_id;
    private String phone_num;
    private String type;
    private String restID;
}
