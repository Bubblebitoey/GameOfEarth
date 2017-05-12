package com.bubblebitoey.gameofearth.model;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class Question {
	private long id;
	private String name;
	private String description;
	
	private Resource accept;
	private Resource reject;
	
	public Question(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Question(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Question setAccept(Resource accept) {
		this.accept = accept;
		return this;
	}
	
	public Question setReject(Resource reject) {
		this.reject = reject;
		return this;
	}
}
