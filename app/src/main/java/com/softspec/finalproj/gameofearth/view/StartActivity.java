package com.softspec.finalproj.gameofearth.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import com.softspec.finalproj.gameofearth.R;

/**
 * Created by bubblebitoey on 5/26/2017 AD.
 */

public class StartActivity extends FullScreenActivity{
	
	private ImageButton startBtn;
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		startBtn = (ImageButton) findViewById(R.id.start_button);
		startBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(StartActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
