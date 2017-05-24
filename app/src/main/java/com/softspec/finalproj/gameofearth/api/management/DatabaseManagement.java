package com.softspec.finalproj.gameofearth.api.management;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.softspec.finalproj.gameofearth.model.database.Database;
import com.softspec.finalproj.gameofearth.model.question.QuestionCreator;
import com.softspec.finalproj.gameofearth.model.resource.AcceptCreator;
import com.softspec.finalproj.gameofearth.model.resource.DenyCreator;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 12:20 AM
 */
public class DatabaseManagement extends AsyncTask<Context, Void, Boolean> {
	private Database database;
	
	public DatabaseManagement(Context c) {
		execute(c);
	}
	
	@Override
	protected Boolean doInBackground(Context... contexts) {
		Context c = contexts[0];
		database = new Database(c);
		return true;
	}
	
	@Override
	protected void onPostExecute(Boolean aBoolean) {
		super.onPostExecute(aBoolean);
		if (aBoolean) {
			if (database.isExist()) {
				Log.i("REJECT", "creating, database exist");
				return;
			}
			
			new QuestionCreator().setDatabase(database).insert();
			new AcceptCreator().setDatabase(database).insert();
			new DenyCreator().setDatabase(database).insert();
		}
	}
}
