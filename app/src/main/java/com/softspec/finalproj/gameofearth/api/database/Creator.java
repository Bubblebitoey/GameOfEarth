package com.softspec.finalproj.gameofearth.api.database;

import com.softspec.finalproj.gameofearth.model.database.Database;
import com.softspec.finalproj.gameofearth.model.question.Question;
import com.softspec.finalproj.gameofearth.model.question.QuestionCreator;
import com.softspec.finalproj.gameofearth.model.resource.AcceptCreator;
import com.softspec.finalproj.gameofearth.model.resource.DenyCreator;
import com.softspec.finalproj.gameofearth.model.resource.Resource;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 26/May/2017 - 2:11 AM
 */
public class Creator {
	private Map<Class<? extends com.softspec.finalproj.gameofearth.model.creator.Creator>, com.softspec.finalproj.gameofearth.model.creator.Creator> creators;
	private List<Resource> aResources = new ArrayList<>();
	private List<Resource> dResources = new ArrayList<>();
	private List<Question> questions = new ArrayList<>();
	
	public Creator(Database database) {
		creators = new HashMap<>();
		creators.put(QuestionCreator.class, new QuestionCreator().setDatabase(database));
		creators.put(AcceptCreator.class, new AcceptCreator().setDatabase(database));
		creators.put(DenyCreator.class, new DenyCreator().setDatabase(database));
		
		makeList();
	}
	
	private void addQuestion(String name, String description, long aCO2, long aPOP, long dCO2, long dPOP) {
		Resource accept = new Resource.Builder(Question.getStatic_id()).setCo2(aCO2).setPop(aPOP).build();
		Resource deny = new Resource.Builder(Question.getStatic_id()).setCo2(dCO2).setPop(dPOP).build();
		
		Question q = new Question(name, description);
		
		questions.add(q);
		aResources.add(accept);
		dResources.add(deny);
	}
	
	public synchronized void insert() {
		creators.get(QuestionCreator.class).setList(questions).insert();
		creators.get(AcceptCreator.class).setList(aResources).insert();
		creators.get(DenyCreator.class).setList(dResources).insert();
	}
	
	private void makeList() {
		addQuestion("tests1", "this is test 1", 12, 12, 12, 12);
		addQuestion("tests2", "this is test 2", 12, 12, 12, 12);
		addQuestion("tests3", "this is test 3", 12, 12, 12, 12);
		addQuestion("tests4", "this is test 4", 12, 12, 12, 12);
		addQuestion("tests5", "this is test 5", 12, 12, 12, 12);
	}
}
