package com.bubblebitoey.gameofearth.model.database;

import android.content.Context;
import com.bubblebitoey.gameofearth.api.constants.Value;
import com.bubblebitoey.gameofearth.model.Resource;
import com.bubblebitoey.gameofearth.model.creator.Creator;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class ResourcePopDatabase extends ResourceTypeDatabase {
	public ResourcePopDatabase(Context context, Creator<Resource.ResourceValue> creator) {
		super(context, creator);
	}
	
	@Override
	public String getTableName() {
		return "Population";
	}
	
	@Override
	public Value getType() {
		return Value.POPULATION;
	}
}
