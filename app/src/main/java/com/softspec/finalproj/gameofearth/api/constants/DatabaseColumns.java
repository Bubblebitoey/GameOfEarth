package com.softspec.finalproj.gameofearth.api.constants;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */
public enum DatabaseColumns {
	/**
	 * question id
	 */
	ID("id"),
	/**
	 * question name
	 */
	Q_TITLE("q_title"),
	/**
	 * question description
	 */
	Q_DESCRIPTION("q_description"),
	/**
	 * acceptance co2
	 */
	CO2("co"),
	/**
	 * acceptance population
	 */
	POPULATION("pop");
	
	private String key;
	
	DatabaseColumns(String key) {
		this.key = key;
	}
	
	public String key() {
		return key;
	}
}
