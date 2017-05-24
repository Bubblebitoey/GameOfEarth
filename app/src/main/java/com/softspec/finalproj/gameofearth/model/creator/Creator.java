package com.softspec.finalproj.gameofearth.model.creator;


import com.softspec.finalproj.gameofearth.model.DatabaseSavable;
import com.softspec.finalproj.gameofearth.model.database.Database;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 14/May/2017 - 9:23 PM
 */
public interface Creator<D extends DatabaseSavable, T extends Database> {
	List<D> createList();
	
	Creator setDatabase(T database);
	
	void insert();
}
