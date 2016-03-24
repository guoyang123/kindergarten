package com.kinder.login.customviews;

import android.content.Context;
import android.view.View.OnClickListener;

import com.kinder.login.viewsxml.KinderTitelBarXml;

public class KinderTitelBarXmlView extends KinderTitelBarXml {

	public KinderTitelBarXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}



	public void setListener(OnClickListener onClickListener)
	{
		//this.back_Button.setOnClickListener(onClickListener);
	}
}
