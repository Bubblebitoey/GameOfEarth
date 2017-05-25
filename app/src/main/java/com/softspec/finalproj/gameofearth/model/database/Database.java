package com.softspec.finalproj.gameofearth.model.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.softspec.finalproj.gameofearth.api.constants.DatabaseColumns;
import com.softspec.finalproj.gameofearth.api.constants.LogConstants;
import com.softspec.finalproj.gameofearth.api.constants.TableName;
import com.softspec.finalproj.gameofearth.model.question.Question;
import com.softspec.finalproj.gameofearth.model.resource.NullResource;
import com.softspec.finalproj.gameofearth.model.resource.Resource;

import java.io.File;
import java.io.Serializable;

public class Database extends SQLiteOpenHelper implements Serializable {
	public static long serialVersionUID = 1L;
	private static Database database;
	
	// Database Version
	private static final int DATABASE_VERSION = 4;
	// Database Name
	private static final String DATABASE_NAME = "DataCollection";
	
	public static Database getInstance() {
		if (database == null) throw new RuntimeException("Don't have context for database");
		return database;
	}
	
	public static Database getInstance(Context context) {
		if (database == null) database = new Database(context.getApplicationContext());
		return database;
	}
	
	private Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
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
		Log.i(LogConstants.Action.OPEN, LogConstants.Object.DATABASE);
		if (!db.isReadOnly()) {
			db.setForeignKeyConstraintsEnabled(true);
		}
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion != newVersion) {
			Log.i(LogConstants.Action.UPDATE, LogConstants.Object.DATABASE);
			for (TableName t : TableName.values()) {
				db.execSQL("DROP TABLE IF EXISTS " + t.getName());
			}
			onCreate(db);
		}
		Log.i(LogConstants.Action.NO_UPDATE, LogConstants.Object.DATABASE);
	}
	
	public void checkNeedToUpdate() {
		onUpgrade(getWritableDatabase(), getWritableDatabase().getVersion(), Database.DATABASE_VERSION);
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
	
	public synchronized Question randomQuestion() {
		Cursor cursor = getReadableDatabase().rawQuery(DatabaseQuery.RANDOM_QUESTION, null);
		int numRow = cursor.getCount();
		String[] columnNames = cursor.getColumnNames();
		
		if (numRow < 1) {
			throw new RuntimeException("No question available");
		}
		if (cursor.moveToFirst()) {
			long id = cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseColumns.ID.key()));
			String title = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseColumns.Q_TITLE.key()));
			String description = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseColumns.Q_DESCRIPTION.key()));
			
			cursor.close();
			return new Question.Builder(id).setName(title).setDescription(description).setAccept(getResource(TableName.ACCEPTANCE, id)).setDeny(getResource(TableName.DECLINATION, id)).build();
		}
		
		cursor.close();
		return null;
	}
	
	public synchronized Resource getResource(TableName name, long id) {
		Cursor cursor = getReadableDatabase().query(name.getName(), null, DatabaseColumns.ID.key() + "=?", new String[]{String.valueOf(id)}, null, null, null, "1");
		
		if (cursor.moveToFirst()) {
			long co2 = cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseColumns.CO2.key()));
			long pop = cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseColumns.POPULATION.key()));
			
			cursor.close();
			return new Resource.Builder(id).setCo2(co2).setPop(pop).build();
		}
		cursor.close();
		return new NullResource(id);
	}
	
	public Cursor getData(TableName tableName, long id) {
		return getReadableDatabase().query(tableName.getName(), null, DatabaseColumns.ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
	}
	
	public boolean isExist(Context context) {
		File f = context.getDatabasePath(DATABASE_NAME);
		Log.d(LogConstants.Object.DATABASE, f.exists() ? "exist": "not exist");
		return f.exists();
	}
}
