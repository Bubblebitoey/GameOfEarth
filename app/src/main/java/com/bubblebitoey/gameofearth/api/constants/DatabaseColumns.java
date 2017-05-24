package com.bubblebitoey.gameofearth.api.constants;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */
public enum Value {
	/**
	 * question id
	 */
	Q_ID("q_id"),
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
	A_CO2("a_c"),
	/**
	 * acceptance population
	 */
	A_POPULATION("a_p"),
	/**
	 * declination co2
	 */
	D_CO2("d_c"),
	/**
	 * declination population
	 */
	D_POPULATION("d_p");
	
	private String key;
	
	Value(String key) {
		this.key = key;
	}
	
	public String getDatabaseKey() {
		return key;
	}
}
