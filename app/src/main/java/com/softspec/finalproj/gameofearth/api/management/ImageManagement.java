package com.softspec.finalproj.gameofearth.api.management;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import com.softspec.finalproj.gameofearth.R;
import com.softspec.finalproj.gameofearth.model.game.GameLogic;

import java.io.Serializable;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 4:46 PM
 */
public class ImageManagement implements Serializable {
	public static long serialVersionUID = 1L;
	
	private Context context;
	private GameLogic logic;
	private CityLoader loader;
	
	public ImageManagement(Context context, GameLogic logic) {
		this.context = context;
		this.logic = logic;
		loader = new CityLoader(context, logic);
	}
	
	public Drawable getCity() {
		return CityLoader.toggleCity(loader, logic.getCityStrategy());
	}
	
	public Drawable getDefaultCity() {
		return loader.getCityLevel_0();
	}
	
	public Drawable getLightBulb() {
		return ContextCompat.getDrawable(context, R.drawable.light_bulb);
	}
}
