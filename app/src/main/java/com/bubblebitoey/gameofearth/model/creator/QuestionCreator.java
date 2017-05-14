package com.bubblebitoey.gameofearth.model.creator;

import com.bubblebitoey.gameofearth.model.Question;
import com.bubblebitoey.gameofearth.model.database.Database;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 14/May/2017 - 10:01 PM
 */
public class QuestionCreator implements Creator<Question> {
	@Override
	public void insert(Database<Question> database) {
		// database.add(new Question().setAccept().setReject());
	}
}
