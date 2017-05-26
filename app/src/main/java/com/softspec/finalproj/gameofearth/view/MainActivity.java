package com.softspec.finalproj.gameofearth.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.softspec.finalproj.gameofearth.R;
import com.softspec.finalproj.gameofearth.api.constants.LightBulb;
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

import static com.softspec.finalproj.gameofearth.view.LoadedProgressActivity.GAME_LOGIC;

public class MainActivity extends FullScreenActivity implements Observer {
	private static GameLogic logic;
	private EndActivity endActivity;
	private ImageView city;
	private TextView currentPopTextView;
	private TextView popTextView;
	private TextView co2TextView;
	private TextView dateTextView;
	
	private ImageButton light1;
	private ImageButton light2;
	private ImageButton light3;
	
	private QuestionDialog questionDialog;
	
	private View.OnClickListener lightClick = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Log.i(LogConstants.Action.CLICK, ((ImageButton) v).getContentDescription().toString());
			logic.setLightClick(LightBulb.find(v.getId()));
			setLightEnabled(false, LightBulb.values());
			showQuestion();
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		city = (ImageView) findViewById(R.id.city);
		
		currentPopTextView = (TextView) findViewById(R.id.current_population_text);
		popTextView = (TextView) findViewById(R.id.population_text);
		co2TextView = (TextView) findViewById(R.id.carbon_text);
		dateTextView = (TextView) findViewById(R.id.calendar_text);
		
		light1 = (ImageButton) findViewById(R.id.light_bulb_1);
		light1.setOnClickListener(lightClick);
		light2 = (ImageButton) findViewById(R.id.light_bulb_2);
		light2.setOnClickListener(lightClick);
		light3 = (ImageButton) findViewById(R.id.light_bulb_3);
		light3.setOnClickListener(lightClick);
		setLightEnabled(false, LightBulb.values());
		
		DatabaseManagement management = (DatabaseManagement) getIntent().getSerializableExtra(LoadedProgressActivity.DATABASE_MANAGEMENT);
		logic = new GameLogic(this, management.reload(this), new DefaultGameStrategy(), new DefaultCityStrategy(), new DefaultCO2Strategy(), new DefaultPopulationStrategy());
		logic.addObserver(this);
		logic.startGame();
		
		questionDialog = QuestionDialog.getInstance(this, this);
	}
	
	@Override
	public void update(Observable observable, Object o) {
		update();
		
		if (observable instanceof ResultDialog && o instanceof Resource) {
			Resource r = (Resource) o;
			logic.update(r);
		}
		
		if (observable instanceof GameLogic) {
			if (logic.isGameOver()) {
				Log.i(LogConstants.Action.UPDATE, "Game Over");
				setCity(logic.getDefaultCity());
				logic.stopGame();
				// FIXME: 5/26/2017 AD no start end activity
				Intent intent = new Intent(MainActivity.this, EndActivity.class);
				intent.putExtra(GAME_LOGIC, logic);
				startActivity(intent);
			} else if (o instanceof String && o.toString().equals(GameLogic.SHOW_QUESTION)) {
				if (!LightBulb.haveQuestionLight(this) && !questionDialog.isShown()) {
					Log.i(LogConstants.Action.LIGHT, "Question");
					setLightEnabled(true, logic.getLightLight());
				} else {
					Log.i(LogConstants.Action.NO_LIGHT, "Already Light");
				}
			} else {
				setCity(logic.getCity());
			}
		}
	}
	
	public void update() {
		setCurrentPopulation();
		setPercentPopulation();
		setCO2();
		setDate();
	}
	
	public void setCity(Drawable city) {
		this.city.setImageDrawable(city);
	}
	
	public void setCurrentPopulation() {
		currentPopTextView.setText(String.valueOf(logic.getCurrentPopulation()));
	}
	
	public void setPercentPopulation() {
		popTextView.setText(String.format(Locale.ENGLISH, "%d%%", logic.getPopulation().getNumber()));
	}
	
	public void setCO2() {
		co2TextView.setText(String.valueOf(logic.getCo2()));
	}
	
	public void setDate() {
		dateTextView.setText(String.format(Locale.ENGLISH, "Day: %d", logic.getDate()));
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
	
	public void setLightEnabled(boolean enabled, LightBulb... lights) {
		// Comment: I can't can findViewById multiple times here, If do that will cause unexpected result
		for (LightBulb l : lights) {
			setImageBtnEnabled(enabled, (ImageButton) findViewById(l.getID()));
		}
	}
	
	public void setImageBtnEnabled(boolean enabled, ImageButton btn) {
		btn.setEnabled(enabled);
		Drawable originalIcon = getResources().getDrawable(R.drawable.light_bulb);
		Drawable icon = enabled ? originalIcon: convertDrawableToGrayScale(originalIcon);
		btn.setImageDrawable(icon);
	}
	
	/**
	 * Mutates and applies a filter that converts the given drawable to a Gray
	 * image. This method may be used to simulate the color of disable icons in
	 * Honeycomb's ActionBar.
	 *
	 * @return a mutated version of the given drawable with a color filter
	 * applied.
	 */
	public Drawable convertDrawableToGrayScale(Drawable drawable) {
		if (drawable == null) {
			return null;
		}
		Drawable res = drawable.mutate();
		res.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
		return res;
	}
}