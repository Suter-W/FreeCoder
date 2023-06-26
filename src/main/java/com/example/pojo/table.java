package com.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class table {
    private String restID;
    private String tableID;
    private Integer tableLimit;
    private Integer tableUse;
    private String tableType;
    private String tableStatus;
}
