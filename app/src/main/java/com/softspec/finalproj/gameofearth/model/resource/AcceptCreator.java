package com.softspec.finalproj.gameofearth.model.resource;

import com.softspec.finalproj.gameofearth.api.constants.TableName;
import com.softspec.finalproj.gameofearth.model.creator.Creator;
import com.softspec.finalproj.gameofearth.model.database.Database;
import com.softspec.finalproj.gameofearth.model.question.Question;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Wed 24/May/2017 - 11:58 PM
 */
public class AcceptCreator implements Creator<Resource> {
	private static final List<Resource> list = new ArrayList<>();
	private Database database;
	
	@Override
	public List<Resource> createList() {
		long id = Question.static_id;
		if (list.isEmpty()) {
			list.add(new Resource.Creator(0, 5, 3).create());
			list.add(new Resource.Creator(1, 1, 5).create());
			list.add(new Resource.Creator(2, 12, 11).create());
			list.add(new Resource.Creator(3, 55, 23).create());
			list.add(new Resource.Creator(4, 2, 40).create());
		}
		return list;
	}
	
	@Override
	public Creator setDatabase(Database database) {
		this.database = database;
		return this;
	}
	
	@Override
	public synchronized void insert() {
		for (Resource r : createList()) {
			database.add(TableName.ACCEPTANCE, r);
		}
	}
}
