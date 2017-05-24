package com.softspec.finalproj.gameofearth.model;

import android.content.ContentValues;
import com.softspec.finalproj.gameofearth.api.constants.DatabaseColumns;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class Question implements DatabaseSavable {
	private long id;
	private String name;
	private String description;
	
	private Resource accept;
	private Resource deny;
	
	public Question(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Question setAccept(Resource accept) {
		this.accept = accept;
		return this;
	}
	
	public Question setDeny(Resource deny) {
		this.deny = deny;
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
	
	public Resource getDeny() {
		return deny;
	}
	
	@Override
	public ContentValues getInsertQuery() {
		ContentValues values = new ContentValues(2);
		// no id pass
		values.put(DatabaseColumns.Q_TITLE.getDatabaseKey(), getName());
		values.put(DatabaseColumns.Q_DESCRIPTION.getDatabaseKey(), getDescription());
		return values;
	}
}
