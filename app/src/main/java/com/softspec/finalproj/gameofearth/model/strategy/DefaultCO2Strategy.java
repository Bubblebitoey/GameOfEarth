package com.softspec.finalproj.gameofearth.model.strategy;

import com.softspec.finalproj.gameofearth.api.datastructure.Percent;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 5:52 PM
 */
public class DefaultCO2Strategy implements CO2Strategy {
	public static long serialVersionUID = 1L;
	
	@Override
	public Percent calculationFromPopulation(long population) {
		return new Percent(population / 500);
	}
}
