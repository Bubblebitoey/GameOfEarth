package com.bubblebitoey.gameofearth.model;

import android.content.ContentValues;
import com.bubblebitoey.gameofearth.model.database.BuildingDatabase;

/**
 * Created by bubblebitoey on 5/7/2017 AD.
 */
public class Building implements DatabaseSavable<BuildingDatabase> {
	private long id;
	private String name;
	private String description;
	private long co2;
	private long treasury;
	
	private boolean isEco;
	
	public Building(long id, String name, String description, long co2, long treasury, boolean isEco) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.co2 = co2;
		this.treasury = treasury;
		this.isEco = isEco;
	}
	
	public Building(String name, String description, long co2, long treasury, boolean isEco) {
		this.name = name;
		this.description = description;
		this.co2 = co2;
		this.treasury = treasury;
		this.isEco = isEco;
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
	
	public long getCo2() {
		return co2;
	}
	
	public long getTreasury() {
		return treasury;
	}
	
	public boolean isEco() {
		return isEco;
	}
	
	@Override
	public String toString() {
		return "Building{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", co2=" + co2 + ", treasury=" + treasury + ", isEco=" + isEco + "}\n";
	}
	
	@Override
	public ContentValues getInsertQuery(BuildingDatabase db) {
		String[] array = db.getColumnArray();
		ContentValues values = new ContentValues(5);
		// no id pass
		values.put(array[1], getName());
		values.put(array[2], getDescription());
		values.put(array[3], getCo2());
		values.put(array[4], getTreasury());
		values.put(array[5], isEco());
		return values;
	}
}
