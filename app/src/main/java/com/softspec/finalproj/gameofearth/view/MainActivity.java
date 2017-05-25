package com.softspec.finalproj.gameofearth.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import com.softspec.finalproj.gameofearth.R;
import com.softspec.finalproj.gameofearth.model.game.GameLogic;
import com.softspec.finalproj.gameofearth.model.strategy.DefaultCO2Strategy;
import com.softspec.finalproj.gameofearth.model.strategy.DefaultCityStrategy;
import com.softspec.finalproj.gameofearth.model.strategy.DefaultGameStrategy;

import java.util.*;

public class MainActivity extends FullScreenActivity implements Observer {
	private static GameLogic logic;
	private ImageView city;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		city = (ImageView) findViewById(R.id.City);
		
		logic = new GameLogic(this, new DefaultGameStrategy(), new DefaultCityStrategy(), new DefaultCO2Strategy());
		logic.addObserver(this);
		logic.startGame();
	}
	
	@Override
	public void update(Observable observable, Object o) {
		if (observable instanceof GameLogic) {
			if (logic.isGameOver()) {
				setCity(logic.getDefaultCity());
				logic.stopGame();
			} else {
				setCity(logic.getCity());
			}
		}
	}
	
	public void setCity(Drawable city) {
		this.city.setImageDrawable(city);
	}
	
	public void setCurrentPopulation() {
	
	}
	
	public void setPercentPopulation() {
	
	}
	
	public void setCO2() {
	
	}
}