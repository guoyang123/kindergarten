package com.kinder.menu.customviews;

import android.content.Context;

import com.kinder.menu.viewsxml.Check_TitleBarXml;

public class Check_TitleBarXmlView extends Check_TitleBarXml {

	public Check_TitleBarXmlView(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void setListener(OnClickListener onClickListener)
	{
		this.rightBtn.setOnClickListener(onClickListener);
	}
}
