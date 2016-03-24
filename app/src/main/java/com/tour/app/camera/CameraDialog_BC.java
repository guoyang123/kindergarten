package com.tour.app.camera;

import android.app.Dialog;
import android.content.Context;

public abstract class CameraDialog_BC extends Dialog {

	
	public CameraDialog_BC(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
	}

//	protected CalendarDialog_MainViewXmlView mainView;
	public CameraDialog_BC(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	
	protected CameraDialog_MainViewXmlView mainView;

	protected CameraDialogListener cameraDialogListener;
	
	public void setCameraDialogListener(
			CameraDialogListener cameraDialogListener) {
		this.cameraDialogListener = cameraDialogListener;
	}
}
