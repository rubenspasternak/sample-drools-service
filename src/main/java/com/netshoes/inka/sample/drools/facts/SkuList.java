package com.netshoes.inka.sample.drools.facts;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SkuList {

	private List<String> skuList = new ArrayList<String>();

	public void addSkuCode(String skuCode) {
		skuList.add(skuCode);
	}

}
