package com.tour.app.camera;

import android.content.Context;

public class CameraDialog_MainViewXmlView extends CameraDialog_MainViewXml {

	public CameraDialog_MainViewXmlView(Context context, float pro,
			float screenW, float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	/**设置监听*/
	public void setListener(OnClickListener listener)
	{
		this.camera_Button.setOnClickListener(listener);
		this.photo_Button.setOnClickListener(listener);
		this.cancel_Button.setOnClickListener(listener);
	}
}
