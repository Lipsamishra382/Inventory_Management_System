package com.inventory.order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    private int id;
    private int locationNbr;
    private String materialId;
    private int resetQty;
    private int orderQty;
    private int availableQuantity;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date updateDateTime;
}
