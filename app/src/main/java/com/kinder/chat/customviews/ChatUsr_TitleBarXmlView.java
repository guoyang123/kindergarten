package com.kinder.chat.customviews;

import android.content.Context;
import android.view.View.OnClickListener;

import com.kinder.chat.viewsxml.ChatUsr_TitleBarXml;

public class ChatUsr_TitleBarXmlView extends ChatUsr_TitleBarXml {

	public ChatUsr_TitleBarXmlView(Context context, float pro, float screenW,
			float screenH) {
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
	}

	public void setListener(OnClickListener onClickListener) {
		// TODO Auto-generated method stub
		this.back_Button.setOnClickListener(onClickListener);
	}

}
