package com.softspec.finalproj.gameofearth.model.resource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.softspec.finalproj.gameofearth.api.constants.DatabaseColumns;
import com.softspec.finalproj.gameofearth.api.constants.TableName;
import com.softspec.finalproj.gameofearth.model.database.Database;

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
		Log.d("CREATE", "DENY DATABASE");
		db.execSQL(String.format("CREATE TABLE %s (" + "%s INTEGER, " + "%s INTEGER, " + "%s INTEGER, " + "FOREIGN KEY(%s) REFERENCES %s(%s))", getTableName(), ID, D_C, D_P, ID, TableName.QUESTION.getName(), DatabaseColumns.ID));
	}
}
