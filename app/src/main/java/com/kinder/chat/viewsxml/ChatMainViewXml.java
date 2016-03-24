package com.kinder.chat.viewsxml;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.myt360.app.customviews.MyRelativeLayout;


public class ChatMainViewXml extends MyRelativeLayout {

	public ChatMainViewXml(Context context, float pro, float screenW,
			float screenH) 
	{
		super(context, pro, screenW, screenH);
		// TODO Auto-generated constructor stub
		
		RelativeLayout wrap=productRelativeLayout(context, pro, 101,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,
				0, 0, 0, 0, 
				0, 0, 0, 
				0, 0, 0, 0,
				0, 0, 0, 0, this);
				
				productTextView(context, pro, 102,
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
						0, 0, 0, 0,
						0, 0, 0,
						0, 0, 0, 0, 
						"聊天", 15, "#000000", wrap);
	}

}
