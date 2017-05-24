package com.softspec.finalproj.gameofearth.model.question;

import com.softspec.finalproj.gameofearth.model.creator.Creator;
import com.softspec.finalproj.gameofearth.model.database.Database;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 14/May/2017 - 10:01 PM
 */
public class QuestionCreator implements Creator<Question> {
	private static final List<Question> list = new ArrayList<>();
	private Database db;
	
	@Override
	public List<Question> createList() {
		if (list.isEmpty()) {
			list.add(new Question("test question 1", "this is test question 1"));
			list.add(new Question("test question 2", "this is test question 2"));
			list.add(new Question("test question 3", "this is test question 3"));
			list.add(new Question("test question 4", "this is test question 4"));
			list.add(new Question("test question 5", "this is test question 5"));
		}
		return list;
	}
	
	@Override
	public Creator setDatabase(Database database) {
		db = database;
		return this;
	}
	
	@Override
	public void insert() {
		for (Question q : createList()) {
			db.add(q);
		}
	}
}
