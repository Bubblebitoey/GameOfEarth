package com.bubblebitoey.gameofearth.model;

import com.bubblebitoey.gameofearth.api.constants.Value;

import java.util.*;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class Resource {
	private long id;
	private Map<Value, Integer> map;
	
	public Resource(Pair... pair) {
		for (Pair p : pair) {
			map.put(p.value, p.integer);
		}
	}
	
	public Resource(long id, Pair... pair) {
		this.id = id;
		for (Pair p : pair) {
			map.put(p.value, p.integer);
		}
	}
	
	public Map<Value, Integer> getMap() {
		return map;
	}
	
	static class Pair {
		private Value value;
		private Integer integer;
		
		public Pair(Value value, Integer integer) {
			this.value = value;
			this.integer = integer;
		}
		
		public Value getValue() {
			return value;
		}
		
		public Integer getInteger() {
			return integer;
		}
	}
}
