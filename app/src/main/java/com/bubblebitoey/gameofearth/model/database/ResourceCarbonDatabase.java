package com.bubblebitoey.gameofearth.model.database;

import android.content.Context;
import com.bubblebitoey.gameofearth.api.constants.Value;
import com.bubblebitoey.gameofearth.model.creator.Creator;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class ResourceCarbonDatabase extends ResourceTypeDatabase {
	public ResourceCarbonDatabase(Context context, Creator creator) {
		super(context, creator);
	}
	
	@Override
	public String getTableName() {
		return "Carbon";
	}
	
	@Override
	public Value getType() {
		return Value.CO2;
	}
}
