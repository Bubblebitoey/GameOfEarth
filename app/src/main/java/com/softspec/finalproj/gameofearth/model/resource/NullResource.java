package com.softspec.finalproj.gameofearth.model.resource;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 4:04 PM
 */
public class NullResource extends Resource {
	public NullResource(long id) {
		super(id);
	}
	
	@Override
	public long getCo2() {
		return 0;
	}
	
	@Override
	public long getPop() {
		return 0;
	}
}
