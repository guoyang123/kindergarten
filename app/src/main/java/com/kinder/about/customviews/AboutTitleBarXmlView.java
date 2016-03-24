package com.kinder.about.customviews;

import android.content.Context;

import com.kinder.about.viewsxml.AboutTitleBarXml;
import com.kinder.setting.viewsxml.SettingTitleBarXml;

public class AboutTitleBarXmlView extends AboutTitleBarXml {

	public AboutTitleBarXmlView(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}
	
	public void setListener(OnClickListener onClickListener)
	{
		this.leftBtn.setOnClickListener(onClickListener);
	}

}
