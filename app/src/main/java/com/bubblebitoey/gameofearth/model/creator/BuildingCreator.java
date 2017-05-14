package com.bubblebitoey.gameofearth.model.creator;

import com.bubblebitoey.gameofearth.model.Building;
import com.bubblebitoey.gameofearth.model.database.Database;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 14/May/2017 - 9:23 PM
 */
public class BuildingCreator implements Creator<Building> {
	@Override
	public void insert(Database<Building> database) {
		// database.add(new Building());
	}
}
