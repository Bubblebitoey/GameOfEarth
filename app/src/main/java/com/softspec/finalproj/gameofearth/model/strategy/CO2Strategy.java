package com.softspec.finalproj.gameofearth.model.strategy;

import com.softspec.finalproj.gameofearth.api.datastructure.Percent;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 5:49 PM
 */
public interface CO2Strategy {
	Percent calculation(long input);
}
