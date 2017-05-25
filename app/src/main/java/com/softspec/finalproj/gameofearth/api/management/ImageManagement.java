package com.softspec.finalproj.gameofearth.api.management;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 4:46 PM
 */
public class ImageManagement {
	private Context context;
	private CityLoader loader;
	
	public ImageManagement(Context context) {
		this.context = context;
		loader = new CityLoader(context);
	}
	
	public Drawable getCity() {
		// return CityLoader.toggleCity(loader, );
		return null;
	}
}
