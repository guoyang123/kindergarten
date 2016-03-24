package com.kinder.check.customviews;

import android.content.Context;

import com.kinder.check.viewsxml.Check_LeaveTitleBarXml;

public class Check_LeaveTitleBarXmlView extends Check_LeaveTitleBarXml {

	public Check_LeaveTitleBarXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void setListener(OnClickListener onClickListener)
	{
		this.leftBtn.setOnClickListener(onClickListener);
	}
}
