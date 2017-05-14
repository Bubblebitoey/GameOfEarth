package com.bubblebitoey.gameofearth.model.creator;

import com.bubblebitoey.gameofearth.model.DatabaseSavable;
import com.bubblebitoey.gameofearth.model.database.Database;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 14/May/2017 - 9:23 PM
 */
public interface Creator<T extends DatabaseSavable> {
	void insert(Database<T> database);
}
