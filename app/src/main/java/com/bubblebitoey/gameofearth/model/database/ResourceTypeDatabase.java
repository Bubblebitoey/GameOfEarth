package com.bubblebitoey.gameofearth.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bubblebitoey.gameofearth.api.constants.ResourceType;
import com.bubblebitoey.gameofearth.model.Resource;
import com.bubblebitoey.gameofearth.model.creator.Creator;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 14/May/2017 - 9:41 PM
 */
public abstract class ResourceTypeDatabase extends Database<Resource.ResourceValue> implements ResourceType {
	private static final String ID = "id";
	private static final String VALUE = "value";
	
	public ResourceTypeDatabase(Context context, Creator<Resource.ResourceValue> creator) {
		super(context, creator);
	}
	
	@Override
	public String[] getColumnArray() {
		return new String[]{ID, VALUE};
	}
	
	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		sqLiteDatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " + "%s INTEGER)", getTableName(), ID, VALUE));
	}
}
