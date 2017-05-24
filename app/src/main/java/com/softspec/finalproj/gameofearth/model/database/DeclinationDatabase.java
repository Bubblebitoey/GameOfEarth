package com.softspec.finalproj.gameofearth.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.softspec.finalproj.gameofearth.api.constants.DatabaseColumns;
import com.softspec.finalproj.gameofearth.api.constants.TableName;

/**
 * @author kamontat
 * @version 1.0
 * @since Wed 24/May/2017 - 10:16 PM
 */
public class DeclinationDatabase extends Database {
	private String ID = DatabaseColumns.ID.getDatabaseKey();
	private String D_C = DatabaseColumns.CO2.getDatabaseKey();
	private String D_P = DatabaseColumns.POPULATION.getDatabaseKey();
	
	public DeclinationDatabase(Context context) {
		super(context);
	}
	
	@Override
	public TableName getTableName() {
		return TableName.DECLINATION;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(String.format("CREATE TABLE %s (" +
						                         "%s INTEGER, " +
						                         "%s INTEGER, " +
						                         "%s INTEGER, " +
												 "FOREIGN KEY(%s) REFERENCES %s(%s)",
						getTableName(), ID, D_C, D_P
						, ID, TableName.QUESTION.getName(), DatabaseColumns.ID));
	}
}
