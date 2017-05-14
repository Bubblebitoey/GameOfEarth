package com.bubblebitoey.gameofearth.model.creator;

import com.bubblebitoey.gameofearth.model.Resource;
import com.bubblebitoey.gameofearth.model.database.Database;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 14/May/2017 - 10:07 PM
 */
public class ResourceCreator implements Creator<Resource> {
	@Override
	public void insert(Database<Resource> database) {
		database.add(new Resource());
	}
}
