package com.softspec.finalproj.gameofearth.model.strategy;

import com.softspec.finalproj.gameofearth.api.constants.CityLevel;
import com.softspec.finalproj.gameofearth.model.game.GameLogic;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 4:54 PM
 */
public interface CityStrategy {
	CityLevel getCurrentLevel(GameLogic logic);
}
