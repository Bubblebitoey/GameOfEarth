package com.softspec.finalproj.gameofearth.api.management;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import com.softspec.finalproj.gameofearth.R;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 7:37 PM
 */
public class LightBulb {
	private static Drawable light;
	private Context context;
	
	private Leader leader;
	
	public LightBulb(Context context, Leader leader) {
		this.context = context;
		light = ContextCompat.getDrawable(context, R.drawable.light_bulb);
		this.leader = leader;
	}
	
	public int[] getImageViewIDNeedToLight() {
		return leader.next();
	}
	
	public Drawable getLight() {
		return light;
	}
}
