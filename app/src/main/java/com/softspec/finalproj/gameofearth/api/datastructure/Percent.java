package com.softspec.finalproj.gameofearth.api.datastructure;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 5:50 PM
 */
public class Percent {
	
	private long number;
	
	public Percent(long number) {
		this.number = number;
	}
	
	public double percent() {
		return number / 100;
	}
}
