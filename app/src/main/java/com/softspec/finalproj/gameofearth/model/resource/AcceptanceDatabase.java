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
 * @since Wed 24/May/2017 - 10:14 PM
 */
public class AcceptanceDatabase extends Database {
	private String ID = DatabaseColumns.ID.getDatabaseKey();
	private String A_C = DatabaseColumns.CO2.getDatabaseKey();
	private String A_P = DatabaseColumns.POPULATION.getDatabaseKey();
	
	public AcceptanceDatabase(Context context) {
		super(context);
	}
	
	@Override
	public TableName getTableName() {
		return TableName.ACCEPTANCE;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("CREATE", "ACCEPT DATABASE");
		db.execSQL(String.format("CREATE TABLE %s (" +
								                         "%s INTEGER, " +
								                         "%s INTEGER, " +
								                         "%s INTEGER, " +
														 "FOREIGN KEY(%s) REFERENCES %s(%s))",
								getTableName(), ID, A_C, A_P
								, ID, TableName.QUESTION.getName(), DatabaseColumns.ID));
	}
}
