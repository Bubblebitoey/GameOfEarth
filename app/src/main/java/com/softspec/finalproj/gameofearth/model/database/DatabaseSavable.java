package com.softspec.finalproj.gameofearth.model.database;

import android.content.ContentValues;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public interface DatabaseSavable {
	ContentValues getInsertQuery();
}
