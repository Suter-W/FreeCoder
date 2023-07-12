package com.freecoder.wx.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "message")
public class Message {
    @Id
    @Column(name = "msgID", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "msgcontent", nullable = false)
    private String msgContent;

    @NotNull
    @Column(name = "msgtime", nullable = false)
    private Instant msgTime;

    @Size(max = 7)
    @NotNull
    @Column(name = "restid", nullable = false, length = 7)
    private String restid;

}