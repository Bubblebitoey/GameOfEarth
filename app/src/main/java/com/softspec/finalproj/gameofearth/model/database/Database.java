package com.softspec.finalproj.gameofearth.model.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.softspec.finalproj.gameofearth.api.constants.DatabaseColumns;
import com.softspec.finalproj.gameofearth.api.constants.TableName;

import java.io.File;

public class Database extends SQLiteOpenHelper {
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
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		sqLiteDatabase.execSQL(DatabaseQuery.CREATE_QUESTION_TABLE);
		sqLiteDatabase.execSQL(DatabaseQuery.CREATE_ACCEPTANCE_TABLE);
		sqLiteDatabase.execSQL(DatabaseQuery.CREATE_DECLINATION_TABLE);
	}
	
	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
		if (!db.isReadOnly()) {
			db.setForeignKeyConstraintsEnabled(true);
		}
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion != newVersion) {
			for (TableName t : TableName.values()) {
				db.execSQL("DROP TABLE IF EXISTS " + t.getName());
			}
			onCreate(db);
		}
	}
	
	public long add(TableName tableName, DatabaseSavable data) {
		return getWritableDatabase().insert(tableName.getName(), null, data.getInsertQuery());
	}
	
	public Long getID(TableName tableName, String cause, String[] causeArgs) {
		Cursor cursor = getReadableDatabase().query(tableName.getName(), new String[]{"id"}, cause, causeArgs, null, null, null);
		long resultID = cursor.getLong(0);
		cursor.close();
		return resultID;
	}
	
	public Cursor getData(TableName tableName, long id) {
		return getReadableDatabase().query(tableName.getName(), null, DatabaseColumns.ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
	}
	
	public boolean isExist() {
		File f = context.getDatabasePath(DATABASE_NAME);
		Log.d("DATABASE PATH", f.getAbsolutePath());
		Log.d("DATABASE", f.exists() ? "exist": "not exist");
		return f.exists();
	}
}
