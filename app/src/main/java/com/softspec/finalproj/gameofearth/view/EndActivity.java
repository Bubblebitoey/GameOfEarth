package com.softspec.finalproj.gameofearth.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.softspec.finalproj.gameofearth.R;
import com.softspec.finalproj.gameofearth.model.game.GameLogic;

import java.util.*;

/**
 * Created by bubblebitoey on 5/26/2017 AD.
 */

public class EndActivity extends FullScreenActivity implements Observer{
	
	private GameLogic gameLogic;
	private ImageButton playAgainBtn;
	private TextView scoreTxt;
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end);
		
		playAgainBtn = (ImageButton) findViewById(R.id.playAgain_button);
		scoreTxt = (TextView) findViewById(R.id.txtScore);
		
		playAgainBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(EndActivity.this, StartActivity.class);
				startActivity(intent);
			}
		});
		
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
	
	}
}
