package com.softspec.finalproj.gameofearth.model.strategy;

import com.softspec.finalproj.gameofearth.api.datastructure.Percent;

import java.io.Serializable;
import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 4:45 PM
 */
public interface GameStrategy extends Serializable {
	
	long getDefaultCO2();
	
	Percent getDefaultPopulation();
	
	Calendar getDefaultDate();
}
