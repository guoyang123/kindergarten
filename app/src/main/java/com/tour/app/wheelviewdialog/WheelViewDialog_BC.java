package com.tour.app.wheelviewdialog;

import android.app.Dialog;
import android.content.Context;

public abstract class WheelViewDialog_BC extends Dialog {

	
	public WheelViewDialog_BC(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
	}

//	protected CalendarDialog_MainViewXmlView mainView;
	public WheelViewDialog_BC(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	
	protected WheelViewDialog_MainViewXmlView mainView;

	protected WheelViewDialogListener wheelViewDialogListener;
	
	public void setWheelViewDialogListener(
			WheelViewDialogListener wheelViewDialogListener) {
		this.wheelViewDialogListener = wheelViewDialogListener;
	}
}
