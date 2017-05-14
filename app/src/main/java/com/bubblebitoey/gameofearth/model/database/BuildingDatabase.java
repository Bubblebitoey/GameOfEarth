package com.bubblebitoey.gameofearth.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bubblebitoey.gameofearth.model.Building;
import com.bubblebitoey.gameofearth.model.creator.Creator;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class BuildingDatabase extends Database<Building> {
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String DESCRIPTION = "description";
	private static final String CO2 = "co2";
	private static final String TREASURY = "treasury";
	private static final String ECO = "eco";
	
	public BuildingDatabase(Context context, Creator<Building> creator) {
		super(context, creator);
	}
	
	@Override
	public String getTableName() {
		return "Building";
	}
	
	@Override
	public String[] getColumnArray() {
		return new String[]{ID, NAME, DESCRIPTION, CO2, TREASURY, ECO};
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// db.execSQL("DROP TABLE IF EXISTS " + getTableName());
		db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " + "%s TEXT, " + "%s INTEGER, " + "%s INTEGER, " + "%s TEXT, " + "%s INTEGER)", getTableName(), ID, NAME, CO2, TREASURY, DESCRIPTION, ECO));
	}
}
