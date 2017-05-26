package com.softspec.finalproj.gameofearth.api.management;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import com.softspec.finalproj.gameofearth.R;
import com.softspec.finalproj.gameofearth.model.game.GameLogic;
import com.softspec.finalproj.gameofearth.model.strategy.CityStrategy;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 4:46 PM
 */
public class CityLoader {
	private GameLogic logic;
	private Context context;
	
	public CityLoader(Context context, GameLogic logic) {
		this.logic = logic;
		this.context = context;
	}
	
	public static Drawable toggleCity(CityLoader loader, CityStrategy g) {
		switch (g.getCurrentLevel(loader.logic)) {
			case LEVEL_0:
				return loader.getCityLevel_0();
			case LEVEL_1:
				return loader.getCityLevel_1();
			case LEVEL_2:
				return loader.getCityLevel_2();
			case LEVEL_3:
				return loader.getCityLevel_3();
			case LEVEL_4:
				return loader.getCityLevel_4();
			case LEVEL_5:
				return loader.getCityLevel_5();
			case LEVEL_6:
				return loader.getCityLevel_6();
			case LEVEL_7:
				return loader.getCityLevel_7();
			case LEVEL_8:
				return loader.getCityLevel_8();
			case LEVEL_9:
				return loader.getCityLevel_9();
			default:
				return loader.getCityLevel_0();
		}
	}
	
	Drawable getCityLevel_0() {
		return getDrawable(R.drawable.city);
	}
	
	private Drawable getCityLevel_1() {
		return getDrawable(R.drawable.city_1);
	}
	
	private Drawable getCityLevel_2() {
		return getDrawable(R.drawable.city_2);
	}
	
	private Drawable getCityLevel_3() {
		return getDrawable(R.drawable.city_3);
	}
	
	private Drawable getCityLevel_4() {
		return getDrawable(R.drawable.city_4);
	}
	
	private Drawable getCityLevel_5() {
		return getDrawable(R.drawable.city_5);
	}
	
	private Drawable getCityLevel_6() {
		return getDrawable(R.drawable.city_6);
	}
	
	private Drawable getCityLevel_7() {
		return getDrawable(R.drawable.city_7);
	}
	
	private Drawable getCityLevel_8() {
		return getDrawable(R.drawable.city_8);
	}
	
	private Drawable getCityLevel_9() {
		return getDrawable(R.drawable.city_9);
	}
	
	private Drawable getDrawable(@DrawableRes int id) {
		return ContextCompat.getDrawable(context, id);
	}
}
