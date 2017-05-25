package com.softspec.finalproj.gameofearth.model.resource;

import com.softspec.finalproj.gameofearth.api.constants.TableName;
import com.softspec.finalproj.gameofearth.model.creator.Creator;
import com.softspec.finalproj.gameofearth.model.database.Database;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Wed 24/May/2017 - 11:58 PM
 */
public class DenyCreator implements Creator<Resource> {
	private List<Resource> list = new ArrayList<>();
	private Database database;
	
	@Override
	public Creator setList(List<Resource> list) {
		this.list = list;
		return this;
	}
	
	@Override
	public Creator setDatabase(Database database) {
		this.database = database;
		return this;
	}
	
	@Override
	public synchronized void insert() {
		for (Resource r : list) {
			database.add(TableName.DECLINATION, r);
		}
	}
}
