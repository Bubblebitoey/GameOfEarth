package com.softspec.finalproj.gameofearth.model.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.softspec.finalproj.gameofearth.api.constants.DatabaseColumns;
import com.softspec.finalproj.gameofearth.api.constants.TableName;
import com.softspec.finalproj.gameofearth.model.question.Question;
import com.softspec.finalproj.gameofearth.model.resource.NullResource;
import com.softspec.finalproj.gameofearth.model.resource.Resource;

import java.io.File;

public class Database extends SQLiteOpenHelper {
	// Database Version
	private static final int DATABASE_VERSION = 4;
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
		Log.i("OPEN", "database");
		if (!db.isReadOnly()) {
			db.setForeignKeyConstraintsEnabled(true);
		}
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion != newVersion) {
			Log.i("UPDATE", "DATABASE");
			for (TableName t : TableName.values()) {
				db.execSQL("DROP TABLE IF EXISTS " + t.getName());
			}
			onCreate(db);
		}
		Log.i("NO UPDATE", "DATABASE");
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
			return new Question.Builder(id)
								       .setName(title)
								       .setDescription(description)
								       .setAccept(getResource(TableName.ACCEPTANCE, id))
								       .setDeny(getResource(TableName.DECLINATION, id))
								       .build();
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
	
	public boolean isExist() {
		
		File f = context.getDatabasePath(DATABASE_NAME);
		Log.d("DATABASE", f.exists() ? "exist": "not exist");
		return f.exists();
	}
}
