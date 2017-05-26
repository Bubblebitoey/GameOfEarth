package com.softspec.finalproj.gameofearth.api.constants;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.view.View;
import com.softspec.finalproj.gameofearth.R;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 26/May/2017 - 3:11 PM
 */
public enum LightBulb {
	BULB_1(R.id.light_bulb_1),
	BULB_2(R.id.light_bulb_2),
	BULB_3(R.id.light_bulb_3);
	
	@IdRes
	private int id;
	
	LightBulb(int id) {
		this.id = id;
	}
	
	public void show(Activity activity) {
		activity.findViewById(id).setVisibility(View.VISIBLE);
	}
	
	public void hide(Activity activity) {
		activity.findViewById(id).setVisibility(View.INVISIBLE);
	}
	
	public boolean isShow(Activity activity) {
		return activity.findViewById(id).getVisibility() == View.VISIBLE;
	}
	
	public static boolean haveQuestionLight(Activity activity) {
		for (LightBulb l : values()) {
			if (l.isShow(activity)) return true;
		}
		return false;
	}
}
