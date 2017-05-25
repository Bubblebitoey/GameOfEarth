package com.softspec.finalproj.gameofearth.api.management;

import android.content.Context;
import android.os.AsyncTask;
import com.softspec.finalproj.gameofearth.model.database.Database;
import com.softspec.finalproj.gameofearth.model.question.Question;
import com.softspec.finalproj.gameofearth.model.question.QuestionCreator;
import com.softspec.finalproj.gameofearth.model.resource.AcceptCreator;
import com.softspec.finalproj.gameofearth.model.resource.DenyCreator;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 12:20 AM
 */
public class DatabaseManagement extends Observable implements Runnable {
	private Database database;
	
	public DatabaseManagement() {
	
	}
	public DatabaseManagement(Context c) {
		database = new Database(c);
	}
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers();
	}
	Database getDatabase() {
		return database;
	}
	
	public Question randomQuestion() {
		return database.randomQuestion();
	}
	
	@Override
	public void run() {
		if (!database.isExist()) new DatabaseInsertionTask(this).execute();
		else {
			setChanged();
			notifyObservers();
		}
	}
	
	public static class DatabaseInsertionTask extends AsyncTask<Void, Void, Boolean> {
		private DatabaseManagement management;
		
		DatabaseInsertionTask(DatabaseManagement management) {
			this.management = management;
		}
		
		@Override
		protected void onPreExecute() {
			if (management.getDatabase().isExist()) {
				cancel(true);
			} else {
				super.onPreExecute();
			}
		}
		
		@Override
		protected Boolean doInBackground(Void... voids) {
			new QuestionCreator().setDatabase(management.getDatabase()).insert();
			new AcceptCreator().setDatabase(management.getDatabase()).insert();
			new DenyCreator().setDatabase(management.getDatabase()).insert();
			return true;
		}
		
		@Override
		protected void onPostExecute(Boolean aBoolean) {
			super.onPostExecute(aBoolean);
			management.setChanged();
			management.notifyObservers();
		}
	}
}
