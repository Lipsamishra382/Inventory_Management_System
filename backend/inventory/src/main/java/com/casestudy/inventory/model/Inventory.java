package com.casestudy.inventory.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "inventory")
public class Inventory {

    //@Indexed(direction = IndexDirection.ASCENDING,unique = true)
    //@Field(name="Id",write = Field.Write.NON_NULL)


    @Id private int id;

    //@Field(name = "LocationNbr",write = Field.Write.NON_NULL)

    private int locationNbr;

    //@Field(name = "MaterialId",write = Field.Write.NON_NULL)
    private String materialId;

    //@Field(name = "ResetQty",write = Field.Write.NON_NULL)
    private int resetQty;

    //@Field(name = "OrderQty",write = Field.Write.NON_NULL)
    private int orderQty;

    //@Field(name = "AvailableQuantity",write = Field.Write.NON_NULL)
    private int availableQuantity;

    //@Field(name = "UpdateDateTime",write = Field.Write.NON_NULL)
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:MM:ss")
   @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date updateDateTime;

}
