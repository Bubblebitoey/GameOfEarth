package com.bubblebitoey.gameofearth.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class QuestionDatabase extends Database {
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String DESCRIPTION = "description";
	private static final String RESOURCE_CARBON = "resource_carbon_id";
	private static final String RESOURCE_MONEY = "resource_money_id";
	private static final String RESOURCE_POPULATION = "resource_population_id";
	
	public QuestionDatabase(Context context) {
		super(context);
	}
	
	@Override
	public String getTableName() {
		return null;
	}
	
	@Override
	public String[] getColumnArray() {
		return new String[]{ID, NAME, DESCRIPTION, RESOURCE_CARBON, RESOURCE_MONEY, RESOURCE_POPULATION};
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(String.format("CREATE TABLE %s (" +
				                         "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
				                         "%s TEXT, " +
				                         "%s TEXT, " +
				                         "%s INTEGER, " +
				                         "%s INTEGER, " +
				                         "%s INTEGER, " +
				                         "FOREIGN KEY(%s) REFERENCES %s(%s)" +
				                         "FOREIGN KEY(%s) REFERENCES %s(%s)" +
				                         "FOREIGN KEY(%s) REFERENCES %s(%s))",
				                         getTableName(),
										 ID, NAME, DESCRIPTION,
										 RESOURCE_CARBON, RESOURCE_MONEY, RESOURCE_POPULATION,
										 RESOURCE_CARBON, "Carbon", "id",
										 RESOURCE_MONEY, "Money", "id",
										 RESOURCE_POPULATION, "Population", "id"
		));
	}
}
