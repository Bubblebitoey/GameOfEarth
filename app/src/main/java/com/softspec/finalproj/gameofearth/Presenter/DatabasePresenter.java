package com.softspec.finalproj.gameofearth.Presenter;

import com.softspec.finalproj.gameofearth.api.management.DatabaseManagement;

import java.util.*;

/**
 * Created by bubblebitoey on 5/25/2017 AD.
 */

public class DatabasePresenter implements Observer {
	DatabaseManagement databaseManagement;
	
	@Override
	public void update(Observable o, Object arg) {
	databaseManagement.update(o,arg);
	}
}
