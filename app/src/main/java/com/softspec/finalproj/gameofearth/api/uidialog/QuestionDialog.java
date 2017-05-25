package com.softspec.finalproj.gameofearth.api.uidialog;

import android.content.Context;
import android.support.annotation.NonNull;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.softspec.finalproj.gameofearth.R;
import com.softspec.finalproj.gameofearth.api.datastructure.Showable;
import com.softspec.finalproj.gameofearth.model.question.Question;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 10:16 PM
 */
public class QuestionDialog extends Observable implements Showable {
	private MaterialDialog.Builder builder;
	private Question q;
	
	private MaterialDialog.SingleButtonCallback positiveOnClick = new MaterialDialog.SingleButtonCallback() {
		@Override
		public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
			setChanged();
			notifyObservers(q.getAccept());
		}
	};
	
	private MaterialDialog.SingleButtonCallback negativeOnClick = new MaterialDialog.SingleButtonCallback() {
		@Override
		public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
			notifyObservers(q.getDeny());
		}
	};
	
	public QuestionDialog(Context context, Question q) {
		this.q = q;
		builder = new MaterialDialog.Builder(context);
		
		setTitle();
		setDescription();
		setBtnText();
	}
	
	private void setTitle() {
		builder.title(q.getName());
	}
	
	private void setDescription() {
		builder.title(q.getDescription());
	}
	
	private void setBtnText() {
		builder.positiveText(R.string.accept);
		builder.onPositive(positiveOnClick);
		
		builder.negativeText(R.string.deny);
		builder.onNegative(negativeOnClick);
	}
	
	@Override
	public void show() {
		builder.build().show();
	}
}
