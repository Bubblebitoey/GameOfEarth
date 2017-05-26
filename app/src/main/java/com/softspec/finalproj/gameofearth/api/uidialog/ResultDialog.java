package com.softspec.finalproj.gameofearth.api.uidialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.softspec.finalproj.gameofearth.R;
import com.softspec.finalproj.gameofearth.api.constants.TableName;
import com.softspec.finalproj.gameofearth.api.datastructure.Showable;
import com.softspec.finalproj.gameofearth.model.resource.Resource;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 11:15 PM
 */
public class ResultDialog extends Observable implements Showable {
	private static ResultDialog dialog;
	
	private MaterialDialog.Builder builder;
	private MaterialDialog materialDialog;
	private Resource r;
	
	public static ResultDialog getInstance(Resource r, TableName type) {
		if (dialog == null) throw new RuntimeException("No Result dialog before");
		return dialog.setResource(r, type);
	}
	
	public static ResultDialog getInstance(Context c, Observer o) {
		if (dialog == null) dialog = new ResultDialog(c, o);
		return dialog;
	}
	
	public ResultDialog setResource(Resource r, TableName type) {
		this.r = r;
		
		builder = new MaterialDialog.Builder(builder.getContext());
		
		setTitle(type);
		setList();
		setBtn();
		
		build();
		
		return this;
	}
	
	private ResultDialog(Context context, Observer observer) {
		builder = new MaterialDialog.Builder(context);
		addObserver(observer);
	}
	
	private void setTitle(TableName type) {
		Log.d("SET TITLE", type.getName());
		switch (type) {
			case ACCEPTANCE:
				builder.title(R.string.result_accept);
				break;
			case DECLINATION:
				builder.title(R.string.result_deny);
				break;
		}
	}
	
	private void setList() {
		Log.d("SET List", r.toString());
		String co2 = String.format(Locale.ENGLISH, "Carbon: %d", r.getCo2());
		String pop = String.format(Locale.ENGLISH, "Growth: %d%%", r.getPop());
		builder.items(co2, pop);
	}
	
	private void setBtn() {
		builder.positiveText(R.string.ok);
		builder.onPositive(new MaterialDialog.SingleButtonCallback() {
			@Override
			public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
				setChanged();
				notifyObservers(r);
			}
		});
	}
	
	public void build() {
		try {
			materialDialog = builder.canceledOnTouchOutside(true).build();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean isShown() {
		return materialDialog != null && materialDialog.isShowing();
	}
	
	@Override
	public void show() {
		materialDialog.show();
	}
}
