package com.softspec.finalproj.gameofearth.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.softspec.finalproj.gameofearth.R;

/**
 * Created by bubblebitoey on 5/26/2017 AD.
 */
public class EndActivity extends FullScreenActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end);
		
		// ImageButton playAgainBtn = (ImageButton) findViewById(R.id.playAgain_button);
		TextView scoreTxt = (TextView) findViewById(R.id.txtScore);
		scoreTxt.setText(String.valueOf(MainActivity.logic.getHighestPopulation()));
		
		// playAgainBtn.setOnClickListener(new View.OnClickListener() {
		//	@Override
		//	public void onClick(View v) {
		//		Intent intent = new Intent(EndActivity.this, StartActivity.class);
		//		startActivity(intent);
		// 	}
		// });
	}
}
