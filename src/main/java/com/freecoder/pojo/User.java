package com.freecoder.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
