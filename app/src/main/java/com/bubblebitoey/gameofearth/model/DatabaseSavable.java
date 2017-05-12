package com.bubblebitoey.gameofearth.model;

import android.content.ContentValues;
import com.bubblebitoey.gameofearth.model.database.Database;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public interface DatabaseSavable<T extends Database> {
	ContentValues getQuery(T db);
}
