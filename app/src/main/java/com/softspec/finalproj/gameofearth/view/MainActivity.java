package com.softspec.finalproj.gameofearth.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.softspec.finalproj.gameofearth.R;
import com.softspec.finalproj.gameofearth.api.management.DatabaseManagement;
import com.softspec.finalproj.gameofearth.model.game.GameLogic;
import com.softspec.finalproj.gameofearth.model.strategy.DefaultCO2Strategy;
import com.softspec.finalproj.gameofearth.model.strategy.DefaultCityStrategy;
import com.softspec.finalproj.gameofearth.model.strategy.DefaultGameStrategy;

import java.util.*;

public class MainActivity extends Activity implements Observer {
	private static GameLogic logic;
	private static DatabaseManagement management;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		
		management = new DatabaseManagement(this);
		management.addObserver(this);
		management.run();
	}
	
	@Override
	public void update(Observable observable, Object o) {
		if (observable instanceof DatabaseManagement) {
			logic = new GameLogic(this, new DefaultGameStrategy(), new DefaultCityStrategy(), new DefaultCO2Strategy());
			logic.addObserver(this);
			logic.startGame();
		} else if (observable instanceof GameLogic) {
			// TODO: 5/25/2017 AD update game information
		}
	}
}