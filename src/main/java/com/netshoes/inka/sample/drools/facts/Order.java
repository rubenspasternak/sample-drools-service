package com.netshoes.inka.sample.drools.facts;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Order {

	private int subtotal;
	private List<Product> products;
	private String storeUID;
	private Integer zipCode;
	private String customerProfile;

}
