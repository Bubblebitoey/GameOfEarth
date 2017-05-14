package com.bubblebitoey.gameofearth.model;

import android.content.ContentValues;
import android.support.annotation.Nullable;
import com.bubblebitoey.gameofearth.api.constants.Value;
import com.bubblebitoey.gameofearth.model.database.ResourceDatabase;
import com.bubblebitoey.gameofearth.model.database.ResourceTypeDatabase;

import java.util.*;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class Resource implements DatabaseSavable<ResourceDatabase> {
	private long id;
	private Map<Value, ResourceValue> map;
	
	public Resource() {
		this(-1);
	}
	
	public Resource(long id) {
		this.id = id;
	}
	
	public Resource add(Value v, ResourceValue rv) {
		map.put(v, rv);
		return this;
	}
	
	public long getId() {
		return id;
	}
	
	public ResourceValue getPair(Value v) {
		return map.get(v);
	}
	
	@Override
	public ContentValues getInsertQuery(ResourceDatabase db) {
		String[] array = db.getColumnArray();
		ContentValues values = new ContentValues(array.length);
		values.put(array[1], getPair(Value.CO2).getId());
		values.put(array[2], getPair(Value.MONEY).getId());
		values.put(array[3], getPair(Value.POPULATION).getId());
		return values;
	}
	
	public static class ResourceValue implements DatabaseSavable<ResourceTypeDatabase> {
		private long id;
		private Integer integer;
		
		public ResourceValue(@Nullable Integer integer) {
			this(-1, integer);
		}
		
		public ResourceValue(long id, @Nullable Integer integer) {
			this.id = id;
			this.integer = integer;
		}
		
		public Long getId() {
			return id == -1 ? null: id;
		}
		
		public void setId(long id) {
			this.id = id;
		}
		
		public Integer getInteger() {
			return integer;
		}
		
		@Override
		public ContentValues getInsertQuery(ResourceTypeDatabase db) {
			String[] array = db.getColumnArray();
			ContentValues values = new ContentValues(array.length);
			values.put(array[1], getInteger());
			return values;
		}
	}
}
