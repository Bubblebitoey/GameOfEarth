package com.softspec.finalproj.gameofearth.model.game;

import com.softspec.finalproj.gameofearth.model.strategy.GameStrategy;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 4:57 PM
 */
public class GameLogic {
	/**
	 * current population
	 */
	private long currentPopulation;
	/**
	 * number of co2
	 */
	private long co2;
	/**
	 * percent of increasing population (per 5 second)
	 */
	private long population;
	
	/**
	 * current date
	 */
	private Date date;
	
	public GameLogic(GameStrategy s) {
		currentPopulation = 0;
		co2 = s.getDefaultCO2();
		population = s.getDefaultPopulation();
		date = s.getDefaultDate();
	}
	
	public long getCurrentPopulation() {
		return currentPopulation;
	}
}
