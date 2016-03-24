package com.kinder.menu.customviews;

import android.content.Context;
import android.view.View.OnClickListener;

import com.kinder.menu.viewsxml.Chat_TitleBarXml;

public class Chat_TitleBarXmlView extends Chat_TitleBarXml {

	public Chat_TitleBarXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void setListener(OnClickListener onClickListener)
	{
		this.rightBtn.setOnClickListener(onClickListener);
	}
}
