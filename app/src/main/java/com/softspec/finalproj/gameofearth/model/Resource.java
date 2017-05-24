package com.softspec.finalproj.gameofearth.model;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import com.softspec.finalproj.gameofearth.api.constants.DatabaseColumns;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class Resource implements DatabaseSavable {
	private long id;
	private long co2;
	private long pop;
	
	private Resource(long id) {
		this.id = id;
	}
	
	private void setCo2(long co2) {
		this.co2 = co2;
	}
	
	private void setPop(long pop) {
		this.pop = pop;
	}
	
	public long getCo2() {
		return co2;
	}
	
	public long getPop() {
		return pop;
	}
	
	@Override
	public ContentValues getInsertQuery() {
		ContentValues values = new ContentValues(2);
		// no id pass
		values.put(DatabaseColumns.CO2.getDatabaseKey(), getCo2());
		values.put(DatabaseColumns.POPULATION.getDatabaseKey(), getPop());
		return values;
	}
	
	static class Builder {
		private SQLiteOpenHelper sql;
		private long id;
		private long co2;
		private long pop;
		
		public Builder(SQLiteOpenHelper sql) {
			this.sql = sql;
		}
		
		public Builder setID(long id) {
			this.id = id;
			// TODO: 5/24/2017 AD sql all information
			return this;
		}
		
		private Builder setCo2(long co2) {
			this.co2 = co2;
			return this;
		}
		
		private Builder setPop(long pop) {
			this.pop = pop;
			return this;
		}
		
		public Resource build() {
			Resource s = new Resource(id);
			s.setCo2(co2);
			s.setPop(pop);
			return s;
		}
	}
}
