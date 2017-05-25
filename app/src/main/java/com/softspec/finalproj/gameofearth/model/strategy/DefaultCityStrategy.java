package com.softspec.finalproj.gameofearth.model.strategy;

import com.softspec.finalproj.gameofearth.api.constants.CityLevel;
import com.softspec.finalproj.gameofearth.model.game.GameLogic;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 5:05 PM
 */
public class DefaultCityStrategy implements CityStrategy {
	@Override
	public CityLevel getCurrentLevel(GameLogic logic) {
		long population = logic.getCurrentPopulation();
		if (population > 1_000_000_000L) {
			return CityLevel.LEVEL_5;
		} else if (population > 100_000_000L) {
			return CityLevel.LEVEL_4;
		} else if (population > 10_000_000L) {
			return CityLevel.LEVEL_3;
		} else if (population > 2_500_000L) {
			return CityLevel.LEVEL_2;
		} else if (population > 500_000L) {
			return CityLevel.LEVEL_1;
		} else {
			return CityLevel.LEVEL_0;
		}
	}
}
