package com.bubblebitoey.gameofearth.model.creator;

import com.bubblebitoey.gameofearth.model.Resource;
import com.bubblebitoey.gameofearth.model.database.Database;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 14/May/2017 - 10:11 PM
 */
public class ResourceTypeCreator implements Creator<Resource.ResourceValue> {
	@Override
	public void insert(Database<Resource.ResourceValue> database) {
		database.add(new Resource.ResourceValue(5));
		database.add(new Resource.ResourceValue(10));
		database.add(new Resource.ResourceValue(15));
		database.add(new Resource.ResourceValue(25));
		database.add(new Resource.ResourceValue(40));
	}
}
