package com.bubblebitoey.gameofearth.model.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bubblebitoey.gameofearth.api.constants.TableName;
import com.bubblebitoey.gameofearth.model.DatabaseSavable;

public abstract class Database extends SQLiteOpenHelper {
	// Database Version
	private static final int DATABASE_VERSION = 3;
	// Database Name
	private static final String DATABASE_NAME = "DataCollection";
	
	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion != newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + getTableName());
			onCreate(db);
		}
	}
	
	public long add(DatabaseSavable data) {
		return getWritableDatabase().insert(getTableName().getName(), null, data.getInsertQuery());
	}
	
	public Long getID(String cause, String[] causeArgs) {
		Cursor cursor = getReadableDatabase().query(getTableName().getName(), new String[]{"id"}, cause, causeArgs, null, null, null);
		long resultID = cursor.getLong(0);
		cursor.close();
		return resultID;
	}
	
	public Cursor getData(long id) {
		return getReadableDatabase().query(getTableName().getName(), null, "id=?", new String[]{String.valueOf(id)}, null, null, null);
	}
	
	public abstract TableName getTableName();
}
