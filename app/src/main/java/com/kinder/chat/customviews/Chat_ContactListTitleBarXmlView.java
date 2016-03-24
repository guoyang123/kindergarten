package com.kinder.chat.customviews;

import android.content.Context;

import com.kinder.chat.viewsxml.Chat_ContactListTitleBarXml;

public class Chat_ContactListTitleBarXmlView extends
		Chat_ContactListTitleBarXml {

	public Chat_ContactListTitleBarXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	
   public void 	setlistener(OnClickListener onClickListener)
	{
		this.leftBtn.setOnClickListener(onClickListener);
	}
}
