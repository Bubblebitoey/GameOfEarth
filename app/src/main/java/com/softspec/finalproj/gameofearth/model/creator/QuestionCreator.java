package com.softspec.finalproj.gameofearth.model.creator;

import com.softspec.finalproj.gameofearth.model.Question;
import com.softspec.finalproj.gameofearth.model.database.Database;
import com.softspec.finalproj.gameofearth.model.database.QuestionDatabase;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 14/May/2017 - 10:01 PM
 */
public class QuestionCreator implements Creator<Question, QuestionDatabase> {
	private Database db;
	
	@Override
	public List<Question> createList() {
		
		return null;
	}
	
	@Override
	public Creator setDatabase(QuestionDatabase database) {
		db = database;
		return this;
	}
	
	@Override
	public void insert() {
		db.add(new Question("", ""));
	}
}
