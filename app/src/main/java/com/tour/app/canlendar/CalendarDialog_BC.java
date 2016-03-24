package com.tour.app.canlendar;

import android.app.Dialog;
import android.content.Context;

public abstract class CalendarDialog_BC extends Dialog {

	
	public CalendarDialog_BC(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
	}

//	protected CalendarDialog_MainViewXmlView mainView;
	public CalendarDialog_BC(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	
	protected CalendarDialog_MainViewXmlView mainView;

	protected CameraDialogListener cameraDialogListener;
	
	public void setCameraDialogListener(
			CameraDialogListener cameraDialogListener) {
		this.cameraDialogListener = cameraDialogListener;
	}
	
}
