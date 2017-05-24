package com.softspec.finalproj.gameofearth.model.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.softspec.finalproj.gameofearth.api.constants.TableName;

import java.io.File;

public abstract class Database extends SQLiteOpenHelper {
	// Database Version
	private static final int DATABASE_VERSION = 2;
	// Database Name
	private static final String DATABASE_NAME = "DataCollection";
	
	
	private Context context;
	
	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion != newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + getTableName().getName());
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
	
	public boolean isExist() {
		File f = context.getDatabasePath(DATABASE_NAME);
		Log.d("DATABASE PATH", f.getAbsolutePath());
		return f.exists();
	}
}
