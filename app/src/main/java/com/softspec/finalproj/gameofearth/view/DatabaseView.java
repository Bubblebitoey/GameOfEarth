package com.softspec.finalproj.gameofearth.view;

/**
 * Created by bubblebitoey on 5/25/2017 AD.
 */

public interface DatabaseView {
	void notifyOnChange();
	
	void setMaxProgress(int max);
	
	void updateProgress(int current);
	
	void createProgress();
	
	void removeProgress();
}
