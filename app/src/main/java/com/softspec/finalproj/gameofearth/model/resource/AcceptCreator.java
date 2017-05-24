package com.softspec.finalproj.gameofearth.model.resource;

import com.softspec.finalproj.gameofearth.model.question.Question;
import com.softspec.finalproj.gameofearth.model.creator.Creator;
import com.softspec.finalproj.gameofearth.model.question.QuestionCreator;
import com.softspec.finalproj.gameofearth.model.database.Database;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Wed 24/May/2017 - 11:58 PM
 */
public class AcceptCreator implements Creator<Resource> {
	private static final List<Resource> list = new ArrayList<>();
	private QuestionCreator questionCreator;
	private Database database;
	
	public AcceptCreator(QuestionCreator questionCreator) {
		this.questionCreator = questionCreator;
	}
	
	@Override
	public List<Resource> createList() {
		long id = Question.static_id;
		if (list.isEmpty()) {
			list.add(new Resource.Creator(0, 5, 12).create());
			list.add(new Resource.Creator(1, 5, 12).create());
			list.add(new Resource.Creator(2, 5, 12).create());
			list.add(new Resource.Creator(3, 5, 12).create());
			list.add(new Resource.Creator(4, 5, 12).create());
		}
		return list;
	}
	
	@Override
	public Creator setDatabase(Database database) {
		this.database = database;
		return this;
	}
	
	@Override
	public void insert() {
		for (Resource r : createList()) {
			database.add(r);
		}
	}
}
