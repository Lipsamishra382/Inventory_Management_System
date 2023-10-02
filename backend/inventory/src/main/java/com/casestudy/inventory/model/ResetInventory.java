package com.casestudy.inventory.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ResetInventory")
public class ResetInventory {

    private int locationNbr;

    @Id
    private String materialId;

    private int resetQty;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date resetDateTime;
}
