package com.softspec.finalproj.gameofearth.model.strategy;

import com.softspec.finalproj.gameofearth.api.datastructure.Percent;

import java.io.Serializable;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 5:49 PM
 */
public interface PopulationStrategy extends Serializable {
	/**
	 * this for calculate co2 to decrease current population
	 *
	 * @param co2
	 * 		total number of co2
	 * @return percent of increasing current population
	 */
	Percent calculationFromCO2(long co2);
	
	/**
	 * this for calculate decrease population
	 *
	 * @param co2
	 * 		total number of co2
	 * @return percent to decreasing population
	 */
	Percent calculationToThis(long co2);
	
	//percent -> population
	//people -> current pop
}
