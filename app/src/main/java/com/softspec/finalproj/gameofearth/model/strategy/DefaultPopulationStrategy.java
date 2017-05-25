package com.softspec.finalproj.gameofearth.model.strategy;

import com.softspec.finalproj.gameofearth.api.datastructure.Percent;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 10:47 PM
 */
public class DefaultPopulationStrategy implements PopulationStrategy {
	/**
	 * this for calculate co2 to decrease current population
	 *
	 * @param co2
	 * 		total number of co2
	 * @return percent of increasing current population
	 */
	@Override
	public Percent calculationFromCO2(long co2) {
		return new Percent(co2 / 150);
	}
	
	/**
	 * this for calculate decrease population
	 *
	 * @param co2
	 * 		total number of co2
	 * @return percent to decreasing population
	 */
	@Override
	public Percent calculationToThis(long co2) {
		return new Percent(co2 / 2000);
	}
}
