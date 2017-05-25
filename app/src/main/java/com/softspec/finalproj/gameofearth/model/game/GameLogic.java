package com.softspec.finalproj.gameofearth.model.game;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.softspec.finalproj.gameofearth.api.datastructure.Percent;
import com.softspec.finalproj.gameofearth.api.management.ImageManagement;
import com.softspec.finalproj.gameofearth.model.strategy.CO2Strategy;
import com.softspec.finalproj.gameofearth.model.strategy.CityStrategy;
import com.softspec.finalproj.gameofearth.model.strategy.GameStrategy;
import com.softspec.finalproj.gameofearth.model.strategy.PopulationStrategy;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 4:57 PM
 */
public class GameLogic extends Observable implements Serializable {
	public static long serialVersionUID = 1L;
	
	private static final long UPDATE_POPULATION_SECOND = 3;
	
	/**
	 * {@value UPDATE_DATE_SECOND} second = 1 day
	 */
	private static final long UPDATE_DATE_SECOND = 10;
	private static final ScheduledExecutorService runService = Executors.newScheduledThreadPool(20);
	
	private GameStrategy gameStrategy;
	private CityStrategy cityStrategy;
	private CO2Strategy co2Strategy;
	private PopulationStrategy populationStrategy;
	
	/**
	 * current population
	 */
	private long currentPopulation;
	/**
	 * number of co2
	 */
	private long co2;
	/**
	 * percent of increasing population (per 5 second)
	 */
	private Percent population;
	
	/**
	 * current date
	 */
	private Calendar date;
	
	private ImageManagement imageManagement;
	
	public GameLogic(Context c, GameStrategy gameStrategy, CityStrategy cityStrategy, CO2Strategy co2Strategy, PopulationStrategy populationStrategy) {
		this.gameStrategy = gameStrategy;
		this.cityStrategy = cityStrategy;
		this.co2Strategy = co2Strategy;
		this.populationStrategy = populationStrategy;
		
		currentPopulation = 100;
		co2 = gameStrategy.getDefaultCO2();
		population = gameStrategy.getDefaultPopulation();
		date = gameStrategy.getDefaultDate();
		
		imageManagement = new ImageManagement(c, this);
	}
	
	public long getCurrentPopulation() {
		return currentPopulation;
	}
	
	public GameStrategy getGameStrategy() {
		return gameStrategy;
	}
	
	public CityStrategy getCityStrategy() {
		return cityStrategy;
	}
	
	public CO2Strategy getCo2Strategy() {
		return co2Strategy;
	}
	
	public PopulationStrategy getPopulationStrategy() {
		return populationStrategy;
	}
	
	public long getCo2() {
		return co2;
	}
	
	public Percent getPopulation() {
		return population;
	}
	
	public void addPopulation(Percent percent) {
		population.add(percent);
	}
	
	public void removePopulation(Percent percent) {
		population.remove(percent);
	}
	
	public void updateCO2(long add) {
		co2 += add;
	}
	
	public Drawable getCity() {
		return imageManagement.getCity();
	}
	
	public Drawable getDefaultCity() {
		return imageManagement.getDefaultCity();
	}
	
	public Drawable getLight() {
		return imageManagement.getLightBulb();
	}
	
	public long getDate() {
		// get total date
		return date.get(Calendar.DAY_OF_YEAR) + (365 * (date.get(Calendar.YEAR) - gameStrategy.getDefaultDate().get(Calendar.YEAR)));
	}
	
	public void startGame() {
		runService.scheduleWithFixedDelay(getUpdatePopTask(), UPDATE_POPULATION_SECOND, UPDATE_POPULATION_SECOND, TimeUnit.SECONDS);
		runService.scheduleWithFixedDelay(getUpdateDateTask(), UPDATE_DATE_SECOND, UPDATE_DATE_SECOND, TimeUnit.SECONDS);
	}
	
	public void stopGame() {
		runService.shutdownNow();
	}
	
	public boolean isGameOver() {
		return gameStrategy.gameOver(currentPopulation);
	}
	
	private Runnable getUpdatePopTask() {
		return new Runnable() {
			@Override
			public void run() {
				long add = (long) Math.ceil(currentPopulation * population.percent()); // increase
				long decrease1 = (long) Math.ceil(currentPopulation * populationStrategy.calculationFromCO2(co2).percent()); // decrease;
				// update pop
				currentPopulation += add;
				currentPopulation -= decrease1;
				
				// update co2, population
				updateCO2((long) Math.ceil(co2Strategy.calculationFromPopulation(currentPopulation).percent()));
				removePopulation(populationStrategy.calculationToThis(co2));
				
				// notify observer
				setChanged();
				notifyObservers();
				// log
				Log.i("UPDATE", "population: " + population + ", co2: " + co2);
				Log.i("CURRENT POPULATION", "ADD: " + add + ", SUB1: " + decrease1 + ", RESULT: " + String.valueOf(currentPopulation));
			}
		};
	}
	
	private Runnable getUpdateDateTask() {
		return new Runnable() {
			@Override
			public void run() {
				date.set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH) + 1);
				setChanged();
				notifyObservers();
				Log.i("UPDATE DATE TO", String.valueOf(getDate()));
			}
		};
	}
}
