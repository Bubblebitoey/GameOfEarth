package com.bubblebitoey.gameofearth.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bubblebitoey.gameofearth.api.constants.DatabaseColumns;
import com.bubblebitoey.gameofearth.api.constants.TableName;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class QuestionDatabase extends Database {
	private static final String ID = DatabaseColumns.ID.getDatabaseKey();
	private static final String NAME = DatabaseColumns.Q_TITLE.getDatabaseKey();
	private static final String DESCRIPTION = DatabaseColumns.Q_DESCRIPTION.getDatabaseKey();
	
	public QuestionDatabase(Context context) {
		super(context);
	}
	
	@Override
	public TableName getTableName() {
		return TableName.QUESTION;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(String.format("CREATE TABLE %s (" +
				                         "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
				                         "%s TEXT, " +
				                         "%s TEXT, ",
				getTableName(), ID, NAME, DESCRIPTION));
	}
}
