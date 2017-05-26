package com.softspec.finalproj.gameofearth.api.management;

import com.softspec.finalproj.gameofearth.api.constants.LightBulb;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 7:39 PM
 */
public class Leader {
	public static final int ALL_LEADER = 3;
	
	private LightBulb current;
	
	public void setCurrent(LightBulb current) {
		this.current = current;
	}
	
	public LightBulb[] next() {
		if (current == null) return new LightBulb[]{LightBulb.BULB_1, LightBulb.BULB_2, LightBulb.BULB_3};
		switch (current) {
			case BULB_1:
				return new LightBulb[]{LightBulb.BULB_2, LightBulb.BULB_3};
			case BULB_2:
				return new LightBulb[]{LightBulb.BULB_1, LightBulb.BULB_3};
			case BULB_3:
				return new LightBulb[]{LightBulb.BULB_1, LightBulb.BULB_2};
			default:
				return new LightBulb[]{LightBulb.BULB_1, LightBulb.BULB_2, LightBulb.BULB_3};
		}
	}
}
