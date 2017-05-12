package com.bubblebitoey.gameofearth.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class ResourceDatabase extends Database {
	private static final String ID = "id";
	
	private static final String RESOURCE_CARBON = "resource_carbon_id";
	private static final String RESOURCE_MONEY = "resource_money_id";
	private static final String RESOURCE_POPULATION = "resource_population_id";
	
	public ResourceDatabase(Context context) {
		super(context);
	}
	
	@Override
	public String getTableName() {
		return "Resource";
	}
	
	@Override
	public String[] getColumnArray() {
		return new String[]{ID, RESOURCE_CARBON, RESOURCE_MONEY, RESOURCE_POPULATION};
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
										 "%s INTEGER, " +
				                         "%s INTEGER, " +
				                         "%s INTEGER, " +
				                         "FOREIGN KEY(%s) REFERENCES %s(%s)" +
				                         "FOREIGN KEY(%s) REFERENCES %s(%s)" +
				                         "FOREIGN KEY(%s) REFERENCES %s(%s))",
										getTableName(), ID, RESOURCE_CARBON, RESOURCE_MONEY, RESOURCE_POPULATION,
										RESOURCE_CARBON, "Carbon", "id",
										RESOURCE_MONEY, "Money", "id",
										RESOURCE_POPULATION, "Population", "id"
		));
	}
}
