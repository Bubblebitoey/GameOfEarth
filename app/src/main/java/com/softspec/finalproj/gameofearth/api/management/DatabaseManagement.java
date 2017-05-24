package com.softspec.finalproj.gameofearth.api.management;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.softspec.finalproj.gameofearth.model.database.Database;
import com.softspec.finalproj.gameofearth.model.question.QuestionCreator;
import com.softspec.finalproj.gameofearth.model.question.QuestionDatabase;
import com.softspec.finalproj.gameofearth.model.resource.AcceptCreator;
import com.softspec.finalproj.gameofearth.model.resource.AcceptanceDatabase;
import com.softspec.finalproj.gameofearth.model.resource.DeclinationDatabase;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 12:20 AM
 */
public class DatabaseManagement extends AsyncTask<Context, Void, Boolean> {
	private Database qDB;
	private Database aDB;
	private Database dDB;
	
	public DatabaseManagement(Context c) {
		execute(c);
	}
	
	@Override
	protected Boolean doInBackground(Context... contexts) {
		Context c = contexts[0];
		qDB = new QuestionDatabase(c);
		aDB = new AcceptanceDatabase(c);
		dDB = new DeclinationDatabase(c);
		return true;
	}
	
	@Override
	protected void onPostExecute(Boolean aBoolean) {
		super.onPostExecute(aBoolean);
		if (aBoolean) {
			if (qDB.isExist()) {
				Log.i("REJECT", "creating, database exist");
				return;
			}
			
			QuestionCreator qc = (QuestionCreator) new QuestionCreator().setDatabase(qDB);
			qc.insert();
			
			new AcceptCreator(qc).setDatabase(aDB).insert();
			new AcceptCreator(qc).setDatabase(dDB).insert();
		}
	}
}
