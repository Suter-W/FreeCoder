package com.freecoder.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Restaurant {
    @Id
    @NonNull
    private String restID;

    private String password;

    private String RestName;

    private String RestAddr;

    private String RestPhoneNum;
}
