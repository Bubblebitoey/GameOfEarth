package com.softspec.finalproj.gameofearth.model.creator;


import com.softspec.finalproj.gameofearth.model.database.Database;
import com.softspec.finalproj.gameofearth.model.database.DatabaseSavable;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 14/May/2017 - 9:23 PM
 */
public interface Creator<D extends DatabaseSavable> {
	Creator setList(List<D> list);
	
	Creator setDatabase(Database database);
	
	void insert();
}
