package com.kinder.mycollect.customviews;

import android.content.Context;

import com.kinder.mycollect.viewsxml.MyCollect_TitleBarXml;
import com.kinder.parent.viewsxml.ParentDetail_TitleBarXml;

public class MyCollect_TitleBarXmlView extends MyCollect_TitleBarXml {

	public MyCollect_TitleBarXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void setListener(OnClickListener onClickListener)
	{
		this.back_Button.setOnClickListener(onClickListener);
	}
}
