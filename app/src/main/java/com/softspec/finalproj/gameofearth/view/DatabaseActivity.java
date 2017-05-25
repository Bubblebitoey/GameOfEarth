package com.softspec.finalproj.gameofearth.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import com.softspec.finalproj.gameofearth.Presenter.DatabasePresenter;
import com.softspec.finalproj.gameofearth.R;
import com.softspec.finalproj.gameofearth.model.database.Database;

/**
 * Created by bubblebitoey on 5/25/2017 AD.
 */

public class DatabaseActivity extends AppCompatActivity implements DatabaseView{
	ProgressBar progressBar;
	Database database;
	DatabasePresenter databasePresenter;
	Context c;
	
	public DatabaseActivity(DatabasePresenter databasePresenter) {
	}
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_database);
		
		progressBar = (ProgressBar) findViewById(R.id.progress_bar);
	}
	
	@Override
	public void notifyOnChange() {
	
	}
	
	@Override
	public void setMaxProgress(int max) {
	progressBar.setMax(max);
	}
	
	@Override
	public void updateProgress(int current) {
	progressBar.setProgress(current);
	}
	
	@Override
	public void createProgress() {
	progressBar.setVisibility(View.VISIBLE);
	}
	
	@Override
	public void removeProgress() {
	progressBar.setVisibility(View.INVISIBLE);
	}
}
