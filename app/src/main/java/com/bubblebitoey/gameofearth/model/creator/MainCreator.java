package com.bubblebitoey.gameofearth.model.creator;

import com.bubblebitoey.gameofearth.model.Building;
import com.bubblebitoey.gameofearth.model.Question;
import com.bubblebitoey.gameofearth.model.Resource;
import com.bubblebitoey.gameofearth.model.database.Database;

import java.lang.reflect.ParameterizedType;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 14/May/2017 - 10:43 PM
 */
public class MainCreator {
	public static void insert(Database... databases) {
		for (Database d : databases) {
			String className = ((ParameterizedType) d.getClass().getGenericSuperclass()).getActualTypeArguments()[0].getClass().getName();
			if (className.equals(Building.class.getName())) {
				new BuildingCreator().insert(d);
			} else if (className.equals(Question.class.getName())) {
				new QuestionCreator().insert(d);
			} else if (className.equals(Resource.class.getName())) {
				new ResourceCreator().insert(d);
			} else if (className.equals(Resource.ResourceValue.class.getName())) {
				new ResourceTypeCreator().insert(d);
			}
		}
	}
}
