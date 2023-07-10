package com.freecoder.web.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Tables {
    @Id
    private Integer tableID;
    private String restID;
    private String tableName;
    private Integer tableLimit;
    private Integer tableUse;
    private String tableType;
    private String tableStatus;
}
