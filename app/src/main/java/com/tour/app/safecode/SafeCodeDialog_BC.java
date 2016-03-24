package com.tour.app.safecode;

import android.app.Dialog;
import android.content.Context;

public abstract class SafeCodeDialog_BC extends Dialog {

	
	public SafeCodeDialog_BC(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
	}

//	protected CalendarDialog_MainViewXmlView mainView;
	public SafeCodeDialog_BC(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	
	protected SafeCodeDialog_MainViewXmlView mainView;

	protected SafeCodeDialogListener safeCodeDialogListener;
	
	public void setSafeCodeDialogListener(
			SafeCodeDialogListener safeCodeDialogListener) {
		this.safeCodeDialogListener = safeCodeDialogListener;
	}
}
