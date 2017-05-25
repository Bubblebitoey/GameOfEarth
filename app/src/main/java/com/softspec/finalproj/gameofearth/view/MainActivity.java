package com.softspec.finalproj.gameofearth.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import com.softspec.finalproj.gameofearth.R;
import com.softspec.finalproj.gameofearth.api.constants.LogConstants;
import com.softspec.finalproj.gameofearth.api.management.DatabaseManagement;
import com.softspec.finalproj.gameofearth.api.uidialog.QuestionDialog;
import com.softspec.finalproj.gameofearth.api.uidialog.ResultDialog;
import com.softspec.finalproj.gameofearth.model.game.GameLogic;
import com.softspec.finalproj.gameofearth.model.resource.Resource;
import com.softspec.finalproj.gameofearth.model.strategy.DefaultCO2Strategy;
import com.softspec.finalproj.gameofearth.model.strategy.DefaultCityStrategy;
import com.softspec.finalproj.gameofearth.model.strategy.DefaultGameStrategy;
import com.softspec.finalproj.gameofearth.model.strategy.DefaultPopulationStrategy;

import java.util.*;

public class MainActivity extends FullScreenActivity implements Observer {
	private static GameLogic logic;
	private ImageView city;
	
	private QuestionDialog questionDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		city = (ImageView) findViewById(R.id.City);
		
		DatabaseManagement management = (DatabaseManagement) getIntent().getSerializableExtra(LoadedProgressActivity.DATABASE_MANAGEMENT);
		logic = new GameLogic(this, management.reload(this), new DefaultGameStrategy(), new DefaultCityStrategy(), new DefaultCO2Strategy(), new DefaultPopulationStrategy());
		logic.addObserver(this);
		logic.startGame();
		
		questionDialog = QuestionDialog.getInstance(this, this);
	}
	
	@Override
	public void update(Observable observable, Object o) {
		if (observable instanceof GameLogic) {
			if (logic.isGameOver()) {
				Log.i(LogConstants.Action.NO_UPDATE, "Game Over");
				setCity(logic.getDefaultCity());
				logic.stopGame();
			} else if (o instanceof String && o.toString().equals(GameLogic.SHOW_QUESTION)) {
				showQuestion();
			} else {
				Log.i(LogConstants.Action.UPDATE, "City Image");
				setCity(logic.getCity());
			}
		}
		
		if (observable instanceof ResultDialog && o instanceof Resource) {
			Resource r = (Resource) o;
			logic.update(r);
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
	
	public void showQuestion() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (!questionDialog.isShown()) {
					Log.i(LogConstants.Action.NO_SHOW, LogConstants.Object.QUESTION_DIALOG);
					questionDialog = QuestionDialog.getInstance(MainActivity.this, MainActivity.this).setQuestion(logic.randomQuestion());
					questionDialog.show();
				} else {
					Log.i(LogConstants.Action.SHOW, LogConstants.Object.QUESTION_DIALOG);
				}
			}
		});
	}
}