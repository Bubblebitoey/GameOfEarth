package com.bubblebitoey.gameofearth.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bubblebitoey.gameofearth.model.DatabaseSavable;
import com.bubblebitoey.gameofearth.model.creator.Creator;

public abstract class Database<T extends DatabaseSavable> extends SQLiteOpenHelper {
	// Database Version
	private static final int DATABASE_VERSION = 3;
	// Database Name
	private static final String DATABASE_NAME = "DataCollection";
	
	public Database(Context context, Creator<T> creator) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		creator.insert(this);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion != newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + getTableName());
			onCreate(db);
		}
	}
	
	public long add(T data) {
		return getReadableDatabase().insert(getTableName(), null, data.getInsertQuery(this));
	}
	
	public abstract String getTableName();
	
	public abstract String[] getColumnArray();
}
