package com.bubblebitoey.gameofearth.api.constants;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public enum Value {
	CO2("resource_carbon_id"), MONEY("resource_money_id"), POPULATION("resource_population_id");
	
	private String key;
	
	Value(String key) {
		this.key = key;
	}
	
	public String getDatabaseKey() {
		return key;
	}
}
