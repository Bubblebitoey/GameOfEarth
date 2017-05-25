package com.softspec.finalproj.gameofearth.api.management;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.softspec.finalproj.gameofearth.model.database.Database;
import com.softspec.finalproj.gameofearth.model.question.Question;
import com.softspec.finalproj.gameofearth.model.question.QuestionCreator;
import com.softspec.finalproj.gameofearth.model.resource.AcceptCreator;
import com.softspec.finalproj.gameofearth.model.resource.DenyCreator;

import java.io.Serializable;
import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 12:20 AM
 */
public class DatabaseManagement extends Observable implements Runnable, Serializable {
	public static long serialVersionUID = 1L;
	private transient Database database;
	private transient Context context;
	
	public DatabaseManagement(Context c) {
		reload(c);
		// database.checkNeedToUpdate();
	}
	
	public DatabaseManagement reload(Context context) {
		if (this.context == null) this.context = context;
		if (this.database == null) database = Database.getInstance(context);
		return this;
	}
	
	Database getDatabase() {
		return database;
	}
	
	public Question randomQuestion() {
		return database.randomQuestion();
	}
	
	@Override
	public void run() {
		if (!database.isExist(context)) new DatabaseInsertionTask(this).execute();
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
			if (management.getDatabase().isExist(management.context)) {
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
