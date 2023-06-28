package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Delete;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String restID;

    private String password;

    private String RestName;

    private String RestAddr;

    private String RestPhoneNum;
}
