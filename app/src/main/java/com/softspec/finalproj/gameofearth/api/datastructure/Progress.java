package com.softspec.finalproj.gameofearth.api.datastructure;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 6:42 PM
 */
public class Progress {
	private long max;
	private long current;
	
	public Progress(long max) {
		this.max = max;
	}
	
	public void set(long progress) {
		current = progress;
	}
	
	public void add(long progress) {
		if (isComplete()) return;
		current += progress;
	}
	
	public boolean isComplete() {
		return max <= current;
	}
}
