package com.softspec.finalproj.gameofearth.api.constants;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Wed 24/May/2017 - 9:38 PM
 */
public enum TableName {
	QUESTION,
	ACCEPTANCE,
	DECLINATION;
	
	public String getName() {
		return name().toLowerCase(Locale.ENGLISH);
	}
}
