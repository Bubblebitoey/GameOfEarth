package com.softspec.finalproj.gameofearth.api.uidialog;

import android.content.Context;
import android.support.annotation.NonNull;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.softspec.finalproj.gameofearth.R;
import com.softspec.finalproj.gameofearth.api.constants.TableName;
import com.softspec.finalproj.gameofearth.api.datastructure.Showable;
import com.softspec.finalproj.gameofearth.model.question.Question;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 10:16 PM
 */
public class QuestionDialog implements Showable {
	private static QuestionDialog dialog;
	private MaterialDialog.Builder builder;
	private MaterialDialog materialDialog;
	private Question q;
	
	private ResultDialog acceptResultDialog;
	private ResultDialog denyResultDialog;
	
	
	private MaterialDialog.SingleButtonCallback positiveOnClick = new MaterialDialog.SingleButtonCallback() {
		@Override
		public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
			acceptResultDialog.setResource(q.getAccept(), TableName.ACCEPTANCE);
			acceptResultDialog.show();
		}
	};
	
	private MaterialDialog.SingleButtonCallback negativeOnClick = new MaterialDialog.SingleButtonCallback() {
		@Override
		public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
			denyResultDialog.setResource(q.getDeny(), TableName.DECLINATION);
			denyResultDialog.show();
		}
	};
	
	public static QuestionDialog getInstance(Question q) {
		if (dialog == null) throw new RuntimeException("No Question dialog before");
		return dialog.setQuestion(q);
	}
	
	public static QuestionDialog getInstance(Context context, Observer observer) {
		if (dialog == null) dialog = new QuestionDialog(context, observer);
		return dialog;
	}
	
	public QuestionDialog setQuestion(Question q) {
		this.q = q;
		
		setTitle();
		setDescription();
		setBtnText();
		
		build();
		
		return this;
	}
	
	private QuestionDialog(Context context, Observer observer) {
		builder = new MaterialDialog.Builder(context);
		
		acceptResultDialog = ResultDialog.getInstance(context, observer);
		denyResultDialog = ResultDialog.getInstance(context, observer);
	}
	
	private void setTitle() {
		builder.title(q.getName());
	}
	
	private void setDescription() {
		builder.content(q.getDescription());
	}
	
	private void setBtnText() {
		builder.positiveText(R.string.accept);
		builder.onPositive(positiveOnClick);
		
		builder.negativeText(R.string.deny);
		builder.onNegative(negativeOnClick);
	}
	
	private void build() {
		materialDialog = builder.cancelable(false).build();
	}
	
	@Override
	public boolean isShown() {
		return materialDialog != null && (materialDialog.isShowing() || acceptResultDialog.isShown() || denyResultDialog.isShown());
	}
	
	@Override
	public void show() {
		materialDialog.show();
	}
}
