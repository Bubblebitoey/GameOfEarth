package com.softspec.finalproj.gameofearth.model.question;

import android.content.ContentValues;
import com.softspec.finalproj.gameofearth.api.constants.DatabaseColumns;
import com.softspec.finalproj.gameofearth.model.database.DatabaseSavable;
import com.softspec.finalproj.gameofearth.model.resource.Resource;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class Question implements DatabaseSavable {
	public static long static_id = 0;
	
	private long id;
	private String name;
	private String description;
	
	private Resource accept;
	private Resource deny;
	
	public Question(String name, String description) {
		id = static_id;
		this.name = name;
		this.description = description;
		static_id++;
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
		ContentValues values = new ContentValues(3);
		values.put(DatabaseColumns.ID.key(), getId());
		values.put(DatabaseColumns.Q_TITLE.key(), getName());
		values.put(DatabaseColumns.Q_DESCRIPTION.key(), getDescription());
		return values;
	}
	
	public static class Builder {
		private long id;
		private String name;
		private String description;
		
		private Resource accept;
		private Resource deny;
		
		public Builder(long id) {
			this.id = id;
			if (static_id < id) static_id = id;
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}
		
		public Builder setAccept(Resource accept) {
			this.accept = accept;
			return this;
		}
		
		public Builder setDeny(Resource deny) {
			this.deny = deny;
			return this;
		}
		
		
		public Question build() {
			Question q = new Question(name, description);
			q.id = this.id;
			q.accept = this.accept;
			q.deny = this.deny;
			return q;
		}
	}
}
