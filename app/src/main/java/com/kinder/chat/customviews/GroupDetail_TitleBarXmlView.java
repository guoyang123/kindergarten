package com.kinder.chat.customviews;

import android.content.Context;

import com.kinder.chat.viewsxml.GroupDetail_TitleBarXml;

public class GroupDetail_TitleBarXmlView extends GroupDetail_TitleBarXml {

	public GroupDetail_TitleBarXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void setListener(OnClickListener onClickListener)
	{
		this.back_Button.setOnClickListener(onClickListener);
		this.rightBtn.setOnClickListener(onClickListener);
	}
}
