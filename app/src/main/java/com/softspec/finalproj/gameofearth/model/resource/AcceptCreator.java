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
			list.add(new Resource.Creator(0, -200, 0).create());
			list.add(new Resource.Creator(1, -100, 5).create());
			list.add(new Resource.Creator(2, -112, 11).create());
			list.add(new Resource.Creator(3, 55, 12).create());
			list.add(new Resource.Creator(4, -12, -5).create());
			list.add(new Resource.Creator(5, 20, 10).create());
			list.add(new Resource.Creator(6, -3, -3).create());
			list.add(new Resource.Creator(7, 50, 10).create());
			list.add(new Resource.Creator(8, -33, -3).create());
			list.add(new Resource.Creator(9, -100, -4).create());
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
