package com.bubblebitoey.gameofearth.model.database;

import android.content.Context;
import com.bubblebitoey.gameofearth.api.constants.Value;
import com.bubblebitoey.gameofearth.model.Resource;
import com.bubblebitoey.gameofearth.model.creator.Creator;

/**
 * Created by bubblebitoey on 5/12/2017 AD.
 */

public class ResourceMoneyDatabase extends ResourceTypeDatabase {
	public ResourceMoneyDatabase(Context context, Creator<Resource.ResourceValue> creator) {
		super(context, creator);
	}
	
	@Override
	public String getTableName() {
		return "Money";
	}
	
	@Override
	public Value getType() {
		return Value.MONEY;
	}
}
