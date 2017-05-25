package com.softspec.finalproj.gameofearth.model.strategy;

import com.softspec.finalproj.gameofearth.api.datastructure.Percent;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 5:37 PM
 */
public class DefaultGameStrategy implements GameStrategy {
	@Override
	public long getDefaultCO2() {
		return 500;
	}
	
	@Override
	public Percent getDefaultPopulation() {
		return new Percent(10);
	}
	
	@Override
	public Calendar getDefaultDate() {
		return new GregorianCalendar(2017, 1, 1);
	}
}
