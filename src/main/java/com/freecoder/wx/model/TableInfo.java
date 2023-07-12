package com.freecoder.wx.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "table_info")
public class TableInfo {
    public TableInfo(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "tableID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restID", nullable = false)
    private Restaurant restID;

    @Size(max = 10)
    @NotNull
    @Column(name = "tablename", nullable = false, length = 10)
    private String tableName;

    @Column(name = "tablelimit")
    private Integer tableLimit;

    @Column(name = "tableuse")
    private Integer tableUse;

    @Size(max = 10)
    @Column(name = "tabletype", length = 10)
    private String tableType;

    @Size(max = 10)
    @Column(name = "tablestatus", length = 10)
    private String tableStatus;

}