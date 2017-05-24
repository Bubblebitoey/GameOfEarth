package com.bubblebitoey.gameofearth.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bubblebitoey.gameofearth.api.constants.DatabaseColumns;
import com.bubblebitoey.gameofearth.api.constants.TableName;

/**
 * @author kamontat
 * @version 1.0
 * @since Wed 24/May/2017 - 10:14 PM
 */
public class AcceptanceDatabase extends Database {
	private String ID = DatabaseColumns.ID.getDatabaseKey();
	private String A_C = DatabaseColumns.A_CO2.getDatabaseKey();
	private String A_P = DatabaseColumns.A_POPULATION.getDatabaseKey();
	
	public AcceptanceDatabase(Context context) {
		super(context);
	}
	
	@Override
	public TableName getTableName() {
		return TableName.ACCEPTANCE;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(String.format("CREATE TABLE %s (" +
								                         "%s INTEGER, " +
								                         "%s INTEGER, " +
								                         "%s INTEGER, " +
														 "FOREIGN KEY(%s) REFERENCES %s(%s)",
								getTableName(), ID, A_C, A_P
								, ID, TableName.QUESTION.getName(), DatabaseColumns.ID));
	}
}
