package com.softspec.finalproj.gameofearth.model.question;

import com.softspec.finalproj.gameofearth.api.constants.TableName;
import com.softspec.finalproj.gameofearth.model.creator.Creator;
import com.softspec.finalproj.gameofearth.model.database.Database;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 14/May/2017 - 10:01 PM
 */
public class QuestionCreator implements Creator<Question> {
	private List<Question> list = new ArrayList<>();
	private Database db;
	
	@Override
	public Creator setList(List<Question> list) {
		this.list = list;
		return this;
	}
	
	@Override
	public Creator setDatabase(Database database) {
		db = database;
		return this;
	}
	
	@Override
	public synchronized void insert() {
		for (Question q : list) {
			db.add(TableName.QUESTION, q);
		}
	}
}
