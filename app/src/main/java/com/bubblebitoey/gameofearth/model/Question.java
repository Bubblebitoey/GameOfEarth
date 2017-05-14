package com.bubblebitoey.gameofearth.model;

import android.content.ContentValues;
import com.bubblebitoey.gameofearth.model.database.QuestionDatabase;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class Question implements DatabaseSavable<QuestionDatabase> {
	private long id;
	private String name;
	private String description;
	
	private Resource accept;
	private Resource reject;
	
	public Question(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Question(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Question setAccept(Resource accept) {
		this.accept = accept;
		return this;
	}
	
	public Question setReject(Resource reject) {
		this.reject = reject;
		return this;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Resource getAccept() {
		return accept;
	}
	
	public Resource getReject() {
		return reject;
	}
	
	@Override
	public ContentValues getInsertQuery(QuestionDatabase db) {
		String[] array = db.getColumnArray();
		ContentValues values = new ContentValues(array.length);
		// no id pass
		values.put(array[1], getName());
		values.put(array[2], getDescription());
		values.put(array[3], getAccept().getId());
		values.put(array[4], getReject().getId());
		return values;
	}
}
