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
	private static final List<Question> list = new ArrayList<>();
	private Database db;
	
	@Override
	public List<Question> createList() {
		if (list.isEmpty()) {
			list.add(new Question("Toilet Paper", "Thieves are stealing our toilet paper in public toilets. Install facial recognition cameras so that each visitor can only take two pieces of toilet paper."));
			list.add(new Question("Gluten Free Labeling", "Business are claiming their products are gluten-free when they are not. We should set clear standards for gluten-free labeling!"));
			list.add(new Question("Ecofriendly Standards", "Companies are not meeting the eco-friendly standards. Let them continue for a small annual fine?"));
			list.add(new Question("Indigenous Benefits", "We should compensate the indigenous inhabitants with extra social benefits so they can live in harmony."));
			list.add(new Question("Cure the Cows", "Our cows are infected with a deadly disease! stop beef product until the cows are cured?"));
			list.add(new Question("test question 6", "this is test question 6"));
			list.add(new Question("test question 7", "this is test question 7"));
			list.add(new Question("test question 8", "this is test question 8"));
			list.add(new Question("test question 9", "this is test question 9"));
			list.add(new Question("test question 10", "this is test question 10"));
		}
		return list;
	}
	
	@Override
	public Creator setDatabase(Database database) {
		db = database;
		return this;
	}
	
	@Override
	public synchronized void insert() {
		for (Question q : createList()) {
			db.add(TableName.QUESTION, q);
		}
	}
}
