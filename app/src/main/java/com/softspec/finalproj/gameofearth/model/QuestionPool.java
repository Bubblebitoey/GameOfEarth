package com.softspec.finalproj.gameofearth.model;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Wed 24/May/2017 - 10:06 PM
 */
public class QuestionPool {
	private List<Question> questions;
	
	public QuestionPool(List<Question> q) {
		this.questions = q;
	}
	
	public boolean isEmpty() {
		return questions == null || questions.size() == 0;
	}
	
	public void add(Question q) {
		questions.add(q);
	}
	
	public void clear() {
		questions.clear();
	}
}
