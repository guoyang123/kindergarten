package com.kinder.chat.customviews;

import com.kinder.chat.viewsxml.ContactUser_TitleBarXml;

import android.content.Context;
import android.view.View.OnClickListener;

public class ContactUser_TitleBarXmlView extends ContactUser_TitleBarXml {

	public ContactUser_TitleBarXmlView(Context context, float pro,
			float screenW, float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void setListener(OnClickListener onClickListener)
	{
		this.back_Button.setOnClickListener(onClickListener);
	}
}
