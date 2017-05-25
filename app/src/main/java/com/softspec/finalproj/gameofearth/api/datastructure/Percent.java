package com.softspec.finalproj.gameofearth.api.datastructure;

import java.io.Serializable;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 5:50 PM
 */
public class Percent implements Serializable {
	public static long serialVersionUID = 1L;
	
	private long number;
	
	public Percent(long number) {
		this.number = number;
	}
	
	public double percent() {
		return number / 100.0;
	}
}
