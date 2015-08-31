package com.netshoes.inka.sample.drools.facts;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DynamicShipping {

	private boolean eligibleDiscount = true;
	private boolean eligibleFreeShipping = true;
	private boolean eligibleOvercharge = true;
	private int discount = 0;
	private boolean freeShipping = false;
	private List<String> appliedRules = new ArrayList<String>();

	public void addDiscount(int discount) {
		this.discount += discount;
	}

	public void addAppliedRule(String ruleName) {
		this.appliedRules.add(ruleName);
	}
}
