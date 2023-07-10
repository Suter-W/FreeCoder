package com.freecoder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassName Message
 * @Description TODO
 * @DATE 2023/7/10 10:54
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer msgID;

    private String msgContent;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String  msgTime;

}
