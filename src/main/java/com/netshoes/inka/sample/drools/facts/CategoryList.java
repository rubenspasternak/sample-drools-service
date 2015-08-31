package com.netshoes.inka.sample.drools.facts;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CategoryList {

	private List<String> categoryList = new ArrayList<String>();

	public void addCategoryCode(String categoryCode) {
		categoryList.add(categoryCode);
	}

}
