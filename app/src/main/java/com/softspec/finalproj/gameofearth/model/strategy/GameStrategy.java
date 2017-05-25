package com.softspec.finalproj.gameofearth.model.strategy;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 4:45 PM
 */
public interface GameStrategy {
	long getDefaultCO2();
	
	long getDefaultPopulation();
	
	Date getDefaultDate();
}
