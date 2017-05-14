package com.bubblebitoey.gameofearth.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bubblebitoey.gameofearth.model.Question;
import com.bubblebitoey.gameofearth.model.creator.Creator;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class QuestionDatabase extends Database<Question> {
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String DESCRIPTION = "description";
	private static final String RESOURCE_ACCEPT = "resource_accept_id";
	private static final String RESOURCE_REJECT = "resource_reject_id";
	
	public QuestionDatabase(Context context, Creator<Question> creator) {
		super(context, creator);
	}
	
	@Override
	public String getTableName() {
		return null;
	}
	
	@Override
	public String[] getColumnArray() {
		return new String[]{ID, NAME, DESCRIPTION, RESOURCE_ACCEPT, RESOURCE_REJECT};
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(String.format("CREATE TABLE %s (" +
				                         "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
				                         "%s TEXT, " +
				                         "%s TEXT, " +
				                         "%s INTEGER, " +
				                         "%s INTEGER, " +
				                         "FOREIGN KEY(%s) REFERENCES %s(%s)" +
				                         "FOREIGN KEY(%s) REFERENCES %s(%s))",
				                         getTableName(),
										 ID, NAME, DESCRIPTION,
										 RESOURCE_ACCEPT, RESOURCE_REJECT,
										 RESOURCE_ACCEPT, "resource", "id",
										 RESOURCE_REJECT, "resource", "id"
		));
	}
}
