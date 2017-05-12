package com.bubblebitoey.gameofearth.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class ResourceMoneyDatabase extends Database {
	private static final String ID = "id";
	private static final String VALUE = "value";
	
	public ResourceMoneyDatabase(Context context) {
		super(context);
	}
	
	@Override
	public String getTableName() {
		return "Money";
	}
	
	@Override
	public String[] getColumnArray() {
		return new String[]{ID, VALUE};
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " + "%s INTEGER)", getTableName(), ID, VALUE));
	}
}
