package com.kinder.parent.customviews;

import android.content.Context;

import com.kinder.parent.viewsxml.ParentDetail_TitleBarXml;

public class ParentDetail_TitleBarXmlView extends ParentDetail_TitleBarXml {

	public ParentDetail_TitleBarXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void setListener(OnClickListener onClickListener)
	{
		this.back_Button.setOnClickListener(onClickListener);
	}
}
