package com.inventory.order.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Orders")
public class Order {

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private int orderId;

	private int locationNbr;
	private String materialId;
	private int orderQty;
	private String orderStatus;

	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date orderDateTime;
	


}
