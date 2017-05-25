package com.softspec.finalproj.gameofearth.model.resource;

import android.content.ContentValues;
import com.softspec.finalproj.gameofearth.api.constants.DatabaseColumns;
import com.softspec.finalproj.gameofearth.model.database.DatabaseSavable;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class Resource implements DatabaseSavable {
	private long id;
	private long co2;
	private long pop;
	
	protected Resource(long id) {
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
		values.put(DatabaseColumns.ID.key(), id);
		values.put(DatabaseColumns.CO2.key(), getCo2());
		values.put(DatabaseColumns.POPULATION.key(), getPop());
		return values;
	}
	
	public static class Builder {
		private long id;
		private long co2;
		private long pop;
		
		public Builder(long id) {
			this.id = id;
		}
		
		public Builder setCo2(long co2) {
			this.co2 = co2;
			return this;
		}
		
		public Builder setPop(long pop) {
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
	
	/**
	 * for {@link Creator} only!
	 */
	static class Creator {
		private long id;
		private long co2;
		private long pop;
		
		public Creator(long id, long co2, long pop) {
			this.id = id;
			this.co2 = co2;
			this.pop = pop;
		}
		
		public Resource create() {
			Resource r = new Resource(id);
			r.setCo2(co2);
			r.setPop(pop);
			return r;
		}
	}
}
