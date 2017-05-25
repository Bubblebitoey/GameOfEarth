package com.softspec.finalproj.gameofearth.view;

import android.content.Intent;
import android.os.Bundle;
import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;
import com.softspec.finalproj.gameofearth.R;
import com.softspec.finalproj.gameofearth.api.datastructure.Progress;
import com.softspec.finalproj.gameofearth.api.management.DatabaseManagement;

import java.util.*;

public class LoadedProgressActivity extends FullScreenActivity implements Observer {
	public static final String DATABASE_MANAGEMENT = "database_management";
	private AnimatedCircleLoadingView progressBar;
	private DatabaseManagement management;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loading);
		
		progressBar = (AnimatedCircleLoadingView) findViewById(R.id.circle_progress_bar);
		progressBar.startIndeterminate();
		progressBar.setAnimationListener(new AnimatedCircleLoadingView.AnimationListener() {
			@Override
			public void onAnimationEnd(boolean b) {
				Intent intent = new Intent(LoadedProgressActivity.this, MainActivity.class);
				intent.putExtra(DATABASE_MANAGEMENT, management);
				startActivity(intent);
			}
		});
		
		management = new DatabaseManagement(this);
		management.addObserver(this);
		management.run();
	}
	
	@Override
	public void update(Observable observable, Object o) {
		if (observable instanceof DatabaseManagement && o instanceof Progress) {
			Progress progress = (Progress) o;
			if (progress.isComplete()) {
				progressBar.stopOk();
			}
		}
		progressBar.stopOk();
	}
}
