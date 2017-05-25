package com.softspec.finalproj.gameofearth.api.management;

import android.support.annotation.IdRes;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 7:39 PM
 */
public class Leader {
	public static final int ALL_LEADER = 3;
	
	private int current;
	
	public Leader() {
		current = 0;
	}
	
	@IdRes
	public int[] next() {
		switch (current) {
			case 1:
				return new int[]{2, 3};
			case 2:
				return new int[]{1, 3};
			case 3:
				return new int[]{1, 2};
			default:
				return new int[]{1, 2, 3};
		}
	}
}
