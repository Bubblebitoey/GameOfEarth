package com.softspec.finalproj.gameofearth.view;

import android.os.Bundle;
import com.softspec.finalproj.gameofearth.R;
import com.softspec.finalproj.gameofearth.model.game.GameLogic;
import com.softspec.finalproj.gameofearth.model.strategy.DefaultCO2Strategy;
import com.softspec.finalproj.gameofearth.model.strategy.DefaultCityStrategy;
import com.softspec.finalproj.gameofearth.model.strategy.DefaultGameStrategy;

import java.util.*;

public class MainActivity extends FullScreenActivity implements Observer {
	private static GameLogic logic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		logic = new GameLogic(this, new DefaultGameStrategy(), new DefaultCityStrategy(), new DefaultCO2Strategy());
		logic.addObserver(this);
		logic.startGame();
	}
	
	@Override
	public void update(Observable observable, Object o) {
		if (observable instanceof GameLogic) {
			logic.getCity();
			// TODO: 5/25/2017 AD do something
		}
	}
}